package com.xxx.server.controller;


import com.xxx.server.pojo.RespBean;
import com.xxx.server.service.IUserJobApplycationService;
import com.xxx.server.service.IUserJobCollectionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    @ApiOperation(value = "查询是否收藏")
    @GetMapping("/isApply/{uid}/{jid}")
    public RespBean isApply(@PathVariable Integer uid, @PathVariable Integer jid){
        return userJobApplycationService.isApply(uid,jid);
    }
    @ApiOperation(value = "添加收藏")
    @PutMapping("/addApply/{uid}/{jid}")
    public RespBean addApply(@PathVariable Integer uid,@PathVariable Integer jid){
        return userJobApplycationService.addApply(uid,jid);
    }

    @ApiOperation(value = "删除收藏")
    @DeleteMapping("/deleteApply/{uid}/{jid}")
    public RespBean deleteApply(@PathVariable Integer uid, @PathVariable Integer jid){
        return userJobApplycationService.deleteApply(uid, jid);
    }
}
