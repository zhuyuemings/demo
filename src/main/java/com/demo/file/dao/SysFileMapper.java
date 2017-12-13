package com.demo.file.dao;

import com.demo.file.domain.SysFile;
import com.demo.file.domain.SysFileExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysFileMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_file
     *
     * @mbg.generated Wed Dec 13 16:38:01 CST 2017
     */
    long countByExample(SysFileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_file
     *
     * @mbg.generated Wed Dec 13 16:38:01 CST 2017
     */
    int deleteByExample(SysFileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_file
     *
     * @mbg.generated Wed Dec 13 16:38:01 CST 2017
     */
    int insert(SysFile record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_file
     *
     * @mbg.generated Wed Dec 13 16:38:01 CST 2017
     */
    int insertSelective(SysFile record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_file
     *
     * @mbg.generated Wed Dec 13 16:38:01 CST 2017
     */
    List<SysFile> selectByExample(SysFileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_file
     *
     * @mbg.generated Wed Dec 13 16:38:01 CST 2017
     */
    int updateByExampleSelective(@Param("record") SysFile record, @Param("example") SysFileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_file
     *
     * @mbg.generated Wed Dec 13 16:38:01 CST 2017
     */
    int updateByExample(@Param("record") SysFile record, @Param("example") SysFileExample example);
}