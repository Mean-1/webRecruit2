package com.xxx.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxx.server.pojo.RespBean;
import com.xxx.server.pojo.UserJobApplycation;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mean
 * @since 2023-03-24
 */
public interface IUserJobApplycationService extends IService<UserJobApplycation> {

    /**
     * 是否投递
     * @param uid
     * @param jid
     * @return
     */
    RespBean isApply(Integer uid, Integer jid);

    /**
     * 添加投递
     * @param uid
     * @param jid
     * @return
     */
    RespBean addApply(Integer uid, Integer jid);

    /**
     * 删除投递
     * @param uid
     * @param jid
     * @return
     */
    RespBean deleteApply(Integer uid, Integer jid);
}
