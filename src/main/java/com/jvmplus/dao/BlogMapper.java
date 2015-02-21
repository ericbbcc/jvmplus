package com.jvmplus.dao;

import com.jvmplus.vo.Blog;
import com.jvmplus.vo.BlogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BlogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbggenerated Sun Feb 22 00:00:17 CST 2015
     */
    int countByExample(BlogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbggenerated Sun Feb 22 00:00:17 CST 2015
     */
    int deleteByExample(BlogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbggenerated Sun Feb 22 00:00:17 CST 2015
     */
    int deleteByPrimaryKey(String blogId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbggenerated Sun Feb 22 00:00:17 CST 2015
     */
    int insert(Blog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbggenerated Sun Feb 22 00:00:17 CST 2015
     */
    int insertSelective(Blog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbggenerated Sun Feb 22 00:00:17 CST 2015
     */
    List<Blog> selectByExampleWithBLOBs(BlogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbggenerated Sun Feb 22 00:00:17 CST 2015
     */
    List<Blog> selectByExample(BlogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbggenerated Sun Feb 22 00:00:17 CST 2015
     */
    Blog selectByPrimaryKey(String blogId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbggenerated Sun Feb 22 00:00:17 CST 2015
     */
    int updateByExampleSelective(@Param("record") Blog record, @Param("example") BlogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbggenerated Sun Feb 22 00:00:17 CST 2015
     */
    int updateByExampleWithBLOBs(@Param("record") Blog record, @Param("example") BlogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbggenerated Sun Feb 22 00:00:17 CST 2015
     */
    int updateByExample(@Param("record") Blog record, @Param("example") BlogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbggenerated Sun Feb 22 00:00:17 CST 2015
     */
    int updateByPrimaryKeySelective(Blog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbggenerated Sun Feb 22 00:00:17 CST 2015
     */
    int updateByPrimaryKeyWithBLOBs(Blog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbggenerated Sun Feb 22 00:00:17 CST 2015
     */
    int updateByPrimaryKey(Blog record);
}