package com.xxx.server.pojo;

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
 * @since 2023-04-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("resume_experience")
@ApiModel(value="ResumeExperience对象", description="")
public class ResumeExperience implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "experience_id", type = IdType.AUTO)
    private Integer experience_id;

    private Integer resume_id;

    private String company_name;

    private String job_duty;

    private String job_description;

    private String start_date;

    private String end_date;


}
