package com.xxx.server.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxx.server.mapper.CompanyMapper;
import com.xxx.server.pojo.Company;
import com.xxx.server.service.ICompanyService;
import org.springframework.stereotype.Service;

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

}
