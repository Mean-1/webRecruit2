package com.xxx.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xxx.server.pojo.UserJobApplycation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    /**
     * 根据uid查询投递职位信息
     * @param page
     * @param state
     * @param uid
     * @return
     */
    IPage<UserJobApplycation> getApplyJobInfo(Page<UserJobApplycation> page, @Param("state") String state,@Param("uid") Integer uid);

    /**
     * 根据uid查询所有投递简历
     * @param page
     * @param uid
     * @return
     */
    IPage<UserJobApplycation> getAllResume(Page<UserJobApplycation> page,@Param("uid") Integer uid,@Param("status") String status);

    /**
     * 更新投递简历的状态
     * @param applyId
     * @param status
     * @return
     */
    int updateApplyStatus(@Param("applyId") Integer applyId,@Param("status") String status);

    /**
     * 根据uid获取少量投递简历
     * @param uid
     * @return
     */
    List<UserJobApplycation> getLittleResume(@Param("uid") Integer uid);
}
