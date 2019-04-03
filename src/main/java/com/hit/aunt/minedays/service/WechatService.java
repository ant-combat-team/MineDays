package com.hit.aunt.minedays.service;

import com.hit.aunt.minedays.entity.WechatAccount;

import java.util.List;

public interface WechatService {
    //写入数据
    int add(WechatAccount x);

    //删除数据
    int delete(Long x);

    //根据微信号查询（openID）
    List<WechatAccount> emlquery(String openID);

    //根据ID查询
    List<WechatAccount> idquery(Long wechatAuthId);

    //更新数据
    int update(WechatAccount x);
}
