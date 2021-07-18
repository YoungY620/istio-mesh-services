package cn.yy.javaservicev2.controller;

import cn.yy.javaservicev2.dto.common.ResponseBean;
import cn.yy.javaservicev2.service.ReportViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/report-view")
public class ReportViewController {
    @Autowired
    ReportViewService reportViewService;

    @GetMapping("/init/{empID}")
    public ResponseBean<?> init(@PathVariable("empID") String empID) {
        return reportViewService.init(empID);
    }

    @GetMapping("/query")
    public ResponseBean<?> conditionQuery(@RequestParam Map<String, Object> condMap){
        return reportViewService.conditionQuery(condMap);
    }
}
