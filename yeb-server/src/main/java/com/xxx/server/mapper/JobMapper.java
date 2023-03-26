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
     * 获取少量job
     * @return
     */
    List<Job> getLittleJob(@Param("a") String a,@Param("limit") String limit);

    /**
     * 分页查询job
     * @param page
     * @param jobSearchParam
     * @return
     */
    IPage<Job> getAllJobWithSearch(Page<Job> page, @Param("jobSearchParam") JobSearchParam jobSearchParam);

    /**
     * 根据id查询job详细信息
     * @param id
     * @return
     */
    Job getJobDetailById(@Param("id") Integer id);

    /**
     * 根据id查询job少数信息
     * @param id
     * @return
     */
    Job getJobById(@Param("id") Integer id);
}
