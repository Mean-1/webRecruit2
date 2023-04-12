package com.xxx.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xxx.server.pojo.RespBean;
import com.xxx.server.pojo.ResumeSkill;
import com.xxx.server.mapper.ResumeSkillMapper;
import com.xxx.server.service.IResumeSkillService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        List<ResumeSkill> resumeSkills = resumeSkillMapper.selectList(new QueryWrapper<ResumeSkill>().eq("resume_id", resume_id));

        if(null!=resumeSkills){
            return RespBean.success("success",resumeSkills);
        }
        return RespBean.error("error");
    }

    /**
     * 删除skill
     * @param id
     * @return
     */
    @Override
    public RespBean deleteById(Integer id) {
        if(1==resumeSkillMapper.deleteById(id)){
            return RespBean.success("success");
        }
        return RespBean.error("删除失败");
    }
}
