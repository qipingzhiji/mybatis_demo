package com.mybatis.demo.plugins;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.sql.Statement;
import java.util.Properties;

/**
 * Created by zhang_htao on 2019/7/23.
 */
//完成插件的签名
@Intercepts(value = {@Signature(type = StatementHandler.class,method = "parameterize",args = Statement.class)})
public class MyBatisPlugin implements Interceptor {


    //对被拦截的文件进行放行
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        //System.out.println("MyBatisPlugin 执行拦截的方法是" + invocation.getTarget().getClass().getName());
        MetaObject metaObject = SystemMetaObject.forObject(invocation.getTarget());
        Object value = metaObject.getValue("parameterHandler.parameterObject");
        //System.out.println("当前sql执行时的入参为："+value);
       // metaObject.setValue("parameterHandler.parameterObject",1);
        Object proceed = invocation.proceed();
        return proceed;
    }
    //包装目标对象
    @Override
    public Object plugin(Object target) {
        Object wrap = Plugin.wrap(target, this);
        return wrap;
    }

    //插件注册时的属性值
    @Override
    public void setProperties(Properties properties) {
        System.out.println("MyBatisPlugin 属性值" + properties.toString());
    }
}
