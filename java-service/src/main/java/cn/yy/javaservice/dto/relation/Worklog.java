package cn.yy.javaservice.dto.relation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Worklog implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    private Integer wId;

    @JsonProperty("time")
    private LocalDateTime wTime;

    @JsonProperty("content")
    private String wContent;

    @JsonProperty("dept_id")
    private String wDeptId;

    @JsonProperty("cus_mgr_id")
    private String wCusMgrId;

}
