package com.xxx.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxx.server.pojo.Company;
import com.xxx.server.pojo.CompanySearchParam;
import com.xxx.server.pojo.RespBean;
import com.xxx.server.pojo.RespPageBean;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mean
 * @since 2023-03-20
 */
public interface ICompanyService extends IService<Company> {



    /**
     * 获取所有company
     * @return
     */
    RespBean getCompany();

    /**
     * 分页查询所有公司
     * @param currentPage
     * @param size
     * @param companySearchParam
     * @return
     */
    RespPageBean getAllCompany(Integer currentPage, Integer size, CompanySearchParam companySearchParam);

    /**
     * 根据公司id查询公司信息
     * @param id
     * @return
     */
    Company getCompanyById(Integer id);

    /**
     * 根据公司id查询job的基本信息
     * @param cid
     * @return
     */
    List<Company> getJobByCompanyId(Integer cid);


    /**
     * 根据公司name查询公司id
     * @param name
     * @return
     */
    Integer getCompanyIdByName(String name);
}
