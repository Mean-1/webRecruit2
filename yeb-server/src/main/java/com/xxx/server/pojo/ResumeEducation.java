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
@TableName("resume_education")
@ApiModel(value="ResumeEducation对象", description="")
public class ResumeEducation implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "education_id", type = IdType.AUTO)
    private Integer education_id;

    @ApiModelProperty(value = "简历id")
    private Integer resume_id;

    private String school_name;

    private String education;

    private String start_date;

    private String end_date;

    private String major;

    private String examination_flag;

    private String fulltime_flag;

    private String honor;

    private String certificate;

    private String attached_info;


}
