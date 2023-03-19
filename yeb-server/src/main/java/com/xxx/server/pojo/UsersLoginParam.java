package com.xxx.server.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * Keafmd
 *
 * @ClassName: AdminLoginParam
 * @Description: 用户登录实体类
 * @author: liuchen
 * @date: 2022/4/2 19:39
 * @Blog:
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "UsersLogin对象",description = "")
public class UsersLoginParam {
    @ApiModelProperty(value = "手机号码",required = true)
    private String phone;
    @ApiModelProperty(value = "密码",required = true)
    private String password;
    @ApiModelProperty(value = "验证码")
    private String code;
}
