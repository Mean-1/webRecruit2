package com.xxx.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxx.server.pojo.RespBean;
import com.xxx.server.pojo.UserJobCollection;
import io.swagger.models.auth.In;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mean
 * @since 2023-03-24
 */
public interface IUserJobCollectionService extends IService<UserJobCollection> {

    /**
     * 查询是否收藏
     * @param uid
     * @param jid
     * @return
     */
    RespBean isCollection(Integer uid,Integer jid);

    /**
     * 添加收藏
     * @param uid
     * @param jid
     * @return
     */
    RespBean addCollection(Integer uid, Integer jid);

    /**
     * 删除收藏
     * @param uid
     * @param jid
     * @return
     */
    RespBean deleteCollection(Integer uid, Integer jid);
}
