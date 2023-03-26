package com.xxx.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxx.server.pojo.UserJobCollection;
import io.swagger.models.auth.In;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mean
 * @since 2023-03-24
 */
public interface UserJobCollectionMapper extends BaseMapper<UserJobCollection> {

    /**
     * 查询是否收藏
     * @param uid
     * @param jid
     * @return
     */
    UserJobCollection isCollection(Integer uid, Integer jid);
}
