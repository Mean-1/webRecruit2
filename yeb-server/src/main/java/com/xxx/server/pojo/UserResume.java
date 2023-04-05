package com.xxx.server.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author mean
 * @since 2023-04-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("user_resume")
@ApiModel(value="UserResume对象", description="")
public class UserResume implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @ApiModelProperty(value = "用户id")
    private Integer user_id;

    @ApiModelProperty(value = "简历id")
    private Integer resume_id;

    @ApiModelProperty(value = "users")
    private Users users;

    @ApiModelProperty(value = "resume")
    private Resume resume;


}
