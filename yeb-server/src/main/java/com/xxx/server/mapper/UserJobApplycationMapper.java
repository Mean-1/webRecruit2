package com.xxx.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxx.server.pojo.UserJobApplycation;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mean
 * @since 2023-03-24
 */
public interface UserJobApplycationMapper extends BaseMapper<UserJobApplycation> {

    /**
     * 是否投递
     * @param uid
     * @param jid
     * @return
     */
    UserJobApplycation isCollection(Integer uid, Integer jid);
}
