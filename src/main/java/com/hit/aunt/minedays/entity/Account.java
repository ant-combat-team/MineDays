package com.hit.aunt.minedays.entity;

import java.util.Date;

public class Account {
    private Long       Account;// 主键ID
    private String     username;// 用户名
    private String     password;// 密码
    private Date       createTime;// 创建时间
    private Date       lastEditTime;// 最近一次的更新时间
    private Person person;// 个人信息，关系为一一对应

    public Long getAccount() {
        return Account;
    }

    public void setAccount(Long account) {
        Account = account;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
