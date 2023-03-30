package com.xxx.server.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * Keafmd
 *
 * @ClassName: Company_jobSearchParam
 * @Description: 公司里查询职位的筛选实体类
 * @author: liuchen
 * @date: 2023/3/28 11:19
 * @Blog:
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Company_job搜索对象", description="")
public class Company_jobSearchParam implements Serializable {
    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "搜索框")
    private String search;

    @ApiModelProperty(value = "公司地址")
    private String c_address;

    @ApiModelProperty(value = "工作经验")
    private String experience;

    @ApiModelProperty(value = "学历")
    private String qualification;

    @ApiModelProperty(value = "工资")
    private String salary;
}
