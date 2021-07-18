package cn.yy.javaservicev2.dto.relation;

import lombok.Data;

import java.io.Serializable;

@Data
public class RelCusEntry  implements Serializable {
    private String relCusID;
    private String relCusName;
    private String relDetail;
}
