package com.xxx.server.service.impl;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxx.server.mapper.UserJobCollectionMapper;
import com.xxx.server.pojo.RespBean;
import com.xxx.server.pojo.RespPageBean;
import com.xxx.server.pojo.UserJobCollection;
import com.xxx.server.service.IUserJobCollectionService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mean
 * @since 2023-03-24
 */
@Service
public class UserJobCollectionServiceImpl extends ServiceImpl<UserJobCollectionMapper, UserJobCollection> implements IUserJobCollectionService {

    @Autowired
    private UserJobCollectionMapper userJobCollectionMapper;

    /**
     * 查询是否收藏
     * @param uid
     * @param jid
     * @return
     */
    @Override
    public RespBean isCollection(Integer uid,Integer jid) {

        userJobCollectionMapper.isCollection(uid,jid);
        System.out.println(userJobCollectionMapper.isCollection(uid,jid));
        if(null!=userJobCollectionMapper.isCollection(uid,jid)){
            return RespBean.success("success");
        }
        return RespBean.error("error");
    }

    /**
     * 添加收藏
     * @param uid
     * @param jid
     * @return
     */
    @Override
    public RespBean addCollection(Integer uid,Integer jid) {
        UserJobCollection userJobCollection = new UserJobCollection();
        userJobCollection.setUser_id(uid);
        userJobCollection.setJob_id(jid);
        if(1==userJobCollectionMapper.insert(userJobCollection)){
            return RespBean.success("success");
        }
        return RespBean.error("error");
    }

    /**
     * 删除收藏
     * @param uid
     * @param jid
     * @return
     */
    @Override
    public RespBean deleteCollection(Integer uid, Integer jid) {

        System.out.println(uid+"   "+jid);
        if(1==userJobCollectionMapper.delete(new QueryWrapper<UserJobCollection>().eq("user_id", uid).eq("job_id", jid))){
            return RespBean.success("success");
        }
        return RespBean.error("error");
    }

    /**
     * 根据uid查询收藏职位信息
     * @param currentPage
     * @param size
     * @param uid
     * @return
     */
    @Override
    public RespPageBean getCollectionJobInfo(Integer currentPage, Integer size, Integer uid) {
        Page<UserJobCollection> page = new Page<>(currentPage,size);
        IPage<UserJobCollection> collectionIPage = userJobCollectionMapper.getCollectionJobInfo(page,uid);
        RespPageBean respPageBean = new RespPageBean(collectionIPage.getTotal(), collectionIPage.getRecords());
        return respPageBean;
    }

    /**
     * 批量删除职位
     * @param selectedJobIds
     * @param uid
     * @return
     */
    @Override
    public RespBean deleteLotCollection(Integer[] selectedJobIds, Integer uid) {

        int i=0;
        for (Integer jid : selectedJobIds) {
            i=userJobCollectionMapper.delete(new QueryWrapper<UserJobCollection>().eq("user_id", uid).eq("job_id", jid));
        }
        if(1==i){
            return RespBean.success("success");
        }
        return RespBean.error("删除失败");
    }
}
