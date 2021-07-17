use crate::bean::resp::{RespBean, ErrBody};

pub mod handover;

type ShortResult<T> = reqwest::Result<
    Result<
        RespBean<T>,
        RespBean<ErrBody>
    >
>;