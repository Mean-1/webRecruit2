package com.xxx.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxx.server.pojo.Job;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mean
 * @since 2023-03-20
 */
public interface JobMapper extends BaseMapper<Job> {


    /**
     * 查询所有职位
     * @return
     */
    List<Job> getAllJob();
}
