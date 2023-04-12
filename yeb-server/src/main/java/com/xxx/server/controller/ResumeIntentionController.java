package com.xxx.server.controller;


import com.xxx.server.pojo.RespBean;
import com.xxx.server.pojo.ResumeEducation;
import com.xxx.server.pojo.ResumeIntention;
import com.xxx.server.service.IResumeEducationService;
import com.xxx.server.service.IResumeIntentionService;
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
@RequestMapping("/resume-intention")
public class ResumeIntentionController {

    @Autowired
    private IResumeIntentionService resumeIntentionService;

    @ApiOperation("根据resume_id获取intention")
    @GetMapping("/getIntentionByResumeId/{resume_id}")
    public RespBean getIntentionByResumeId(@PathVariable Integer resume_id){

        return resumeIntentionService.getEducationByResumeId(resume_id);
    }

    @ApiOperation("更新或添加Intention")
    @PostMapping("/saveOrUpdate")
    public RespBean saveOrUpdate(@RequestBody ResumeIntention resumeIntention){

        if(true==resumeIntentionService.saveOrUpdate(resumeIntention)){
            return RespBean.success("success");
        }
        return RespBean.error("error");
    }

    @ApiOperation("删除Intention")
    @DeleteMapping("/deleteById/{id}")
    public RespBean deleteById(@PathVariable Integer id){
        return resumeIntentionService.deleteById(id);
    }

}
