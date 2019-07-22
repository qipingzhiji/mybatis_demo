package com.mybatis.demo.mapper;

import com.mybatis.demo.entity.Mbg;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MbgMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mbg
     *
     * @mbg.generated Mon Jul 22 21:05:46 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mbg
     *
     * @mbg.generated Mon Jul 22 21:05:46 CST 2019
     */
    int insert(Mbg record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mbg
     *
     * @mbg.generated Mon Jul 22 21:05:46 CST 2019
     */
    Mbg selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mbg
     *
     * @mbg.generated Mon Jul 22 21:05:46 CST 2019
     */
    List<Mbg> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mbg
     *
     * @mbg.generated Mon Jul 22 21:05:46 CST 2019
     */
    int updateByPrimaryKey(Mbg record);
}