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
@TableName("resume_skill")
@ApiModel(value="ResumeSkill对象", description="")
public class ResumeSkill implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "skill_id", type = IdType.AUTO)
    private Integer skill_id;

    private Integer resume_id;

    private String skill_name;

    private String mastery_degree;


}
