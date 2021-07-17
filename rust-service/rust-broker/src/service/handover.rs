use crate::bean::resp::{RespBean, ErrBody};
use crate::config::REQUEST_BASE_URL;
use crate::bean::dto::InitDBody;
use crate::service::ShortResult;

pub async fn init(emp_id: &str) -> ShortResult<InitDBody>{
    let mut target = REQUEST_BASE_URL.to_owned();
    // target.extend("/handover/init".chars()).extend(emp_id.chars());
    target = target + "/handover/init/".as_ref() + emp_id;

    let body_str = reqwest::get(target).await?
        .text().await?;
    let body_str = body_str.as_str();
    match serde_json::from_str::<RespBean<InitDBody>>(body_str) {
        Ok(body) => Ok(Ok(body)),
        Err(_e) => {
            let body: RespBean<ErrBody> =
                serde_json::from_str(body_str).unwrap();
            Ok(Err(body))
        }
    }
}
