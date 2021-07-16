package cn.yy.javaservice.dto.handover;

import lombok.Data;

import java.io.Serializable;

@Data
public class CusHandoverHisEntry  implements Serializable {
    private String oppoID;
    private String oppoName;
    private String outDeptName;
    private String outCusMgrName;
    private String inDeptName;
    private String inCusMgrName;
    private String cusID;
    private String cusName;
}
