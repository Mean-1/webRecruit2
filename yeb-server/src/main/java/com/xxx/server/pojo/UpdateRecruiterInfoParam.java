package com.xxx.server.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * Keafmd
 *
 * @ClassName: UpdateRecruiterInfoParam
 * @Description: 更新招聘者信息的实体类
 * @author: liuchen
 * @date: 2023/3/30 15:14
 * @Blog:
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="更新招聘者信息的实体类", description="")
public class UpdateRecruiterInfoParam implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户id")
    private Integer uid;

    @ApiModelProperty(value = "招聘者姓名")
    private String username;

    @ApiModelProperty(value = "招聘者性别")
    private String gender;

    @ApiModelProperty(value = "公司任职")
    private String duty;

    //公司名字在更新的时候要转成公司id
    @ApiModelProperty(value = "公司名字")
    private String name;

}
