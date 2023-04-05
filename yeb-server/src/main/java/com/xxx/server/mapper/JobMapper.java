package com.xxx.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xxx.server.pojo.Company_jobSearchParam;
import com.xxx.server.pojo.Job;
import com.xxx.server.pojo.JobSearchParam;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

import java.time.LocalDate;
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
    List<Job> getLittleJob(@Param("limit") Integer limit);

    /**
     * 分页查询job
     * @param page
     * @param jobSearchParam
     * @return
     */
    IPage<Job> getAllJobWithSearch(Page<Job> page, @Param("jobSearchParam") JobSearchParam jobSearchParam);

    /**
     * 根据工作id查询job详细信息
     * @param id
     * @return
     */
    Job getJobDetailById(@Param("id") Integer id);

    /**
     * 根据工作id查询job少数信息
     * @param id
     * @return
     */
    Job getJobById(@Param("id") Integer id);

    /**
     * 根据公司id查询job
     * @param cid
     * @return
     */
    List<Job> getJobByCompanyId(@Param("cid") Integer cid);

    /**
     * 根据公司id查询job信息(分页)
     * @param page
     * @param cid
     * @param company_jobSearchParam
     * @return
     */
    IPage<Job> getJobByPageWithCompanyId(Page<Job> page,@Param("cid") Integer cid,@Param("company_jobSearchParam") Company_jobSearchParam company_jobSearchParam);

    /**
     * 根据招聘者id查询职位(分页)
     * @param page
     * @param uid
     * @param status
     * @return
     */
    IPage<Job> getJobByRecruiterId(Page<Job> page, @Param("uid") Integer uid, @Param("status") String status ,
                                   @Param("date")LocalDate date, @Param("con")Integer con);

    /**
     * 更新job状态
     * @param id
     * @param status
     * @return
     */
    int updateStatus(@Param("id") Integer id,@Param("status") String status);
}
