package com.hit.aunt.minedays.controller;

import com.hit.aunt.minedays.entity.Person;
import com.hit.aunt.minedays.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoginController {
    @Autowired
    private PersonService personServices;
    //模拟用户登录验证
    @RequestMapping(value = "/login/{email1}/{pass1}", method = RequestMethod.GET)
    public Object login(@PathVariable String email1, @PathVariable String pass1) {
        List<Person> l=personServices.query(email1.substring(5));
        if (l.size()== 0) {
            return "error";
        }
        else if(!l.get(1).getName().equals(pass1)){
            return "error";
        }
        System.out.println(email1);
        System.out.println(pass1);
        return "success";
    }
//    @Autowired
//    private PersonService personServices;
//    @RequestMapping(value="/index",method=RequestMethod.POST)
//    @ResponseBody//这个注释在控制器为RestController的情况下加不加都一样，但是如果控制器是Controller类型就必须要加了,它可以把返回的对象直接解析为json对象返回客户端(强！)
//    private String ajax(@RequestBody Person p1)//@RequestBody是作用于参数的，它实现了把客户端传过来的json数据解析为对象，作为参数传进来，不过客户端传过来的数据类型必须是application/json,不然会出错，这也是为什么客户端一定要设置ajax的contentType属性为"application/json"的原因
//    {
//        System.out.println("收到ajax请求");
//        List list =personServices.query(p1.getUserId());
//        if (list == null) {
//            return "error";
//        }
//        else{
//            return "success";
//        }
//    }
}
