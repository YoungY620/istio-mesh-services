package cn.yy.javaservicev2.service;

import cn.yy.javaservicev2.dto.common.ResponseBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class HandoverService {
    @Autowired
    RestTemplate restTemplate;

    private final Logger logger = LoggerFactory.getLogger(HandoverService.class);

    private static final String BASE_URL = "http://59.110.161.6:8001/handover";

    public ResponseBean<?> init(String empID){
        final String url = "http://127.0.0.1:443/handover/init?empID=" + empID;
        ResponseBean<?> responseBean = restTemplate.getForObject(url, ResponseBean.class);
        logger.info("Got response: " + responseBean);
        return responseBean;
    }

    public ResponseBean<?> conditionQuery(Map<String, String> condMap) {
        final String url = BASE_URL+"/query";
        ResponseBean<?> responseBean = restTemplate.getForObject(url,ResponseBean.class,condMap);
        logger.info("request to: "+ url);
        logger.info("Got response: "+responseBean);
        return responseBean;
    }
}
