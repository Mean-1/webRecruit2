package com.xxx.server.service.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxx.server.mapper.JobMapper;
import com.xxx.server.pojo.*;
import com.xxx.server.service.IJobService;
import io.swagger.models.auth.In;
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
    public List<Job> getLittleJob(Integer limit) {
        return jobMapper.getLittleJob(limit);
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
     * 根据工作id查询职位信息
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

    /**
     * 根据公司id查询job
     * @param cid
     * @return
     */
    @Override
    public List<Job> getJobByCompanyId(Integer cid) {
        return jobMapper.getJobByCompanyId(cid);
    }

    /**
     * 根据公司id查询job信息(分页)
     * @param currentPage
     * @param size
     * @param company_jobSearchParam
     * @return
     */
    @Override
    public RespPageBean getJobByPageWithCompanyId(Integer currentPage, Integer size,Integer cid, Company_jobSearchParam company_jobSearchParam) {
        Page<Job> page = new Page<>(currentPage,size);
        IPage<Job> jobByPage = jobMapper.getJobByPageWithCompanyId(page,cid,company_jobSearchParam);
        RespPageBean respPageBean = new RespPageBean(jobByPage.getTotal(),jobByPage.getRecords());
        return respPageBean;
    }

    /**
     * 添加job
     * @param job
     * @return
     */
    @Override
    public RespBean addJob(Job job) {
        if(1==jobMapper.insert(job)){
            return RespBean.success("success");
        }
        return RespBean.error("添加失败");
    }
}
