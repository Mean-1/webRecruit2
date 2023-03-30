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
 * @since 2023-03-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("recruiter_company")
@ApiModel(value="RecruiterCompany对象", description="")
public class RecruiterCompany implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "招聘者id")
    private Integer user_id;

    @ApiModelProperty(value = "公司id")
    private Integer company_id;

    @ApiModelProperty(value = "职位")
    private String duty;

    @ApiModelProperty(value = "user实体类")
    private Users users;

    @ApiModelProperty(value = "company实体类")
    private Company company;


}
