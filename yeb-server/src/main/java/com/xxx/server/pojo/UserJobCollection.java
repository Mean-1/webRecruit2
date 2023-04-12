package com.xxx.server.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
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
 * @since 2023-03-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("user_job_collection")
@ApiModel(value="UserJobCollection对象", description="")
public class UserJobCollection implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer user_id;

    private Integer job_id;

    @ApiModelProperty(value = "job")
    @TableField(exist = false)
    private Job job;

    @ApiModelProperty(value = "company")
    @TableField(exist = false)
    private Company company;


}
