package com.xxx.server.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xxx.server.pojo.RespBean;
import com.xxx.server.pojo.RespPageBean;
import com.xxx.server.pojo.UserJobCollection;
import com.xxx.server.service.IUserJobCollectionService;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author mean
 * @since 2023-03-24
 */
@RestController
@RequestMapping("/user-job-collection")
public class UserJobCollectionController {

    @Autowired
    private IUserJobCollectionService userJobCollectionService;


    @ApiOperation(value = "查询是否收藏")
    @GetMapping("/isCollection/{uid}/{jid}")
    public RespBean isCollection(@PathVariable Integer uid,@PathVariable Integer jid){
        return userJobCollectionService.isCollection(uid,jid);
    }
//这里添加收藏和删除收藏可以不用采用添加，删除数据的方式，因为可能会造成数据残余堆积（我猜的），id值一直递增，
// 可以使用enabled字段来控制是否收藏，这样用户还可以找出收藏记录，或者收藏备份之类的
    @ApiOperation(value = "添加收藏")
    @PutMapping("/addCollection/{uid}/{jid}")
    public RespBean addCollection(@PathVariable Integer uid,@PathVariable Integer jid){
        return userJobCollectionService.addCollection(uid,jid);
    }

    @ApiOperation(value = "删除收藏")
    @DeleteMapping("/deleteCollection/{uid}/{jid}")
    public RespBean deleteCollection(@PathVariable Integer uid, @PathVariable Integer jid){
       return userJobCollectionService.deleteCollection(uid, jid);
    }

}
