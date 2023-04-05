package com.xxx.server.controller;


import com.xxx.server.pojo.RespBean;
import com.xxx.server.pojo.ResumeBaseinfo;
import com.xxx.server.service.IResumeBaseinfoService;
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
@RequestMapping("/resume-baseinfo")
public class ResumeBaseinfoController {

    @Autowired
    private IResumeBaseinfoService resumeBaseinfoService;

    @ApiOperation("根据resume_id获取baseinfo")
    @GetMapping("/getBaseInfoByResumeId/{resume_id}")
    public RespBean getBaseInfoByResumeId(@PathVariable Integer resume_id){

        return resumeBaseinfoService.getBaseInfoByResumeId(resume_id);
    }

    @ApiOperation("更新或添加baseinfo")
    @PostMapping("/saveOrUpdate")
    public RespBean saveOrUpdate(@RequestBody ResumeBaseinfo resumeBaseinfo){

        if(true==resumeBaseinfoService.saveOrUpdate(resumeBaseinfo)){
            return RespBean.success("success");
        }
        return RespBean.error("error");
    }
}
