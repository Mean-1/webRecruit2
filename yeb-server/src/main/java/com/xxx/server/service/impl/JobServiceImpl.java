package com.xxx.server.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxx.server.mapper.JobMapper;
import com.xxx.server.pojo.Job;
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
}
