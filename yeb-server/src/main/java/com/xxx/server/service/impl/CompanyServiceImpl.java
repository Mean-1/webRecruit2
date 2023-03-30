package com.xxx.server.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxx.server.mapper.CompanyMapper;
import com.xxx.server.pojo.*;
import com.xxx.server.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mean
 * @since 2023-03-20
 */
@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements ICompanyService {


    @Autowired
    private CompanyMapper companyMapper;


    /**
     * 获取所有company
     * @return
     */
    @Override
    public RespBean getCompany() {

        List<Company> companyList = companyMapper.getCompany();
        if(null!=companyList){
            return RespBean.success("success",companyList);
        }
        return RespBean.error("error");
    }

    /**
     *  分页查询公司
     * @param currentPage
     * @param size
     * @param companySearchParam
     * @return
     */
    @Override
    public RespPageBean getAllCompany(Integer currentPage, Integer size, CompanySearchParam companySearchParam) {
        Page<Company> page = new Page<>(currentPage,size);
        IPage<Company> companyByPage = companyMapper.getAllCompany(page,companySearchParam);

        RespPageBean respPageBean = new RespPageBean(companyByPage.getTotal(),companyByPage.getRecords());
        return respPageBean;
    }

    /**
     * 根据公司id查询公司信息
     * @param id
     * @return
     */
    @Override
    public Company getCompanyById(Integer id) {
        return companyMapper.getCompanyById(id);
    }

    /**
     * 根据公司id查询job的基本信息
     * @param cid
     * @return
     */
    @Override
    public List<Company> getJobByCompanyId(Integer cid) {
//        List<Company> jobByCompanyId = companyMapper.getJobByCompanyId(cid);
//
//        if(null!=jobByCompanyId){
//            return RespBean.success("success",jobByCompanyId);
//        }
//
//        return RespBean.error("error");
        List<Company> companies = companyMapper.getJobByCompanyId(cid);
        for (Company company : companies) {
            System.out.println(company);
        }
        return companyMapper.getJobByCompanyId(cid);
    }

    /**
     * 根据公司name查询公司id
     * @param name
     * @return
     */
    @Override
    public Integer getCompanyIdByName(String name) {
        return companyMapper.selectOne(new QueryWrapper<Company>().eq("name", name)).getId();
    }
}
