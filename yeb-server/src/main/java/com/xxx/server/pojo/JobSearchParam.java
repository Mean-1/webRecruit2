package com.xxx.server.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Keafmd
 *
 * @ClassName: JobSearchParam
 * @Description: 筛选职位实体类
 * @author: liuchen
 * @date: 2023/3/20 15:56
 * @Blog:
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Job搜索对象", description="")
public class JobSearchParam implements Serializable {
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
    private BigDecimal salary;

    @ApiModelProperty(value = "公司规模")
    private String c_size;


}
