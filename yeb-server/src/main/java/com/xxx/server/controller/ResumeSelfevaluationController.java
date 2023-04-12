package com.xxx.server.controller;


import com.xxx.server.pojo.RespBean;
import com.xxx.server.pojo.ResumeProjects;
import com.xxx.server.pojo.ResumeSelfevaluation;
import com.xxx.server.service.IResumeProjectsService;
import com.xxx.server.service.IResumeSelfevaluationService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author mean
 * @since 2023-04-05
 */
@RestController
@RequestMapping("/resume-selfevaluation")
public class ResumeSelfevaluationController {

    @Autowired
    private IResumeSelfevaluationService resumeSelfevaluationService;

    @ApiOperation("根据resume_id获取SelfEvaluation")
    @GetMapping("/getSelfEvaluationByResumeId/{resume_id}")
    public RespBean getSelfEvaluationByResumeId(@PathVariable Integer resume_id){

        return resumeSelfevaluationService.getEducationByResumeId(resume_id);
    }

    @ApiOperation("更新或添加selfEvaluation")
    @PostMapping("/saveOrUpdate")
    public RespBean saveOrUpdate(@RequestBody ResumeSelfevaluation resumeSelfevaluation){

        if(true==resumeSelfevaluationService.saveOrUpdate(resumeSelfevaluation)){
            return RespBean.success("success");
        }
        return RespBean.error("error");
    }


}
