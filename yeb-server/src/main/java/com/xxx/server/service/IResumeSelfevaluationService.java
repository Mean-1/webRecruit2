package com.xxx.server.service;

import com.xxx.server.pojo.RespBean;
import com.xxx.server.pojo.ResumeSelfevaluation;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mean
 * @since 2023-04-05
 */
public interface IResumeSelfevaluationService extends IService<ResumeSelfevaluation> {

    /**
     * 根据resume_id获取SelfEvaluation
     * @param resume_id
     * @return
     */
    RespBean getEducationByResumeId(Integer resume_id);
}
