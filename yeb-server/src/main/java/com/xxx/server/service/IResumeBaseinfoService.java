package com.xxx.server.service;

import com.xxx.server.pojo.RespBean;
import com.xxx.server.pojo.ResumeBaseinfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mean
 * @since 2023-04-05
 */
public interface IResumeBaseinfoService extends IService<ResumeBaseinfo> {

    /**
     * 根据resume_id获取baseinfo
     * @param resume_id
     * @return
     */
    RespBean getBaseInfoByResumeId(Integer resume_id);
}
