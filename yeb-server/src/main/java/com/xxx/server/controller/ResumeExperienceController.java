package com.xxx.server.controller;


import com.xxx.server.pojo.RespBean;
import com.xxx.server.pojo.ResumeEducation;
import com.xxx.server.pojo.ResumeExperience;
import com.xxx.server.service.IResumeEducationService;
import com.xxx.server.service.IResumeExperienceService;
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
@RequestMapping("/resume-experience")
public class ResumeExperienceController {

    @Autowired
    private IResumeExperienceService resumeExperienceService;

    @ApiOperation("根据resume_id获取experience")
    @GetMapping("/getExperienceByResumeId/{resume_id}")
    public RespBean getExperienceByResumeId(@PathVariable Integer resume_id){

        return resumeExperienceService.getExperienceByResumeId(resume_id);
    }

    @ApiOperation("更新或添加experience")
    @PostMapping("/saveOrUpdate")
    public RespBean saveOrUpdate(@RequestBody ResumeExperience resumeExperience){

        if(true==resumeExperienceService.saveOrUpdate(resumeExperience)){
            return RespBean.success("success");
        }
        return RespBean.error("error");
    }

    @ApiOperation("删除experience")
    @DeleteMapping("/deleteById/{id}")
    public RespBean deleteById(@PathVariable Integer id){
        return resumeExperienceService.deleteById(id);
    }
}
