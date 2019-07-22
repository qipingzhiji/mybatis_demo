package com.mybatis.demo.controller;

import com.mybatis.demo.entity.MbgExample;
import com.mybatis.demo.mapper.MbgMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by zhang_htao on 2019/7/22.
 */
@RestController
public class MbgController {
    @Autowired
    private MbgMapper dao;

    @RequestMapping("/all")
    public Object listAllMem(){
        return dao.selectAll();
    }

    @RequestMapping("/queryConditions")
    public Object queryByConditions(){
        MbgExample example = new MbgExample();
        MbgExample.Criteria criteria = example.createCriteria();
        criteria.andCreate_timeBetween(new Date(),new Date());
        System.out.println(example.toString());
        return dao.selectByPrimaryKey(1);
    }
}
