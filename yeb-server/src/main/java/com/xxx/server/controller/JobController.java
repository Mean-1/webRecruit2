package com.xxx.server.controller;


import com.xxx.server.pojo.Job;
import com.xxx.server.pojo.JobSearchParam;
import com.xxx.server.pojo.RespPageBean;
import com.xxx.server.service.IJobService;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

//    这里没用
    @ApiOperation(value = "获取少量job")
    @GetMapping("/listLittle/{limit}")
    public List<Job> getLittleJob(@PathVariable String limit){
        return jobService.getLittleJob(limit);
    }

    @ApiOperation(value = "筛选职位(分页)")
    @GetMapping("/search")
    //搜索框————只对应公司名和职位介绍
    public RespPageBean getAllJobWithSearch(@RequestParam(defaultValue = "1") Integer currentPage,
                                          @RequestParam(defaultValue = "10") Integer size,
                                          JobSearchParam jobSearchParam){

        return jobService.getAllJobWithSearch(currentPage,size,jobSearchParam);
    }

    @ApiOperation(value = "根据id获取job")
    @GetMapping("/info")
    public Job getJobById(@RequestParam String id ,@RequestParam Boolean isDetail){
        Integer job_id = Integer.parseInt(id);
        return jobService.getJobById(job_id,isDetail);
    }
}
