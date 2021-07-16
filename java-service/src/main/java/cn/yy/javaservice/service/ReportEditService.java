package cn.yy.javaservice.service;

import cn.yy.javaservice.dto.common.ResponseBean;
import cn.yy.javaservice.dto.relation.Worklog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Service
public class ReportEditService {
    @Autowired
    RestTemplate restTemplate;

    private final Logger logger = LoggerFactory.getLogger(HandoverService.class);

    private static final String BASE_URL = "http://59.110.161.6:8001/relationship";

    public ResponseBean<?> init(String empID){
        final String url = BASE_URL+"/init/"+empID;
        logger.info("request to:" + url);
        ResponseBean<?> responseBean = restTemplate.getForObject(url,ResponseBean.class);
        logger.info("Got response: "+ responseBean);
        return responseBean;
    }

    public ResponseBean<?> newReport( Worklog worklog){
        final String url = BASE_URL + "/new";
        logger.info("request url" + url);
        ResponseBean<?> responseBean = restTemplate.postForObject(url, worklog, ResponseBean.class);
        logger.info("response: "+responseBean);
        return responseBean;
    }

    public ResponseBean<?> updateReport(Worklog worklog){
        final String url = BASE_URL + "/update";
        logger.info("request url: "+ url);
        ResponseBean<?> responseBean = restTemplate.postForObject(url, worklog, ResponseBean.class);
        logger.info("response: "+responseBean);
        return responseBean;
    }
}
