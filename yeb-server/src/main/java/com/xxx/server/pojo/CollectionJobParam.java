package com.xxx.server.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * Keafmd
 *
 * @ClassName: CollectionJobParam
 * @Description: 收藏职位param类
 * @author: liuchen
 * @date: 2023/4/8 22:45
 * @Blog:
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="收藏职位param类", description="")
public class CollectionJobParam implements Serializable {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty("Job的id数组")
    private Integer[] selectedJobIds;

    @ApiModelProperty("uid")
    private Integer uid;
}
