package com.hit.aunt.minedays.controller;
import com.hit.aunt.minedays.entity.Person;
import com.hit.aunt.minedays.service.PersonService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoginController {

    @Autowired
    private PersonService personServices;

    //模拟用户登录验证
    @RequestMapping("/test1")
    @ResponseBody
    public Object login(Person person) {

        List<Person> l = personServices.emlquery(person.getEmail().substring(0, 5));
        System.out.println(person.getEmail());
        System.out.println(person.getName());
        if (l.size() == 0) {
            System.out.println("l.size()== 0");
            return "error";
        } else if (l.get(0).getName().equals(person.getName())) {
            System.out.println("OK");
            return "success";
        } else {
            System.out.println("!l.get(0).getName().equals(person.getName())");
            return "error";
        }
    }

    @RequestMapping("/test2")
    @ResponseBody
    public String login2(@RequestBody Person person) {

        List<Person> l = personServices.emlquery(person.getEmail().substring(0, 5));
        System.out.println(person.getEmail());
        System.out.println(person.getName());
        //JSONObject container1 = new JSONObject();
        if (l.size() == 0) {//未搜索到
            System.out.println("没有此账号");
            //container1.put("ANSW", "error");
            //return container1;
            return "NOTEXIST";
        } else if (l.get(0).getName().equals(person.getName())) {//密码匹配成功
            System.out.println("Success");
            //container1.put("ANSW", "success");
            //return container1;
            return "SUCCESS";
        } else {//密码不匹配
            System.out.println("Error");
            //container1.put("ANSW", "error");
            //return container1;
            return "ERROR";
        }
    }
}