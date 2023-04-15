package com.xxx.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xxx.server.mapper.ResumeMapper;
import com.xxx.server.mapper.UserResumeMapper;
import com.xxx.server.pojo.Resume;
import com.xxx.server.pojo.UserResume;
import com.xxx.server.service.IUserResumeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mean
 * @since 2023-04-04
 */
@Service
public class UserResumeServiceImpl extends ServiceImpl<UserResumeMapper, UserResume> implements IUserResumeService {

    @Autowired
    private UserResumeMapper userResumeMapper;

    @Autowired
    private ResumeMapper resumeMapper;

    /**
     * 根据uid查询rid
     * @param uid
     * @return
     */
    @Override
    public Integer getRidByUid(Integer uid) {

        UserResume userResume = userResumeMapper.selectOne(new QueryWrapper<UserResume>().eq("user_id", uid));
        if(null!=userResume){
            return userResume.getResume_id();
        }
        return 0;
    }

    /**
     * 添加新用户和简历的关系
     * @param uid
     * @return
     */
    @Override
    public Integer addUserResume(Integer uid) {

//        添加新的resume(内容为空)
        resumeMapper.insertOneDate(uid);
//        获取刚刚添加的resume的id
        Integer resume_id = resumeMapper.selectOne(new QueryWrapper<Resume>().eq("user_id", uid)).getId();

        UserResume userResume= new UserResume();
        userResume.setUser_id(uid);
        userResume.setResume_id(resume_id);
        if(0!=userResumeMapper.insert(userResume)){
            return resume_id;
        }

        return 0;
    }
}
