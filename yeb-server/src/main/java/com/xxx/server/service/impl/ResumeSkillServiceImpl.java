package com.xxx.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xxx.server.pojo.RespBean;
import com.xxx.server.pojo.ResumeSkill;
import com.xxx.server.mapper.ResumeSkillMapper;
import com.xxx.server.service.IResumeSkillService;
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
public class ResumeSkillServiceImpl extends ServiceImpl<ResumeSkillMapper, ResumeSkill> implements IResumeSkillService {

    @Autowired
    private ResumeSkillMapper resumeSkillMapper;

    /**
     * 根据resume_id获取Skill
     * @param resume_id
     * @return
     */
    @Override
    public RespBean getEducationByResumeId(Integer resume_id) {
        ResumeSkill resumeSkill = resumeSkillMapper.selectOne(new QueryWrapper<ResumeSkill>().eq("resume_id", resume_id));

        if(null!=resumeSkill){
            return RespBean.success("success",resumeSkill);
        }
        return RespBean.error("error");
    }
}
