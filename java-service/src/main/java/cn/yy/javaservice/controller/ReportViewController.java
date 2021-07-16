package cn.yy.javaservice.controller;

import cn.yy.javaservice.dto.common.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/report-view")
public class ReportViewController {
    @Autowired
    ReportViewController reportViewController;

    @GetMapping("/init/{empID}")
    public ResponseBean<?> init(@PathVariable("empID") String empID) {
        return reportViewController.init(empID);
    }

    @GetMapping("/query")
    public ResponseBean<?> conditionQuery(@RequestParam Map<String, Object> condMap){
        return reportViewController.conditionQuery(condMap);
    }
}
