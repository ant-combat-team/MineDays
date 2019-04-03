package com.hit.aunt.minedays.entity;

import java.util.Date;

public class WechatAccount {
    private Long   wechatAuthId;// 主键ID
    private String openId;// 微信获取用户信息的凭证，对于某个公众号具有唯一性
    private Date   createTime;// 创建时间
    private Person person;// 用户信息

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Long getWechatAuthId() {
        return wechatAuthId;
    }

    public void setWechatAuthId(Long wechatAuthId) {
        this.wechatAuthId = wechatAuthId;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCreateTime() {
        return createTime;
    }
}
