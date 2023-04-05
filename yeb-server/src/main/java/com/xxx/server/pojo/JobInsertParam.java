package com.xxx.server.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Keafmd
 *
 * @ClassName: JobInsertParam
 * @Description: job添加或更新实体类
 * @author: liuchen
 * @date: 2023/4/4 11:15
 * @Blog:
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="job添加或更新对象", description="")
public class JobInsertParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "uid")
    private Integer uid;

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

    @ApiModelProperty(value = "招聘需求人数")
    private String recruit_num;

    @ApiModelProperty(value = "职位描述")
    private String description;

    @ApiModelProperty(value = "工作需求")
    private String requirement;

    @ApiModelProperty(value = "薪资福利")
    private String benefit;

    @ApiModelProperty(value = "附加信息")
    private String attached_info;

    @ApiModelProperty(value = "创建时间")
    private LocalDate posted_at;

    @ApiModelProperty(value = "状态")
    private String status;//0——已上线  1——草稿箱   2————已下线
}
