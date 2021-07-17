use futures::TryStreamExt;
use hyper::{Body, Method, Request, Response, StatusCode};

use std::collections::HashMap;

mod handover;

pub async fn server_impl(req: Request<Body>) -> Result<Response<Body>, hyper::Error> {
    // Ok(Response::new("Hello, World".into()))
    let mut response = Response::new(Body::empty());

    match (req.method(), req.uri().path()) {
        (&Method::GET, "/handover/init") => {
            handover::handover_init(&req, &mut response).await?;
        },
        (&Method::GET, "/") => {
            *response.body_mut() = Body::from("Try POSTing data to /echo");
        },
        (&Method::POST, "/echo/uppercase") => {
            // This is actually a new `futures::Stream`...
            let mapping = req
                .into_body()
                .map_ok(|chunk| {
                    chunk.iter()
                        .map(|byte| byte.to_ascii_uppercase())
                        .collect::<Vec<u8>>()
                });

            // Use `Body::wrap_stream` to convert it to a `Body`...
            *response.body_mut() = Body::wrap_stream(mapping);
        },
        (&Method::POST, "/echo/reverse") => {
            // Await the full body to be concatenated into a single `Bytes`...
            let full_body = hyper::body::to_bytes(req.into_body()).await?;

            // Iterate the full body in reverse order and collect into a new Vec.
            let reversed = full_body.iter()
                .rev()
                .cloned()
                .collect::<Vec<u8>>();

            *response.body_mut() = reversed.into();
        },
        _ => {
            *response.status_mut() = StatusCode::NOT_FOUND;
        }
    };

    Ok(response)
}

pub async fn shutdown_signal() {
    // Wait for the CTRL+C signal
    tokio::signal::ctrl_c()
        .await
        .expect("failed to install CTRL+C signal handler");
}

fn query_decode(query: &str) -> HashMap<String, String> {
    let entries: Vec<&str> = query.split("&").collect();
    let mut map:HashMap<String, String> = HashMap::new();
    for e in entries {
        let kv: Vec<&str> = e.split("=").collect();
        map.insert(kv[0].into(), kv[1].into());
    }
    map
}