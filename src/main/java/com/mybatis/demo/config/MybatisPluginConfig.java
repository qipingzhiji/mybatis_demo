package com.mybatis.demo.config;

import com.mybatis.demo.plugins.MyBatisPlugin;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * Created by zhang_htao on 2019/7/23.
 */
@Configuration
@MapperScan(basePackages = {"classpath:com.mybatis.demo.mapper"})
public class MybatisPluginConfig {
    @Bean
    public MyBatisPlugin myPlugin() {
        MyBatisPlugin myBatisPlugin = new MyBatisPlugin();
        Properties properties = new Properties();
        properties.setProperty("user","root");
        myBatisPlugin.setProperties(properties);
        return myBatisPlugin;
    }
}
