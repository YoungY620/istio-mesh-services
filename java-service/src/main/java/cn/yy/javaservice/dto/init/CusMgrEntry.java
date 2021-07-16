package cn.yy.javaservice.dto.init;

import lombok.Data;

import java.io.Serializable;

@Data
public class CusMgrEntry  implements Serializable {
    private String empID;
    private String empName;
}
