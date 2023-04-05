package com.xxx.server.controller;


import com.xxx.server.pojo.RespBean;
import com.xxx.server.pojo.ResumeSelfevaluation;
import com.xxx.server.pojo.ResumeSkill;
import com.xxx.server.service.IResumeSelfevaluationService;
import com.xxx.server.service.IResumeSkillService;
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
@RequestMapping("/resume-skill")
public class ResumeSkillController {

    @Autowired
    private IResumeSkillService resumeSkillService;

    @ApiOperation("根据resume_id获取Skill")
    @GetMapping("/getSkillByResumeId/{resume_id}")
    public RespBean getSkillByResumeId(@PathVariable Integer resume_id){

        return resumeSkillService.getEducationByResumeId(resume_id);
    }

    @ApiOperation("更新或添加education")
    @PostMapping("/saveOrUpdate")
    public RespBean saveOrUpdate(@RequestBody ResumeSkill resumeSkill){

        if(true==resumeSkillService.saveOrUpdate(resumeSkill)){
            return RespBean.success("success");
        }
        return RespBean.error("error");
    }

}
