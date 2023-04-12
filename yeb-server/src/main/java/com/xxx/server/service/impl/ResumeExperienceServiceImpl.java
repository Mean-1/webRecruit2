package com.xxx.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xxx.server.pojo.RespBean;
import com.xxx.server.pojo.ResumeExperience;
import com.xxx.server.mapper.ResumeExperienceMapper;
import com.xxx.server.service.IResumeExperienceService;
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
public class ResumeExperienceServiceImpl extends ServiceImpl<ResumeExperienceMapper, ResumeExperience> implements IResumeExperienceService {

    @Autowired
    private ResumeExperienceMapper resumeExperienceMapper;


    /**
     * 根据resume_id获取experience
     * @param resume_id
     * @return
     */
    @Override
    public RespBean getExperienceByResumeId(Integer resume_id) {
        List<ResumeExperience> resumeExperiences = resumeExperienceMapper.selectList(new QueryWrapper<ResumeExperience>().eq("resume_id", resume_id));
        if(null!=resumeExperiences){
            return RespBean.success("success",resumeExperiences);
        }
        return RespBean.error("error");
    }

    /**
     * 删除experience
     * @param id
     * @return
     */
    @Override
    public RespBean deleteById(Integer id) {
        if(1==resumeExperienceMapper.deleteById(id)){
            return RespBean.success("success");
        }
        return RespBean.error("error");
    }
}
