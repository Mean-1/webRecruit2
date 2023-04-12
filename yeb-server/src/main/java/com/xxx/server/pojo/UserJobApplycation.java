package com.xxx.server.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;

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
 * @since 2023-03-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("user_job_applycation")
@ApiModel(value="UserJobApplycation对象", description="")
public class UserJobApplycation implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer user_id;

    private Integer job_id;

    /**
     * 状态
     */
    private String state;
    /**
     * 投递时间
     */
    private LocalDateTime create_date;

    @ApiModelProperty(value = "user")
    @TableField(exist = false)
    private Users users;

    @ApiModelProperty(value = "company")
    @TableField(exist = false)
    private Company company;

    @ApiModelProperty(value = "job")
    @TableField(exist = false)
    private Job job;

    @ApiModelProperty(value = "resume")
    @TableField(exist = false)
    private Resume resume;

    @ApiModelProperty(value = "userResume")
    @TableField(exist = false)
    private UserResume user_resume;

    @ApiModelProperty(value = "resumeBaseinfo")
    @TableField(exist = false)
    private ResumeBaseinfo resume_baseinfo;

    @ApiModelProperty(value = "resumeEducation")
    @TableField(exist = false)
    private ResumeEducation resume_education;


}
