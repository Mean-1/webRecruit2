package com.xxx.server.service;

import com.xxx.server.pojo.RespBean;
import com.xxx.server.pojo.ResumeIntention;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mean
 * @since 2023-04-05
 */
public interface IResumeIntentionService extends IService<ResumeIntention> {

    /**
     * 根据resume_id获取intention
     * @param resume_id
     * @return
     */
    RespBean getEducationByResumeId(Integer resume_id);

    /**
     * 删除Intention
     * @param id
     * @return
     */
    RespBean deleteById(Integer id);

    /**
     * 根据resume_id获取一条intention数据
     * @param resume_id
     * @return
     */
    RespBean getOneIntentionByResumeId(Integer resume_id);
}
