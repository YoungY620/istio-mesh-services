use serde::{Deserialize, Serialize};

#[derive(Deserialize, Serialize, Debug)]
pub struct RespBean<T> {
    status: String,
    body: T,
}

#[derive(Deserialize, Serialize, Debug)]
pub struct ErrBody {
    reason: String,
    detail: String,
}
