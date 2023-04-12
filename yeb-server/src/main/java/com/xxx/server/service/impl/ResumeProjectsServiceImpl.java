package com.xxx.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xxx.server.pojo.RespBean;
import com.xxx.server.pojo.ResumeProjects;
import com.xxx.server.mapper.ResumeProjectsMapper;
import com.xxx.server.service.IResumeProjectsService;
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
public class ResumeProjectsServiceImpl extends ServiceImpl<ResumeProjectsMapper, ResumeProjects> implements IResumeProjectsService {

    @Autowired
    private ResumeProjectsMapper resumeProjectsMapper;

    /**
     * 根据resume_id获取Projects
     * @param resume_id
     * @return
     */
    @Override
    public RespBean getProjectsByResumeId(Integer resume_id) {
        List<ResumeProjects> resumeProjects = resumeProjectsMapper.selectList(new QueryWrapper<ResumeProjects>().eq("resume_id", resume_id));
        if(null!=resumeProjects){
            return RespBean.success("success",resumeProjects);
        }
        return RespBean.error("error");
    }

    /**
     * 删除project
     * @param id
     * @return
     */
    @Override
    public RespBean deleteById(Integer id) {
        if(1==resumeProjectsMapper.deleteById(id)){
            return RespBean.success("success");
        }
        return RespBean.error("删除失败");
    }
}
