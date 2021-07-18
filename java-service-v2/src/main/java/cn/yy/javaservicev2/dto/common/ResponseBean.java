package cn.yy.javaservicev2.dto.common;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class ResponseBean <T> implements Serializable {
    private String status;
    private T body;
}
