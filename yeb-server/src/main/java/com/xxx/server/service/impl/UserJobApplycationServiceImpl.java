package com.xxx.server.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxx.server.mapper.UserJobApplycationMapper;
import com.xxx.server.pojo.RespBean;
import com.xxx.server.pojo.RespPageBean;
import com.xxx.server.pojo.UserJobApplycation;
import com.xxx.server.pojo.UserJobCollection;
import com.xxx.server.service.IUserJobApplycationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mean
 * @since 2023-03-24
 */
@Service
public class UserJobApplycationServiceImpl extends ServiceImpl<UserJobApplycationMapper, UserJobApplycation> implements IUserJobApplycationService {

    @Autowired
    private UserJobApplycationMapper userJobApplycationMapper;


    /**
     * 是否投递
     * @param uid
     * @param jid
     * @return
     */
    @Override
    public Boolean isApply(Integer uid, Integer jid) {
        userJobApplycationMapper.isCollection(uid,jid);
        System.out.println(userJobApplycationMapper.isCollection(uid,jid));
        if(null!=userJobApplycationMapper.isCollection(uid,jid)){
            return true;
        }
        return false;
    }

    /**
     * 添加投递
     * @param uid
     * @param jid
     * @return
     */
    @Override
    public RespBean addApply(Integer uid, Integer jid) {
        UserJobApplycation userJobApplycation = new UserJobApplycation();
        userJobApplycation.setUser_id(uid);
        userJobApplycation.setJob_id(jid);
        userJobApplycation.setState("0");
        userJobApplycation.setCreate_date(LocalDateTime.now());
        if(1==userJobApplycationMapper.insert(userJobApplycation)){
            return RespBean.success("success");
        }
        return RespBean.error("error");
    }

    /**
     * 删除投递
     * @param uid
     * @param jid
     * @return
     */
    @Override
    public RespBean deleteApply(Integer uid, Integer jid) {
        if(1==userJobApplycationMapper.delete(new QueryWrapper<UserJobApplycation>().eq("user_id", uid).eq("job_id", jid))){
            return RespBean.success("success");
        }
        return RespBean.error("error");
    }

    /**
     * 根据uid查询投递职位信息
     * @param currentPage
     * @param size
     * @param state
     * @param uid
     * @return
     */
    @Override
    public RespPageBean getApplyJobInfo(Integer currentPage, Integer size, String state, Integer uid) {

        Page<UserJobApplycation> page = new Page<>(currentPage,size);
        IPage<UserJobApplycation> applycationIPage = userJobApplycationMapper.getApplyJobInfo(page,state,uid);
        RespPageBean respPageBean = new RespPageBean(applycationIPage.getTotal(), applycationIPage.getRecords());

        return respPageBean;
    }

    /**
     * 批量投递
     * @param jids
     * @return
     */
    @Override
    public RespBean addLotApply(Integer[] jids,Integer uid) {

        int i=0;
        for (Integer jid : jids) {
            if(!isApply(uid, jid)){//如果该jid未投递
                UserJobApplycation userJobApplycation = new UserJobApplycation();
                userJobApplycation.setUser_id(uid);
                userJobApplycation.setJob_id(jid);
                userJobApplycation.setState("0");
                userJobApplycation.setCreate_date(LocalDateTime.now());
                i=userJobApplycationMapper.insert(userJobApplycation);
            }
        }
        if(0!=i){
            return RespBean.success("success");
        }
        return RespBean.error("投递失败");
    }

    /**
     * 根据uid查询所有投递简历
     * @param currentPage
     * @param size
     * @param uid
     * @return
     */
    @Override
    public RespPageBean getAllResume(Integer currentPage, Integer size, Integer uid, String status) {

        Page<UserJobApplycation> page = new Page<>(currentPage,size);
        IPage<UserJobApplycation> applycationIPage = userJobApplycationMapper.getAllResume(page,uid,status);
        RespPageBean respPageBean = new RespPageBean(applycationIPage.getTotal(), applycationIPage.getRecords());
        return respPageBean;
    }

    /**
     * 更新投递简历的状态
     * @param selectedApplyIds
     * @param status
     * @return
     */
    @Override
    @Transactional
    public RespBean updateApplyStatus(Integer[] selectedApplyIds, String status) {

        int i=0;
        UserJobApplycation userJobApplycation = new UserJobApplycation();
        userJobApplycation.setState(status);
        for (Integer applyId : selectedApplyIds) {
//            i=userJobApplycationMapper.updateApplyStatus(applyId,status);
            userJobApplycation.setId(applyId);
            i=userJobApplycationMapper.updateById(userJobApplycation);
        }
        if(0!=i){
            return RespBean.success("success");
        }
        return RespBean.error("error");
    }

    /**
     * 根据uid获取少量投递简历
     * @param uid
     * @return
     */
    @Override
    public List<UserJobApplycation> getLittleResume(Integer uid) {

        return userJobApplycationMapper.getLittleResume(uid);
    }

    /**
     * 根据uid查询少量投递职位信息
     * @param uid
     * @return
     */
    @Override
    public RespBean getLittleApplyJobInfo(Integer uid) {
        List<UserJobApplycation> list = userJobApplycationMapper.getLittleApplyJobInfo(uid);
        if(null!=list){
            return RespBean.success("success",list);
        }
        return RespBean.error("error");
    }
}
