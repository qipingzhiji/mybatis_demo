package com.mybatis.demo.config;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zhang_htao on 2019/7/23.
 */
@Configuration
public class MybatisBatchSqlSession {
    @Autowired
    private SqlSessionFactory factory;

    @Bean(name = "batchSession")
    public SqlSession batchSqlSession() {
        return new SqlSessionTemplate(factory, ExecutorType.BATCH);
    }
}
