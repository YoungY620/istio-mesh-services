use hyper::{Body, Request, Response, StatusCode};

use crate::service;
use crate::controller::query_decode;

pub async fn handover_init(req: &Request<Body>, response: &mut Response<Body>)
    -> Result<(), hyper::Error>{
    if let Some(param) = req.uri().query() {
        let p_map = query_decode(param);
        if !p_map.contains_key(&String::from("empID")) {
            *response.status_mut() = StatusCode::NOT_FOUND;
            return Ok(());
        }

        let resp_res =
            match service::handover::init(&*p_map[&String::from("empID")])
                .await {
            Err(_) => {
                *response.status_mut() = StatusCode::SERVICE_UNAVAILABLE;
                return Ok(())
            },
            Ok(r) => r
        };
        let body_json = match resp_res {
            Ok(r) => {
                serde_json::to_string(&r).unwrap()
            }
            Err(e) => {
                serde_json::to_string(&e).unwrap()
            }
        };
        (*response.headers_mut()).insert(hyper::header::CONTENT_TYPE, "application/json".parse().unwrap());
        (*response.headers_mut()).insert(hyper::header::ACCEPT_CHARSET, "UTF-8".parse().unwrap());
        *response.body_mut() = Body::from(body_json);
    } else {
        *response.status_mut() = StatusCode::NOT_FOUND;
    }
    Ok(())
}
