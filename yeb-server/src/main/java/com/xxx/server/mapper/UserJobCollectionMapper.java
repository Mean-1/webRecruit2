package com.xxx.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xxx.server.pojo.UserJobCollection;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 根据uid查询收藏职位信息
     * @param page
     * @param uid
     * @return
     */
    IPage<UserJobCollection> getCollectionJobInfo(Page<UserJobCollection> page, @Param("uid") Integer uid);
}
