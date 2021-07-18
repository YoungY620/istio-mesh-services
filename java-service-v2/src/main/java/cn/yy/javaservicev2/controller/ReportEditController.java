package cn.yy.javaservicev2.controller;

import cn.yy.javaservicev2.dto.common.ResponseBean;
import cn.yy.javaservicev2.dto.relation.Worklog;
import cn.yy.javaservicev2.service.ReportEditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/report-edit")
public class ReportEditController {
    @Autowired
    ReportEditService reportEditService;

    @GetMapping("/init/{empID}")
    public ResponseBean<?> init(@PathVariable("empID") String empID){
        return reportEditService.init(empID);
    }

    @RequestMapping(value = "/new",method = RequestMethod.POST)
    public ResponseBean<?> newReport(@RequestBody Worklog worklog){
        return reportEditService.newReport(worklog);
    }

    @PostMapping("/update")
    public ResponseBean<?> updateReport(@RequestBody Worklog worklog){
        return reportEditService.updateReport(worklog);
    }
}
