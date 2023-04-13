package com.xxx.server.controller;


import com.xxx.server.pojo.*;
import com.xxx.server.service.IUserJobApplycationService;
import com.xxx.server.service.IUserJobCollectionService;
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
 * @since 2023-03-24
 */
@RestController
@RequestMapping("/user-job-applycation")
public class UserJobApplycationController {
    @Autowired
    private IUserJobApplycationService userJobApplycationService;


    @ApiOperation(value = "查询是否投递")
    @GetMapping("/isApply/{uid}/{jid}")
    public Boolean isApply(@PathVariable Integer uid, @PathVariable Integer jid){
        return userJobApplycationService.isApply(uid,jid);
    }
    @ApiOperation(value = "添加投递")
    @PutMapping("/addApply/{uid}/{jid}")
    public RespBean addApply(@PathVariable Integer uid,@PathVariable Integer jid){
        return userJobApplycationService.addApply(uid,jid);
    }

    @ApiOperation(value = "批量投递")
    @PostMapping("/addLotApply")
    public RespBean addLotApply(@RequestBody CollectionJobParam collectionJobParam){
        return userJobApplycationService.addLotApply(collectionJobParam.getSelectedJobIds(),collectionJobParam.getUid());
    }

    @ApiOperation(value = "删除投递")
    @DeleteMapping("/deleteApply/{uid}/{jid}")
    public RespBean deleteApply(@PathVariable Integer uid, @PathVariable Integer jid){
        return userJobApplycationService.deleteApply(uid, jid);
    }


    @ApiOperation("根据uid查询投递职位信息")
    @GetMapping("/getApplyJobInfo")
    public RespPageBean getApplyJobInfo(@RequestParam(defaultValue = "1") Integer currentPage,
                                        @RequestParam(defaultValue = "10") Integer size,
                                        @RequestParam String state,
                                        @RequestParam Integer uid){
        return userJobApplycationService.getApplyJobInfo(currentPage,size,state,uid);
    }

    @ApiOperation("根据uid查询少量投递职位信息（6条数据）")
    @GetMapping("/getLittleApplyJobInfo/{uid}")
    public RespBean getLittleApplyJobInfo(@PathVariable Integer uid){
        return userJobApplycationService.getLittleApplyJobInfo(uid);
    }


    @ApiOperation("根据uid查询所有投递简历")
    @GetMapping("/getAllResume")
    public RespPageBean getAllResume(@RequestParam(defaultValue = "1") Integer currentPage,
                                     @RequestParam(defaultValue = "10") Integer size,
                                     @RequestParam Integer uid,
                                     @RequestParam String status){
        return userJobApplycationService.getAllResume(currentPage,size,uid,status);
    }

    @ApiOperation("更新投递简历的状态")
    @PostMapping("/updateApplyStatus")
    public RespBean updateApplyStatus(@RequestBody UpdateStatusParam updateStatusParam){
        System.out.println(updateStatusParam.getSelectedIds());
        return userJobApplycationService.updateApplyStatus(updateStatusParam.getSelectedIds(),updateStatusParam.getStatus());
    }

    @ApiOperation("根据uid获取少量投递简历(4条数据)")
    @GetMapping("/getLittleResume/{uid}")
    public List<UserJobApplycation> getLittleResume(@PathVariable Integer uid){
        return userJobApplycationService.getLittleResume(uid);
    }


}
