package com.xxx.server.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * Keafmd
 *
 * @ClassName: UpdateStatusParam
 * @Description: 更新状态实体类
 * @author: liuchen
 * @date: 2023/4/2 15:46
 * @Blog:
 */

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="更新状态实体类", description="")
public class UpdateStatusParam implements Serializable {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty("Job的id数组")
    private Integer[] selectedJobIds;

    @ApiModelProperty("状态")
    private String status;

}
