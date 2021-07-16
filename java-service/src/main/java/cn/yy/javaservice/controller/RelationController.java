package cn.yy.javaservice.controller;


import cn.yy.javaservice.dto.common.ResponseBean;
import cn.yy.javaservice.service.RelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/relationship")
public class RelationController {
    @Autowired
    RelationService relationService;

    @GetMapping("/init/{empID}")
    public ResponseBean<?> init(@PathVariable("empID") String empID){
        return relationService.init(empID);
    }

    @GetMapping("/query")
    public ResponseBean<?> conditionQuery(@RequestParam Map<String, String> condMap){
        return relationService.conditionQuery(condMap);
    }
}
