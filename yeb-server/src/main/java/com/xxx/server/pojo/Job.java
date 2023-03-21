package com.xxx.server.pojo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.catalina.User;

/**
 * <p>
 * 
 * </p>
 *
 * @author mean
 * @since 2023-03-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Job对象", description="")
public class Job implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "职位名字")
    private String name;

    @ApiModelProperty(value = "工作经验")
    private String experience;

    @ApiModelProperty(value = "学历")
    private String qualification;

    @ApiModelProperty(value = "工资")
    private String salary;

    @ApiModelProperty(value = "标签")
    private String tag;

    @ApiModelProperty(value = "公司id")
    private Integer company_id;

    @ApiModelProperty(value = "招聘者id")
    private Integer user_id;

    @ApiModelProperty(value = "招聘者身份")
    private String interviewerDuty;

    @ApiModelProperty(value = "公司")
    @TableField(exist = false)
    private Company company;

    @ApiModelProperty(value = "招聘者")
    @TableField(exist = false)
    private Users users;

    @ApiModelProperty(value = "公司名字")
    @TableField(exist = false)
    private String companyName;

    @ApiModelProperty(value = "公司简介")
    @TableField(exist = false)
    private String companyTag;

    @ApiModelProperty(value = "公司规模")
    @TableField(exist = false)
    private String companySize;

    @ApiModelProperty(value = "公司地址")
    @TableField(exist = false)
    private String address;

    @ApiModelProperty(value = "公司logo地址")
    @TableField(exist = false)
    private String companyIcon;

    private LocalDate posted_at;

    private LocalDateTime created_at;

    private LocalDateTime updated_at;


}
