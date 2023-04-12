package com.xxx.server.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("resume_selfevaluation")
@ApiModel(value="ResumeSelfevaluation对象", description="")
public class ResumeSelfevaluation implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer resume_id;

    @ApiModelProperty(value = "自我评价")
    private String self_evaluation;


}
