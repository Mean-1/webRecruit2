package com.xxx.server.service.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxx.server.mapper.JobMapper;
import com.xxx.server.pojo.Job;
import com.xxx.server.pojo.JobSearchParam;
import com.xxx.server.pojo.RespPageBean;
import com.xxx.server.service.IJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mean
 * @since 2023-03-20
 */
@Service
public class JobServiceImpl extends ServiceImpl<JobMapper, Job> implements IJobService {

    @Autowired
    private JobMapper jobMapper;

    /**
     * 查询所有职位
     * @return
     */
    @Override
    public List<Job> getAllJob() {
        return jobMapper.getAllJob();
    }

    @Override
    public RespPageBean getAllJobWithSearch(Integer currentPage, Integer size, JobSearchParam jobSearchParam) {
        Page<Job> page = new Page<>();
        IPage<Job> jobByPage = jobMapper.getAllJobWithSearch(page,jobSearchParam);
        RespPageBean respPageBean = new RespPageBean(jobByPage.getTotal(),jobByPage.getRecords());
        return respPageBean;
    }
}
