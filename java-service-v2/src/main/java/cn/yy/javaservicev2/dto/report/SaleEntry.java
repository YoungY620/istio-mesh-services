package cn.yy.javaservicev2.dto.report;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class SaleEntry  implements Serializable {
    private long reportID;
    private String deptName;
    private String deptID;
    private String cusMgrID;
    private String cusMgrName;
    private LocalDateTime time;
    private String content;
    
}
