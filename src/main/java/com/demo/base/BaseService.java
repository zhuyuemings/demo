package com.demo.base;

import java.io.Serializable;
import java.util.List;

/**
 * 顶层服务接口
 *
 * @param <T>
 */
public interface BaseService<T> {

    /**
     * 通过主键Id获取对象
     *
     * @param id
     * @return T
     */
    T queryById(Serializable id);

    /**
     * 通过间距获取对象列表
     *
     * @param offset
     * @param limit
     * @return List<T>
     */
    List<T> queryByOffset(Serializable offset, Serializable limit);

    /**
     * 通过对象获取对象列表
     *
     * @param t
     * @return List<T>
     */
    List<T> queryByObject(T t);

    /**
     * 插入对象
     *
     * @param t
     * @return int
     */
    int insert(T t);

    /**
     * 插入对象（可包含空值）
     *
     * @param t
     * @return int
     */
    int insertSelective(T t);

    /**
     * 更新对象
     *
     * @param t
     * @return int
     */
    int updateById(T t);

    /**
     * 更新对象（可包含空值）
     *
     * @param t
     * @return int
     */
    int updateByIdSelective(T t);

    /**
     * 根据主键Id删除对象
     *
     * @param id
     * @return int
     */
    int deleteById(Serializable id);
}
