package com.xxx.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xxx.server.pojo.RespBean;
import com.xxx.server.pojo.ResumeEducation;
import com.xxx.server.mapper.ResumeEducationMapper;
import com.xxx.server.service.IResumeEducationService;
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
        List<ResumeEducation> resumeEducations = resumeEducationMapper.selectList(new QueryWrapper<ResumeEducation>().eq("resume_id", resume_id));
        if(null!=resumeEducations){
            return RespBean.success("success",resumeEducations);
        }
        return RespBean.error("error");
    }

    /**
     * 删除education
     * @param id
     * @return
     */
    @Override
    public RespBean deleteById(Integer id) {
        int i = resumeEducationMapper.deleteById(id);
        if(1==i){
            return RespBean.success("success");
        }
        return RespBean.error("error");
    }
}
