package com.xxx.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxx.server.mapper.ResumeMapper;
import com.xxx.server.pojo.Resume;
import com.xxx.server.service.IResumeService;
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
public class ResumeServiceImpl extends ServiceImpl<ResumeMapper, Resume> implements IResumeService {

    @Autowired
    private ResumeMapper resumeMapper;

    /**
     * 根据rid获取resume
     * @param id
     * @return
     */
    @Override
    public Resume getResumeById(Integer id) {
        return resumeMapper.selectById(id);
    }
}
