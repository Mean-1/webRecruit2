package com.xxx.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxx.server.pojo.Resume;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mean
 * @since 2023-04-04
 */
public interface IResumeService extends IService<Resume> {

    /**
     * 根据rid获取resume
     * @param id
     * @return
     */
    Resume getResumeById(Integer id);
}
