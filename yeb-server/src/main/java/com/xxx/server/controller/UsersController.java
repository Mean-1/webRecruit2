package com.xxx.server.controller;


import com.xxx.server.pojo.RespBean;
import com.xxx.server.pojo.UpdateRecruiterInfoParam;
import com.xxx.server.service.IRecruiterCompanyService;
import com.xxx.server.service.IUsersService;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author mean
 * @since 2023-03-06
 */
@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private IRecruiterCompanyService recruiterCompanyService;

    @ApiOperation(value = "通过uid获取招聘者基本信息")
    @GetMapping("/getInfo/{id}")
    public RespBean getInfo(@PathVariable Integer id){
        return recruiterCompanyService.getInfo(id);
    }

    @ApiOperation(value = "更新招聘者的基本信息")
    @PostMapping("/updateInfo")
    public RespBean updateInfo(@RequestBody UpdateRecruiterInfoParam updateRecruiterInfoParam){
        return recruiterCompanyService.updateInfo(updateRecruiterInfoParam);
    }
}
