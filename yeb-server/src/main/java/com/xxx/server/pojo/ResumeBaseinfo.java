package com.xxx.server.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
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
 * @since 2023-04-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("resume_baseinfo")
@ApiModel(value="ResumeBaseinfo对象", description="")
public class ResumeBaseinfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "简历id")
    private Integer resume_id;

    @ApiModelProperty(value = "头像路径")
    private String applicant_avatar;

    @ApiModelProperty(value = "姓名")
    private String applicant_name;

    @ApiModelProperty(value = "性别")
    private String applicant_sex;

    @ApiModelProperty(value = "年龄")
    private Integer applicant_age;

    @ApiModelProperty(value = "身份")
    private String applicant_identity;

    @ApiModelProperty(value = "工作经验")
    private String working_year;

    @ApiModelProperty(value = "学历")
    private String applicant_education;

    @ApiModelProperty(value = "联系方式")
    private String applicant_tel;

    @ApiModelProperty(value = "邮箱")
    private String applicant_email;

    @ApiModelProperty(value = "地址")
    private String applicant_city;


}
