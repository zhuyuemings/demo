package com.demo.base;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.Serializable;
import java.util.List;

/**
 * 配置spring和junit整合，junit启动时加载springIOC容器 spring-test,junit
 * 继承AbstractTransactionalJUnit4SpringContextTests为测试数据添加事物回滚
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class BaseTest extends AbstractTransactionalJUnit4SpringContextTests {

    private final Logger logger = LoggerFactory.getLogger(BaseTest.class);

    protected void testQueryById(BaseMapper baseMapper, Serializable id) {
        Object obj = baseMapper.queryById(id);
        logger.info("根据主键Id(" + id + ")查询对象结果为：" + obj);
    }

    protected void testQueryByOffset(BaseMapper baseMapper, Serializable offset, Serializable limit) {
        List<Object> list = baseMapper.queryByOffset(offset, limit);
        logger.info("根据间距(" + offset + "," + limit + ")查询对象结果为：\n");
        for (Object o : list) {
            logger.info("list：" + o);
        }
    }

    protected void testQueryByObject(BaseMapper baseMapper, Object object) {
        List<Object> list = baseMapper.queryByObject(object);
        logger.info("根据对象(" + object.getClass() + ")查询对象结果为：\n");
        for (Object o : list) {
            logger.info("list：" + o);
        }
    }

    protected void testInsert(BaseMapper baseMapper, Object object) {
        int insert = baseMapper.insert(object);
        logger.info("插入对象(" + object + ")结果为：" + insert);

    }

    protected void testInsertSelective(BaseMapper baseMapper, Object object) {
        int insert = baseMapper.insertSelective(object);
        logger.info("插入对象(" + object + ")结果为：" + insert);

    }

    protected void testUpdateById(BaseMapper baseMapper, Object object) {
        int update = baseMapper.updateById(object);
        logger.info("更新对象（" + object + ")结果为" + update);
    }

    protected void testUpdateByIdSelective(BaseMapper baseMapper, Object object) {
        int update = baseMapper.updateByIdSelective(object);
        logger.info("更新对象（" + object + ")结果为" + update);
    }

    protected void testDeleteById(BaseMapper baseMapper, Serializable id) {
        int delete = baseMapper.deleteById(id);
        logger.info("根据主键Id(" + id + ")删除对象结果为：" + delete);

    }

}
