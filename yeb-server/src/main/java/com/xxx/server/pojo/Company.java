package com.xxx.server.pojo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2023-03-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Company对象", description="")
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "公司名字")
    private String name;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "规模")
    private String size;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "公司建立时间")
    private LocalDate founded_at;

    @ApiModelProperty(value = "标签")
    private String tag;

    @ApiModelProperty(value = "公司图标地址")
    private String icon;

    @ApiModelProperty(value = "公司福利")
    private String benefit;

    @ApiModelProperty(value = "公司性质")
    private String type;

    private LocalDateTime created_at;

    private LocalDateTime updated_at;


}
