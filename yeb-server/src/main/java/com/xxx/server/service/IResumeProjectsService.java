package com.xxx.server.service;

import com.xxx.server.pojo.RespBean;
import com.xxx.server.pojo.ResumeProjects;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mean
 * @since 2023-04-05
 */
public interface IResumeProjectsService extends IService<ResumeProjects> {

    /**
     * 根据resume_id获取Projects
     * @param resume_id
     * @return
     */
    RespBean getProjectsByResumeId(Integer resume_id);

    /**
     * 删除project
     * @param id
     * @return
     */
    RespBean deleteById(Integer id);
}
