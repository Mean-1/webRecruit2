package com.xxx.server.controller;


import com.xxx.server.service.IUserResumeService;
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
@RequestMapping("/user-resume")
public class UserResumeController {

    @Autowired
    private IUserResumeService userResumeService;

    @ApiOperation("根据uid查询rid")
    @GetMapping("/getRidByUid/{uid}")
    public Integer getRidByUid(@PathVariable Integer uid){
        return userResumeService.getRidByUid(uid);
    }

    @ApiOperation("添加新用户和简历的关系")
    @GetMapping("/addUserResume/{uid}")
    public Integer addUserResume(@PathVariable Integer uid){
        return userResumeService.addUserResume(uid);
    }
}
