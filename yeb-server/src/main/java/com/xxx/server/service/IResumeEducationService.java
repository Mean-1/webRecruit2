package com.xxx.server.service;

import com.xxx.server.pojo.RespBean;
import com.xxx.server.pojo.ResumeEducation;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mean
 * @since 2023-04-05
 */
public interface IResumeEducationService extends IService<ResumeEducation> {

    /**
     * 根据resume_id获取education
     * @param resume_id
     * @return
     */
    RespBean getEducationByResumeId(Integer resume_id);

    /**
     * 删除education
     * @param id
     * @return
     */
    RespBean deleteById(Integer id);
}
