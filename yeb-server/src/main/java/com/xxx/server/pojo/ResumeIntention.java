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
@TableName("resume_intention")
@ApiModel(value="ResumeIntention对象", description="")
public class ResumeIntention implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "intention_id", type = IdType.AUTO)
    private Integer intention_id;

    private Integer resume_id;

    private String intention_duty;

    private String intention_type;

    private String intention_city;

    private String min_salary;

    private String max_salary;

    private String arrive_date;


}
