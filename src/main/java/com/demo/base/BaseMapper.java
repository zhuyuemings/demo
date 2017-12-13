package com.demo.base;


import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * 顶层数据库操作公共接口
 *
 * @param <T>
 * @author ymzhu
 */
@Repository
public interface BaseMapper<T> {

    T queryById(@Param("id") Serializable id);

    List<T> queryByOffset(@Param("offset") Serializable offset, @Param("limit") Serializable limit);

    List<T> queryByObject(@Param("t") T t);

    int insert(@Param("t") T t);

    int insertSelective(@Param("t") T t);

    int updateById(@Param("t") T t);

    int updateByIdSelective(@Param("t") T t);

    int deleteById(@Param("id") Serializable id);
}
