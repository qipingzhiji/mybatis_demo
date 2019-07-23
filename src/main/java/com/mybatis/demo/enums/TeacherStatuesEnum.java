package com.mybatis.demo.enums;

import org.apache.ibatis.plugin.Intercepts;

/**
 * Created by zhang_htao on 2019/7/23.
 */
public enum TeacherStatuesEnum {
    LOGIN(100,"用户登录中"),
    LOGOUT(200,"用户登出"),
    REMOVE(300,"用户不存在");
    private  int code;
    private String status;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    TeacherStatuesEnum(int code, String status) {
        this.code = code;
        this.status = status;
    }

    public static TeacherStatuesEnum getStatusByCode(int code) {
        for (TeacherStatuesEnum teacherStatuesEnum : TeacherStatuesEnum.values()) {
            if(code == teacherStatuesEnum.getCode()) {
                return teacherStatuesEnum;
            }
        }
        return null;
    }
}
