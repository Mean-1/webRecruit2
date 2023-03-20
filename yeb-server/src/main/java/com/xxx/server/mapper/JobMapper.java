package com.xxx.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xxx.server.pojo.Job;
import com.xxx.server.pojo.JobSearchParam;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 分页查询job
     * @param page
     * @param jobSearchParam
     * @return
     */
    IPage<Job> getAllJobWithSearch(Page<Job> page, @Param("jobSearchParam") JobSearchParam jobSearchParam);
}
