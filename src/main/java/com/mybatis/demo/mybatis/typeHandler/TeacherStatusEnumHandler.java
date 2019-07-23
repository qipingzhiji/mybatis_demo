package com.mybatis.demo.mybatis.typeHandler;

import com.mybatis.demo.enums.TeacherStatuesEnum;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by zhang_htao on 2019/7/23.
 */
public class TeacherStatusEnumHandler implements TypeHandler<TeacherStatuesEnum> {
    @Override
    public void setParameter(PreparedStatement ps, int i, TeacherStatuesEnum parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i,String.valueOf(parameter.getCode()));
    }

    @Override
    public TeacherStatuesEnum getResult(ResultSet rs, String columnName) throws SQLException {
        return TeacherStatuesEnum.getStatusByCode(Integer.valueOf(rs.getString(columnName)));
    }

    @Override
    public TeacherStatuesEnum getResult(ResultSet rs, int columnIndex) throws SQLException {
        return TeacherStatuesEnum.getStatusByCode(Integer.valueOf(rs.getString(columnIndex)));
    }

    @Override
    public TeacherStatuesEnum getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return null;
    }
}
