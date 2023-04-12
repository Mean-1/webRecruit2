package com.xxx.server.service.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxx.server.mapper.JobMapper;
import com.xxx.server.mapper.RecruiterCompanyMapper;
import com.xxx.server.mapper.UsersMapper;
import com.xxx.server.pojo.*;
import com.xxx.server.service.IJobService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    @Autowired
    private RecruiterCompanyMapper recruiterCompanyMapper;

    /**
     * 查询所有职位(限制9条)
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
    public RespBean getJobById(Integer id, Boolean isDetail) {

        if(true==isDetail){
            Job jobDetailById = jobMapper.getJobDetailById(id);
            if(null!=jobDetailById){
                return RespBean.success("success",jobDetailById);
            }
        }
        else if(false==isDetail){
            Job jobById = jobMapper.getJobById(id);
            if(null!=jobById){
                return RespBean.success("success",jobById);
            }
        }
        return RespBean.error("error");
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
    public RespBean addJob(JobInsertParam job) {

        Job job1 = new Job();
        RecruiterCompany info = recruiterCompanyMapper.getInfo(job.getUid());

        job1.setId(job.getId());
        job1.setName(job.getName());
        job1.setExperience(job.getExperience());
        job1.setQualification(job.getQualification());
        job1.setSalary(job.getSalary());
        job1.setTag(job.getTag());
        job1.setInterviewerDuty(info.getDuty());
        job1.setCompany_id(info.getCompany_id());
        job1.setUser_id(info.getUser_id());
        job1.setRecruit_num(job.getRecruit_num());
        job1.setDescription(job.getDescription());
        job1.setRequirement(job.getRequirement());
        job1.setBenefit(job.getBenefit());
        job1.setAttached_info(job.getAttached_info());
        job1.setPosted_at(LocalDate.now());
        job1.setStatus(job.getStatus());
        if(null==job.getId()){
            if(1==jobMapper.insert(job1)){
                return RespBean.success("success");
            }
        }else {
            if(1==jobMapper.updateById(job1)){
                return RespBean.success("success");
            }
        }

        return RespBean.error("添加失败");
    }

    /**
     * 根据招聘者id查询职位(分页)
     * @param currentPage
     * @param size
     * @param uid
     * @param status
     * @return
     */
    @Override
    public RespPageBean getJobByRecruiterId(Integer currentPage, Integer size, Integer uid, String status,String condition) {
//        condition: 今天， 3天内，1周内，1个月内，3个月内， 半年内，半年以上
        int con =3;
        LocalDate date = LocalDate.now();
        if(!condition.equals("不限")) {
            con=0;
            if (condition.equals("今天")) date = date.minusDays(1);
            else if (condition.equals("3天内")) date = date.minusDays(3);
            else if (condition.equals("1周内内")) date = date.minusDays(7);
            else if (condition.equals("1个月内")) date = date.minusMonths(1);
            else if (condition.equals("3个月内")) date = date.minusMonths(3);
            else if (condition.equals("半年内")) date = date.minusMonths(6);
            else if (condition.equals("半年以上")) {
                System.out.println("hello");
                date = date.minusMonths(6);
                con = 1;
            }
            System.out.println(date);
        }
        System.out.println(con);


        Page<Job> page = new Page<>(currentPage,size);
        IPage<Job> jobByPage = jobMapper.getJobByRecruiterId(page,uid,status,date,con);
        RespPageBean respPageBean = new RespPageBean(jobByPage.getTotal(), jobByPage.getRecords());
        return respPageBean;
    }

    /**
     * 更新job状态
     * @param selectedJobIds
     * @param status
     * @return
     */
    @Override
    public RespBean updateStatus(Integer[] selectedJobIds, String status) {
        int i=0;
        System.out.println(status);
        for (Integer id : selectedJobIds) {
            System.out.println(id);
            i=jobMapper.updateStatus(id,status);
        }
        if(0!=i){
            return RespBean.success("success");
        }else {
            return RespBean.error("更新失败");
        }
    }
}
