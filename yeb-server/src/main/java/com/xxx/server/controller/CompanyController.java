package com.xxx.server.controller;


import com.xxx.server.pojo.*;
import com.xxx.server.service.ICompanyService;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author mean
 * @since 2023-03-20
 */
@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private ICompanyService companyService;

    @ApiOperation(value = "获取所有company")
    @GetMapping("/getCompany")
    public RespBean getCompany(){
        return companyService.getCompany();
    }

    @ApiOperation(value = "获取所有company(分页)")
    @GetMapping("/list")
    public RespPageBean getAllCompany(@RequestParam(defaultValue = "1") Integer currentPage,
                                      @RequestParam(defaultValue = "10") Integer size,
                                      CompanySearchParam companySearchParam){
        return companyService.getAllCompany(currentPage,size,companySearchParam);
    }

    @ApiOperation(value = "根据公司id获得company信息")
    @GetMapping("/getCompanyById/{id}")
    public Company getCompanyById(@PathVariable Integer id){
        return companyService.getCompanyById(id);
    }

    @ApiOperation(value = "根据公司id查询job的基本信息")
    @GetMapping("/getJobByCompanyId/{cid}")
    public List<Company> getJobByCompanyId(@PathVariable Integer cid){
        return companyService.getJobByCompanyId(cid);
    }

}
