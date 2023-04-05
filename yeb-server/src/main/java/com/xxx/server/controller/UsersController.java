package com.xxx.server.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xxx.server.pojo.RespBean;
import com.xxx.server.pojo.UpdateRecruiterInfoParam;
import com.xxx.server.pojo.Users;
import com.xxx.server.service.IRecruiterCompanyService;
import com.xxx.server.service.IUsersService;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
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

    @Autowired
    private IUsersService usersService;

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

    @ApiOperation(value = "更新用户的phone")
    @PostMapping("/updatePhone")
    public RespBean updatePhone(@RequestParam Integer id, @RequestParam String oldPassword,@RequestParam String newPhone){
        if(true==compaPsw(id, oldPassword)){
            return usersService.updatePhone(id,newPhone);
        }
        return RespBean.error("密码错误");
    }
    @ApiOperation(value = "更新用户的password")
    @PostMapping("/updatePassword")
    public RespBean updatePassword(@RequestParam Integer id, @RequestParam String oldPassword,@RequestParam String newPassword){
        if(true==compaPsw(id, oldPassword)){
            return usersService.updatePassword(id,newPassword);
        }
        return RespBean.error("密码错误");
    }


    @ApiOperation(value = "比较密码是否相等")
    @GetMapping("/compaPsw")
    public Boolean compaPsw(@RequestParam Integer id, @RequestParam String password){
        Users users = usersService.getById(id);
        boolean checkpw = BCrypt.checkpw(password, users.getPassword());
        System.out.println(checkpw);
        return checkpw;
    }

}
