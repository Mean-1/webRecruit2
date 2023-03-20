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
    private BigDecimal salary;

    @ApiModelProperty(value = "标签")
    private String tag;

    @ApiModelProperty(value = "公司id")
    private Integer company_id;

    @ApiModelProperty(value = "公司名字")
    @TableField(exist = false)
    private Company company;

//    @ApiModelProperty(value = "公司简介")
//    @TableField(exist = false)
//    private String c_tag;
//
//    @ApiModelProperty(value = "公司规模")
//    @TableField(exist = false)
//    private String c_size;
//
//    @ApiModelProperty(value = "公司地址")
//    @TableField(exist = false)
//    private String c_address;

    private LocalDate posted_at;

    private LocalDateTime created_at;

    private LocalDateTime updated_at;


}
