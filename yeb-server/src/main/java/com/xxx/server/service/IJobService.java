package com.xxx.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxx.server.pojo.Job;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mean
 * @since 2023-03-20
 */
public interface IJobService extends IService<Job> {

    /**
     * 查询所有职位
     * @return
     */
    List<Job> getAllJob();
}
