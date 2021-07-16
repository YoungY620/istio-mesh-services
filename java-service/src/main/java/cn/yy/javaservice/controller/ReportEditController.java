package cn.yy.javaservice.controller;


import cn.yy.javaservice.dto.common.ResponseBean;
import cn.yy.javaservice.dto.relation.Worklog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/report-edit")
public class ReportEditController {
    @Autowired
    ReportEditController reportEditController;

    @GetMapping("/init/{empID}")
    public ResponseBean<?> init(@PathVariable("empID") String empID){
        return reportEditController.init(empID);
    }

    @RequestMapping(value = "/new",method = RequestMethod.POST)
    public ResponseBean<?> newReport(@RequestBody Worklog worklog){
        return reportEditController.newReport(worklog);
    }

    @PostMapping("/update")
    public ResponseBean<?> updateReport(@RequestBody Worklog worklog){
        return reportEditController.updateReport(worklog);
    }
}
