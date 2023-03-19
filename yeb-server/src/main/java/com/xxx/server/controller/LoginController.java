package com.xxx.server.controller;

import com.xxx.server.pojo.RespBean;
import com.xxx.server.pojo.Users;
import com.xxx.server.pojo.UsersLoginParam;
import com.xxx.server.service.IUsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * Keafmd
 *
 * @ClassName: LoginController
 * @Description: 登录
 * @author: liuchen
 * @date: 2022/4/5 11:39
 * @Blog:
 */
@Api(tags = "LoginController")
@RestController
@RequestMapping("/")
public class LoginController {
    @Autowired
    private IUsersService usersService;
    @ApiOperation(value = "登录之后返回token或注册")
    @PostMapping("/login")
    public RespBean login(@RequestBody UsersLoginParam usersLoginParam, HttpServletRequest request){
        //code 为"" 就是登录, 为1或0就是注册
        if(""==usersLoginParam.getCode()){
            return usersService.login(usersLoginParam.getPhone(),usersLoginParam.getPassword(),usersLoginParam.getCode(),request);
        }else if(usersLoginParam.getCode().equals("1")||usersLoginParam.getCode().equals("0")){
            System.out.println(usersLoginParam.getCode()+"/");
            return usersService.register(usersLoginParam.getPhone(),usersLoginParam.getPassword(),usersLoginParam.getCode(),request);
        }
        System.out.println(usersLoginParam.getCode());
        return RespBean.error("登录或注册失败");
    }

    @ApiOperation(value = "获取当前登录用户的信息")
    @GetMapping("/user/info")
    public Users getAdminInfo(Principal principal){//这里principal是由于实现类里更新security登录用户对象,这里才能获取对应的用户名
        if(null==principal){
            return null;
        }
        String username = principal.getName();
        Users user = usersService.getUserByUsername(username);
        user.setPassword(null);
        return  user;
    }


    @ApiOperation(value = "退出登录")
    @PostMapping("/logout")
    /**
     * 这里主要功能交给前端完成,这里只是起了返回的作用
     */
    public RespBean logout(){
        return RespBean.success("注销成功");
    }
}
