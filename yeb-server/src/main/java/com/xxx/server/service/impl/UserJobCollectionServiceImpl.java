package com.xxx.server.service.impl;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxx.server.mapper.UserJobCollectionMapper;
import com.xxx.server.pojo.RespBean;
import com.xxx.server.pojo.UserJobCollection;
import com.xxx.server.service.IUserJobCollectionService;
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
}
