package com.hit.minedays.controller;
import com.hit.minedays.MinedaysApplication;
import com.hit.minedays.entity.Account;
import com.hit.minedays.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoginController {
    @Autowired
    private AccountService accountService;

    @RequestMapping("login")
    @ResponseBody
    public String login(@RequestBody Account account) {
        List<Account> l = accountService.emlquery(account.getEmail().substring(0, 5));
        System.out.println(account.getEmail());
        System.out.println(account.getPassword());
        if (l.size() == 0) {//未搜索到
            System.out.println("没有此账号");
            return "NOTEXIST";
        } else if (l.get(0).getPassword().equals(account.getPassword())) {//密码匹配成功
            MinedaysApplication.gv.setAccountid(l.get(0).getAccountID()); //存下AccountID全局变量，跨类变量
            System.out.println("Success");
            return "SUCCESS";
        } else {//密码不匹配
            System.out.println("Error");
            return "ERROR";
        }
    }
}