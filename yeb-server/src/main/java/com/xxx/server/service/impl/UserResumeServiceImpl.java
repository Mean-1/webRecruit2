package com.xxx.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xxx.server.mapper.UserResumeMapper;
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

    /**
     * 根据uid查询rid
     * @param uid
     * @return
     */
    @Override
    public Integer getRidByUid(Integer uid) {

        return userResumeMapper.selectOne(new QueryWrapper<UserResume>().eq("user_id", uid)).getResume_id();
    }
}
