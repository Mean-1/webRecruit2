package com.xxx.server.controller;


import com.xxx.server.pojo.RespBean;
import com.xxx.server.pojo.ResumeIntention;
import com.xxx.server.pojo.ResumeProjects;
import com.xxx.server.service.IResumeIntentionService;
import com.xxx.server.service.IResumeProjectsService;
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
@RequestMapping("/resume-projects")
public class ResumeProjectsController {

    @Autowired
    private IResumeProjectsService resumeProjectsService;

    @ApiOperation("根据resume_id获取Projects")
    @GetMapping("/getProjectsByResumeId/{resume_id}")
    public RespBean getProjectsByResumeId(@PathVariable Integer resume_id){

        return resumeProjectsService.getProjectsByResumeId(resume_id);
    }

    @ApiOperation("更新或添加project")
    @PostMapping("/saveOrUpdate")
    public RespBean saveOrUpdate(@RequestBody ResumeProjects resumeProjects){

        if(true==resumeProjectsService.saveOrUpdate(resumeProjects)){
            return RespBean.success("success");
        }
        return RespBean.error("error");
    }

    @ApiOperation("删除project")
    @DeleteMapping("/deleteById/{id}")
    public RespBean deleteById(@PathVariable Integer id){
        return resumeProjectsService.deleteById(id);
    }

}
