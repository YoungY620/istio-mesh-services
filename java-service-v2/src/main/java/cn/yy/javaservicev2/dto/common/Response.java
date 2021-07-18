package cn.yy.javaservicev2.dto.common;

import java.io.Serializable;

public class Response  implements Serializable {
    public final static String STATE_OK = "200";
    public final static String STATE_ERR = "500";
    public final static ResponseBean<ErrorRespBody> defaultErr;
    public final static ResponseBean<Object> defaultOk;
    static {
        defaultErr = new ResponseBean<>();
        ErrorRespBody errorRespBody = new ErrorRespBody();
        errorRespBody.setReason("未定义错误");
        defaultErr.setBody(errorRespBody);

        defaultOk = new ResponseBean<>();
        defaultOk.setStatus("200");
    }

    public static ResponseBean<ErrorRespBody> simpleErr(String reason, String detail){
        ResponseBean<ErrorRespBody> responseBean = new ResponseBean<>();
        responseBean.setStatus(STATE_ERR);
        responseBean.setBody(new ErrorRespBody());
        responseBean.getBody().setReason(reason);
        responseBean.getBody().setDetail(detail);
        return responseBean;
    }

    public static <T> ResponseBean<T> simpleOk(T body){
        ResponseBean<T> responseBean = new ResponseBean<>();
        responseBean.setStatus(STATE_OK);
        responseBean.setBody(null);
        return responseBean;
    }
}
