package com.xxx.server.controller;


import com.xxx.server.pojo.Resume;
import com.xxx.server.service.IResumeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author mean
 * @since 2023-04-04
 */
@RestController
@RequestMapping("/resume")
public class ResumeController {

    @Autowired
    private IResumeService resumeService;

    @ApiOperation(value = "根据rid获取resume")
    @GetMapping("/getResumeById/{id}")
    public Resume getResumeById(@PathVariable Integer id){
        return resumeService.getResumeById(id);
    }

}
