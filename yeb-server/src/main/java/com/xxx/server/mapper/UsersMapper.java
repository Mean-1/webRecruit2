package com.xxx.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxx.server.pojo.Users;
import org.apache.ibatis.annotations.Param;
import org.apache.tomcat.jni.Local;

import java.security.Timestamp;
import java.time.LocalDateTime;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mean
 * @since 2023-03-06
 */
public interface UsersMapper extends BaseMapper<Users> {

    /**
     * 添加用户
     * @param username
     * @param phone
     * @param password
     * @param is_recruit
     * @return
     */
    Integer addUser(@Param("username") String username,@Param("phone") String phone, @Param("password") String password,@Param("is_recruit")String is_recruit);

    /**
     * 更新用户的phone
     * @param id
     * @param phone
     * @return
     */
    int updatePhone(@Param("id") Integer id, @Param("phone") String phone);

    /**
     * 更新用户的password
     * @param id
     * @param newPassword
     * @return
     */
    int updatePassword(@Param("id") Integer id,@Param("newPassword") String newPassword);

    /**
     * 更新用户的username
     * @param id
     * @param newUsername
     * @return
     */
    int updateUsername(@Param("id") Integer id,@Param("newUsername") String newUsername);

    /**
     * 更新用户的email
     * @param id
     * @param newEmail
     * @return
     */
    int updateEmail(@Param("id") Integer id,@Param("newEmail") String newEmail);
}
