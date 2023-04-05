package com.xxx.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xxx.server.pojo.RespBean;
import com.xxx.server.pojo.ResumeIntention;
import com.xxx.server.mapper.ResumeIntentionMapper;
import com.xxx.server.service.IResumeIntentionService;
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
public class ResumeIntentionServiceImpl extends ServiceImpl<ResumeIntentionMapper, ResumeIntention> implements IResumeIntentionService {

    @Autowired
    private ResumeIntentionMapper resumeIntentionMapper;

    /**
     * 根据resume_id获取intention
     * @param resume_id
     * @return
     */
    @Override
    public RespBean getEducationByResumeId(Integer resume_id) {
        ResumeIntention resumeIntention = resumeIntentionMapper.selectOne(new QueryWrapper<ResumeIntention>().eq("resume_id", resume_id));
        if(null!=resumeIntention){
            return RespBean.success("success",resumeIntention);
        }


        return RespBean.error("error");
    }
}
