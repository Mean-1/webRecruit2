package com.xxx.server.controller;


import com.xxx.server.pojo.RespBean;
import com.xxx.server.pojo.ResumeBaseinfo;
import com.xxx.server.pojo.ResumeEducation;
import com.xxx.server.service.IResumeBaseinfoService;
import com.xxx.server.service.IResumeEducationService;
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
@RequestMapping("/resume-education")
public class ResumeEducationController {

    @Autowired
    private IResumeEducationService resumeEducationService;

    @ApiOperation("根据resume_id获取education")
    @GetMapping("/getEducationByResumeId/{resume_id}")
    public RespBean getEducationByResumeId(@PathVariable Integer resume_id){

        return resumeEducationService.getEducationByResumeId(resume_id);
    }

    @ApiOperation("更新或添加education")
    @PostMapping("/saveOrUpdate")
    public RespBean saveOrUpdate(@RequestBody ResumeEducation resumeEducation){

        if(true==resumeEducationService.saveOrUpdate(resumeEducation)){
            return RespBean.success("success");
        }
        return RespBean.error("error");
    }

    @ApiOperation("删除education")
    @DeleteMapping("/deleteById/{id}")
    public RespBean deleteById(@PathVariable Integer id){
        return resumeEducationService.deleteById(id);
    }

}
