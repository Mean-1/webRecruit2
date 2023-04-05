package com.xxx.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xxx.server.pojo.RespBean;
import com.xxx.server.pojo.ResumeSelfevaluation;
import com.xxx.server.mapper.ResumeSelfevaluationMapper;
import com.xxx.server.service.IResumeSelfevaluationService;
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
public class ResumeSelfevaluationServiceImpl extends ServiceImpl<ResumeSelfevaluationMapper, ResumeSelfevaluation> implements IResumeSelfevaluationService {

    @Autowired
    private ResumeSelfevaluationMapper resumeSelfevaluationMapper;

    /**
     * 根据resume_id获取SelfEvaluation
     * @param resume_id
     * @return
     */
    @Override
    public RespBean getEducationByResumeId(Integer resume_id) {
        ResumeSelfevaluation resumeSelfevaluation = resumeSelfevaluationMapper.selectOne(new QueryWrapper<ResumeSelfevaluation>().eq("resume_id", resume_id));

        if(null!=resumeSelfevaluation){
            return RespBean.success("success",resumeSelfevaluation);
        }
        return RespBean.error("error");
    }
}
