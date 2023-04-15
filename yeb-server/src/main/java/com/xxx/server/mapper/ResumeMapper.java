package com.xxx.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxx.server.pojo.Resume;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mean
 * @since 2023-04-04
 */
public interface ResumeMapper extends BaseMapper<Resume> {

    /**
     * 添加一个resume（传入uid的值）
     * @return
     */
    int insertOneDate(@Param("uid") Integer uid);
}
