package com.hit.aunt.minedays.entity;
import java.io.Serializable;
import java.util.Date;
public class Person implements Serializable {
    private Long userId;// 主键ID
    private String name;// 用户名称
    private String profileImg;// 用户头像
    private String email;// 用户邮箱
    private String gender;// 用户性别
    private Integer enableStatus;// 可用状态：0、被禁止 1、可用
    private Integer userType;// 1.顾客3.超级管理员
    private Date createTime;// 创建时间
    private Date lastEditTime;// 最近一次的更新时间

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(String profileImg) {
        this.profileImg = profileImg;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getEnableStatus() {
        return enableStatus;
    }

    public void setEnableStatus(Integer enableStatus) {
        this.enableStatus = enableStatus;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }
}
