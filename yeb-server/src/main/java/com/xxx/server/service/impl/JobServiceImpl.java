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

    /**
     * 获取少量job
     * @return
     */
    @Override
    public List<Job> getLittleJob(String limit) {
        String a="0";
        return jobMapper.getLittleJob(a,limit);
    }

    /**
     * 分页搜索职位信息
     * @param currentPage
     * @param size
     * @param jobSearchParam
     * @return
     */
    @Override
    public RespPageBean getAllJobWithSearch(Integer currentPage, Integer size, JobSearchParam jobSearchParam) {
        Page<Job> page = new Page<>(currentPage,size);
        IPage<Job> jobByPage = jobMapper.getAllJobWithSearch(page,jobSearchParam);
        RespPageBean respPageBean = new RespPageBean(jobByPage.getTotal(),jobByPage.getRecords());
        return respPageBean;
    }

    /**
     * 根据id查询职位信息
     * @param id
     * @param isDetail
     * @return
     */
    @Override
    public Job getJobById(Integer id, Boolean isDetail) {

        if(true==isDetail)
            return jobMapper.getJobDetailById(id);
        else if(false==isDetail)
            return jobMapper.getJobById(id);
        return null;
    }
}
