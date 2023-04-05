package com.xxx.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxx.server.pojo.RecruiterCompany;
import com.xxx.server.pojo.RespBean;
import com.xxx.server.pojo.UpdateRecruiterInfoParam;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mean
 * @since 2023-03-30
 */
public interface IRecruiterCompanyService extends IService<RecruiterCompany> {

    /**
     * 根据uid获得info
     * @param id
     * @return
     */
    RespBean getInfo(Integer id);

    /**
     * 更新招聘者的基本信息
     * @param updateRecruiterInfoParam
     * @return
     */
    RespBean updateInfo( UpdateRecruiterInfoParam updateRecruiterInfoParam);



}
