package com.xxx.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xxx.server.pojo.Company;
import com.xxx.server.pojo.CompanySearchParam;
import com.xxx.server.pojo.RespBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mean
 * @since 2023-03-20
 */
public interface CompanyMapper extends BaseMapper<Company> {

    /**
     * 分页查询公司
     * @param page
     * @return
     */
    IPage<Company> getAllCompany(Page<Company> page, @Param("companySearchParam")CompanySearchParam companySearchParam);

    /**
     * 根据公司id查询公司信息
     * @param id
     * @return
     */
    Company getCompanyById(@Param("id") Integer id);

    /**
     * 根据公司id查询job的基本信息
     * @param cid
     * @return
     */
    List<Company> getJobByCompanyId(@Param("cid") Integer cid);

    /**
     * 获取所有company
     * @return
     */
    List<Company> getCompany();
}
