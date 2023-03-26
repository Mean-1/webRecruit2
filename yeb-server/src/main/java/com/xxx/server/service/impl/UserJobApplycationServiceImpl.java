package com.xxx.server.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxx.server.mapper.UserJobApplycationMapper;
import com.xxx.server.pojo.RespBean;
import com.xxx.server.pojo.UserJobApplycation;
import com.xxx.server.pojo.UserJobCollection;
import com.xxx.server.service.IUserJobApplycationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public RespBean isApply(Integer uid, Integer jid) {
        userJobApplycationMapper.isCollection(uid,jid);
        System.out.println(userJobApplycationMapper.isCollection(uid,jid));
        if(null!=userJobApplycationMapper.isCollection(uid,jid)){
            return RespBean.success("success");
        }
        return RespBean.error("error");
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
}
