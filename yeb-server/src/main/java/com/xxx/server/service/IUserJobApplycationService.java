package com.xxx.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxx.server.pojo.RespBean;
import com.xxx.server.pojo.RespPageBean;
import com.xxx.server.pojo.UserJobApplycation;
import io.swagger.models.auth.In;

import java.util.List;

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
    Boolean isApply(Integer uid, Integer jid);

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

    /**
     * 根据uid查询投递职位信息
     * @param currentPage
     * @param size
     * @param state
     * @param uid
     * @return
     */
    RespPageBean getApplyJobInfo(Integer currentPage, Integer size, String state, Integer uid);

    /**
     * 批量投递
     * @param jids
     * @return
     */
    RespBean addLotApply(Integer[] jids, Integer uid);

    /**
     * 根据uid查询所有投递简历
     * @param currentPage
     * @param size
     * @param uid
     * @return
     */
    RespPageBean getAllResume(Integer currentPage, Integer size, Integer uid, String status);

    /**
     * 更新投递简历的状态
     * @param selectedApplyIds
     * @param status
     * @return
     */
    RespBean updateApplyStatus(Integer[] selectedApplyIds, String status);

    /**
     * 根据uid获取少量投递简历
     * @param uid
     * @return
     */
    List<UserJobApplycation> getLittleResume(Integer uid);
}
