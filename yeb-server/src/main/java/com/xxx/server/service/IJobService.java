package com.xxx.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxx.server.pojo.*;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mean
 * @since 2023-03-20
 */
public interface IJobService extends IService<Job> {

    /**
     * 查询所有职位(限制9条)
     * @return
     */
    List<Job> getAllJob();

    /**
     * 获取少量job
     * @return
     */
    List<Job> getLittleJob(Integer limit);

    /**
     * 分页搜索职位
     * @param currentPage
     * @param size
     * @param jobSearchParam
     * @return
     */
    RespPageBean getAllJobWithSearch(Integer currentPage, Integer size, JobSearchParam jobSearchParam);

    /**
     * 根据工作id查询职位信息
     * @param id
     * @param isDetail
     * @return
     */
    Job getJobById(Integer id, Boolean isDetail);

    /**
     * 根据公司id查询job
     * @param cid
     * @return
     */
    List<Job> getJobByCompanyId(Integer cid);

    /**
     * 根据公司id查询job信息(分页)
     * @param currentPage
     * @param size
     * @param cid
     * @param company_jobSearchParam
     * @return
     */
    RespPageBean getJobByPageWithCompanyId(Integer currentPage, Integer size,Integer cid, Company_jobSearchParam company_jobSearchParam);

    /**
     * 添加job
     * @param job
     * @return
     */
    RespBean addJob(JobInsertParam job);

    /**
     * 根据招聘者id查询职位(分页)
     * @param currentPage
     * @param size
     * @param uid
     * @param status
     * @return
     */
    RespPageBean getJobByRecruiterId(Integer currentPage, Integer size, Integer uid, String status,String condition);

    /**
     * 更新job状态
     * @param selectedJobIds
     * @param status
     * @return
     */
    RespBean updateStatus(Integer[] selectedJobIds, String status);
}
