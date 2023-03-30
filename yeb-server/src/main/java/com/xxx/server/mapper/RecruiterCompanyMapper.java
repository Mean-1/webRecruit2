package com.xxx.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxx.server.pojo.RecruiterCompany;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mean
 * @since 2023-03-30
 */
public interface RecruiterCompanyMapper extends BaseMapper<RecruiterCompany> {

    /**
     * 根据uid获得info
     * @param uid
     * @return
     */
    RecruiterCompany getInfo(@Param("uid") Integer uid);

    /**
     * 更新招聘者的基本信息
     * @param username
     * @param gender
     * @param duty
     * @param cid
     * @return
     */
    Integer updateInfo(@Param("uid") Integer uid, @Param("username") String username, @Param("gender") String gender,
                       @Param("duty") String duty, @Param("cid") Integer cid);
}
