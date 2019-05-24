package com.hit.minedays.service;
import com.hit.minedays.entity.Account;
import java.util.List;
public interface AccountService {

    //写入数据
    int add(Account x);

    //删除数据
    int delete(Long x);

    //根据邮箱查询
    List<Account> emlquery(String email);

    //根据ID查询
    List<Account> idquery(Long id);

    //更新数据
    int update(Account x);
}
