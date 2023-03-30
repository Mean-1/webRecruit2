package com.xxx.server.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * Keafmd
 *
 * @ClassName: CompanySearchParam
 * @Description: 公司搜索类
 * @author: liuchen
 * @date: 2023/3/26 14:44
 * @Blog:
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "company搜索类对象")
public class CompanySearchParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "公司地址")
    private String address;
    @ApiModelProperty(value = "行业类型")
    private String tag;
    @ApiModelProperty(value = "公司性质")
    private String type;
    @ApiModelProperty(value = "公司规模")
    private String c_size;
}
