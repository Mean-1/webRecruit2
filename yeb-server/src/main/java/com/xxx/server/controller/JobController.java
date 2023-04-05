package com.xxx.server.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xxx.server.pojo.*;
import com.xxx.server.service.IJobService;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
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

    @ApiOperation(value = "获取所有job(限制9条)")
    @GetMapping("/list")
    public List<Job> getAllJob(){
        return jobService.getAllJob();
    }


    @ApiOperation(value = "获取少量job")
    @GetMapping("/listLittle/{limit}")
    public List<Job> getLittleJob(@PathVariable Integer limit){
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

    @ApiOperation(value = "根据工作id获取job")
    @GetMapping("/info")
    public Job getJobById(@RequestParam String id ,@RequestParam Boolean isDetail){
        Integer job_id = Integer.parseInt(id);
        return jobService.getJobById(job_id,isDetail);
    }

    @ApiOperation(value = "根据公司id获取限制的job和user信息")
    @GetMapping("/getJobByCompanyId/{cid}")
    public List<Job> getJobByCompanyId(@PathVariable Integer cid){
        return jobService.getJobByCompanyId(cid);
    }

    @ApiOperation(value = "根据公司id查询job信息(分页)")
    @GetMapping("/getJobByPageWithCompanyId")
    public RespPageBean getJobByPageWithCompanyId(@RequestParam(defaultValue = "1") Integer currentPage,
                                                  @RequestParam(defaultValue = "10") Integer size,
                                                  Integer cid,
                                                  Company_jobSearchParam company_jobSearchParam){
        return jobService.getJobByPageWithCompanyId(currentPage,size,cid,company_jobSearchParam);
    }


//    以下的路径需要权限(登录后才能操作)
    @ApiOperation(value = "添加job")
    @PostMapping("/addJob")
    public RespBean addJob(@RequestBody JobInsertParam job){
        return jobService.addJob(job);
    }

    @ApiOperation(value = "根据招聘者id查询职位(分页)")
    @GetMapping("/getJobByRecruiterId")
    public RespPageBean getJobByRecruiterId(@RequestParam(defaultValue = "1") Integer currentPage,
                                            @RequestParam(defaultValue = "10") Integer size,
                                            @RequestParam Integer uid,//user id
                                            @RequestParam String status,//job状态
                                            @RequestParam String condition){//job时间
        return jobService.getJobByRecruiterId(currentPage,size,uid,status,condition);
    }

    @ApiOperation(value = "更新job状态")
    @PostMapping("/updateStatus")
    public RespBean updateStatus(@RequestBody UpdateStatusParam updateStatusParam){
        return jobService.updateStatus(updateStatusParam.getSelectedJobIds(),updateStatusParam.getStatus());
    }

    @ApiOperation(value = "删除job")
    @DeleteMapping("/deleteJobByIds")
    public RespBean deleteJobByIds(@RequestBody UpdateStatusParam updateStatusParam){
        Integer [] idArray = updateStatusParam.getSelectedJobIds();
        System.out.println(idArray);

        if(null!=idArray && jobService.removeByIds(Arrays.asList(idArray))){
            return RespBean.success("success");
        }else{
            return RespBean.error("error");
        }

    }
}
