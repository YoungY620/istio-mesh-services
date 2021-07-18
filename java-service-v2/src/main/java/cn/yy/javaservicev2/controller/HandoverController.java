package cn.yy.javaservicev2.controller;

import cn.yy.javaservicev2.dto.common.ResponseBean;
import cn.yy.javaservicev2.service.HandoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/handover")
public class HandoverController {
    @Autowired
    HandoverService handoverService;

    @GetMapping("/init/{empID}")
    ResponseBean<?> init(@PathVariable("empID") String empID){
        return handoverService.init(empID);
    }

    @GetMapping("/query")
    ResponseBean<?> conditionQuery(@RequestParam Map<String, String> condMap) {
        return handoverService.conditionQuery(condMap);
    }
}
