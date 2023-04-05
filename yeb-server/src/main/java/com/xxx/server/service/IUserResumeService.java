package com.xxx.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxx.server.pojo.UserResume;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mean
 * @since 2023-04-04
 */
public interface IUserResumeService extends IService<UserResume> {

    /**
     * 根据uid查询rid
     * @param uid
     * @return
     */
    Integer getRidByUid(Integer uid);
}
