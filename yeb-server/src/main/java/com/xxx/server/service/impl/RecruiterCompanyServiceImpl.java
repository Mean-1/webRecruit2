package com.xxx.server.service.impl;

import com.xxx.server.mapper.RecruiterCompanyMapper;
import com.xxx.server.pojo.RecruiterCompany;
import com.xxx.server.pojo.RespBean;
import com.xxx.server.pojo.UpdateRecruiterInfoParam;
import com.xxx.server.service.ICompanyService;
import com.xxx.server.service.IRecruiterCompanyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mean
 * @since 2023-03-30
 */
@Service
public class RecruiterCompanyServiceImpl extends ServiceImpl<RecruiterCompanyMapper, RecruiterCompany> implements IRecruiterCompanyService {

    @Autowired
    private RecruiterCompanyMapper recruiterCompanyMapper;

    @Autowired
    private ICompanyService companyService;

    /**
     * 根据uid获得info
     * @param id
     * @return
     */
    @Override
    public RespBean getInfo(Integer id) {

        RecruiterCompany info = recruiterCompanyMapper.getInfo(id);
        if(null!=info){
            return RespBean.success("success",info);
        }
        return RespBean.error("未找到");
    }

    /**
     * 更新招聘者的基本信息
     * @param updateRecruiterInfoParam
     * @return
     */
    @Override
    public RespBean updateInfo(UpdateRecruiterInfoParam updateRecruiterInfoParam) {

        Integer c_id = companyService.getCompanyIdByName(updateRecruiterInfoParam.getName());
        if(0!=recruiterCompanyMapper.updateInfo(updateRecruiterInfoParam.getUid(),updateRecruiterInfoParam.getUsername(),updateRecruiterInfoParam.getGender(),
                updateRecruiterInfoParam.getDuty(),c_id)){
            return RespBean.success("success");
        }


        return RespBean.error("更新失败");
    }


}
