package com.hit.minedays.controller;
import com.hit.minedays.entity.Account;
import com.hit.minedays.entity.Person;
import com.hit.minedays.service.AccountService;
import com.hit.minedays.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

@RestController
public class SignupController {
    @Autowired
    private AccountService accountService;
    private PersonService  personService;
    private String email;
    @RequestMapping("signup")
    @ResponseBody
    public String signup(@RequestBody Account account) {
        List<Account> l = accountService.emlquery(account.getEmail().substring(0, 5));
        System.out.println(account.getEmail());
        email = account.getEmail();
        System.out.println(account.getPassword());
        if (l.size() == 0) {//未搜索到,可以注册
            Date date=new Date();
            account.setCreateTime(date);
            account.setLastEditTime(date);
            accountService.add(account);
//
//            List<Account> e = accountService.emlquery(account.getEmail().substring(0, 5));
//            account.setUserID(e.get(0).getAccountID());
//            accountService.updateuserid(account);

            return "SUCCESS";
        }
        else {//账号已存在
            System.out.println("账号已存在");
            return "EXIST";
        }
    }

    @RequestMapping("addPerson")
    @ResponseBody
    public String addPerson(@RequestBody Person person) {
        person.setEmail(email);
        person.setEnableStatus(1);
        person.setUserType(1);
        Date date=new Date();
        person.setCreateTime(date);
        person.setLastEditTime(date);
        personService.add(person);

        List<Person> l = personService.emlquery(email);
        Account account = new Account();
        account.setUserID(l.get(0).getUserId());
        account.setEmail(email);
        accountService.updateuserid(account);
        return "SUCCESS";
    }
}