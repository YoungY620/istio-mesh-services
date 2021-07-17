use std::convert::Infallible;

use hyper::{Server};
use hyper::service::{make_service_fn, service_fn};

use controller::{server_impl, shutdown_signal};

use crate::config::{SERVER_ADDRESS};
use std::net::ToSocketAddrs;

mod service;
mod controller;
mod config;
mod bean;

extern crate  hyper;

#[tokio::main]
async fn main() {
    // A `Service` is needed for every connection, so this
    // creates one from our `service_impl` function.
    let make_svc = make_service_fn(|_conn| async {
        // service_fn converts our function into a `Service`
        Ok::<_, Infallible>(service_fn(server_impl))
    });

    let addr = &SERVER_ADDRESS.to_owned().to_socket_addrs().unwrap().next().unwrap();
    let server = Server::bind(addr).serve(make_svc);

    // And now add a graceful shutdown signal...
    let graceful = server.with_graceful_shutdown(shutdown_signal());

    println!("running on http://{}", SERVER_ADDRESS);
    // Run this server for... forever!
    if let Err(e) = graceful.await {
        eprintln!("server error: {}", e);
    }
}
