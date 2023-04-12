package com.xxx.server.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDate;
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
@TableName("resume_projects")
@ApiModel(value="ResumeProjects对象", description="")
public class ResumeProjects implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "project_id", type = IdType.AUTO)
    private Integer project_id;

    private Integer resume_id;

    private String project_name;

    private String project_description;

    private String project_duty;

    private String duty_description;

    private String start_date;

    private String end_date;

    private String project_url;


}
