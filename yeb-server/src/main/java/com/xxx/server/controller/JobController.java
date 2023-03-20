package com.xxx.server.controller;


import com.xxx.server.pojo.Job;
import com.xxx.server.service.IJobService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author mean
 * @since 2023-03-20
 */
@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    private IJobService jobService;

    @ApiOperation(value = "获取所有job")
    @GetMapping("/list")
    public List<Job> getAllJob(){
        return jobService.getAllJob();
    }
}
