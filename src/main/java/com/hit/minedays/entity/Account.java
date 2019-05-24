package com.hit.minedays.entity;

import java.util.Date;

public class Account {
    private Long       AccountID;// 主键ID
    private String     email;//邮箱账号
    private String     password;// 密码
    private Date       createTime;// 创建时间
    private Date       lastEditTime;// 最近一次的更新时间
    private Long     userID;// 个人信息，关系为一一对应

    public Long getAccountID() {
        return AccountID;
    }

    public void setAccountID(Long accountid) {
        AccountID = accountid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public void setUserID(Long userID) {
        this.userID = userID;
    }
    public Long getUserID() {
        return userID;
    }
}
