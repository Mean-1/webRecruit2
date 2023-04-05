package com.xxx.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xxx.server.pojo.RespBean;
import com.xxx.server.pojo.ResumeBaseinfo;
import com.xxx.server.mapper.ResumeBaseinfoMapper;
import com.xxx.server.service.IResumeBaseinfoService;
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
public class ResumeBaseinfoServiceImpl extends ServiceImpl<ResumeBaseinfoMapper, ResumeBaseinfo> implements IResumeBaseinfoService {

    @Autowired
    private ResumeBaseinfoMapper resumeBaseinfoMapper;
    /**
     * 根据resume_id获取baseinfo
     * @param resume_id
     * @return
     */
    @Override
    public RespBean getBaseInfoByResumeId(Integer resume_id) {
        ResumeBaseinfo baseinfo = resumeBaseinfoMapper.selectOne(new QueryWrapper<ResumeBaseinfo>().eq("resume_id", resume_id));
        if(null!=baseinfo){
            return RespBean.success("success",baseinfo);
        }
        return RespBean.error("error");
    }
}
