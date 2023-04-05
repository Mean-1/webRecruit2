package com.xxx.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xxx.server.pojo.RespBean;
import com.xxx.server.pojo.ResumeEducation;
import com.xxx.server.mapper.ResumeEducationMapper;
import com.xxx.server.service.IResumeEducationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mean
 * @since 2023-04-05
 */
@Service
public class ResumeEducationServiceImpl extends ServiceImpl<ResumeEducationMapper, ResumeEducation> implements IResumeEducationService {

    @Autowired
    private ResumeEducationMapper resumeEducationMapper;

    /**
     * 根据resume_id获取education
     * @param resume_id
     * @return
     */
    @Override
    public RespBean getEducationByResumeId(Integer resume_id) {
        ResumeEducation resumeEducation = resumeEducationMapper.selectOne(new QueryWrapper<ResumeEducation>().eq("resume_id", resume_id));
        if(null!=resumeEducation){
            return RespBean.success("success",resumeEducation);
        }
        return RespBean.error("error");
    }
}
