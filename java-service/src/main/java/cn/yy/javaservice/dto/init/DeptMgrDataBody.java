package cn.yy.javaservice.dto.init;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class DeptMgrDataBody  implements Serializable {
    List<DeptEntry> depts;
}
