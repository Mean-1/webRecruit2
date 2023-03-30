package com.xxx.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxx.server.pojo.RespBean;
import com.xxx.server.pojo.Users;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mean
 * @since 2023-03-06
 */
public interface IUsersService extends IService<Users> {

    /**
     * 登录判断
     * @param phone
     * @param password
     * @param code
     * @param request
     * @return
     */
    RespBean login(String phone, String password, String code, HttpServletRequest request);

    /**
     * 根据username获取User信息
     * @param username
     * @return
     */
    Users getUserByUsername(String username);

    /**
     * 注册
     * @param phone
     * @param password
     * @param code
     * @param request
     * @return
     */
    RespBean register(String phone, String password, String code, HttpServletRequest request);


}
