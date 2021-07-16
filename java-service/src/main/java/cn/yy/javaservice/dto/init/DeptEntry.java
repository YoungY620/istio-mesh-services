package cn.yy.javaservice.dto.init;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class DeptEntry implements Serializable {
    private String id;
    private String deptName;
    List<CusMgrEntry> cusMgrs;
}
