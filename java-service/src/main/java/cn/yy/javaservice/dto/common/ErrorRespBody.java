package cn.yy.javaservice.dto.common;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class ErrorRespBody implements Serializable {
    private String reason;
    private String detail;
}
