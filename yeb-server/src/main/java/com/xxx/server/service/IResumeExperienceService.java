package com.xxx.server.service;

import com.xxx.server.pojo.RespBean;
import com.xxx.server.pojo.ResumeExperience;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mean
 * @since 2023-04-05
 */
public interface IResumeExperienceService extends IService<ResumeExperience> {

    /**
     * 根据resume_id获取experience
     * @param resume_id
     * @return
     */
    RespBean getExperienceByResumeId(Integer resume_id);
}
