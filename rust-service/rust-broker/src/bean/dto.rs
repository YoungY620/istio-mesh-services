use serde::{Deserialize, Serialize};

#[derive(Deserialize, Serialize, Debug)]
pub struct CusMgrEntry {
    #[serde(rename = "empID")]
    emp_id: String,
    #[serde(rename = "empName")]
    emp_name: String,
}

#[derive(Deserialize, Serialize, Debug)]
pub struct DeptEntry {
    id: String,
    #[serde(rename = "deptName")]
    dept_name: String,
    #[serde(rename = "cusMgrs")]
    cus_mgrs: Vec<CusMgrEntry>,
}

#[derive(Deserialize, Serialize, Debug)]
pub struct InitDBody {
    depts: Vec<DeptEntry>,
}