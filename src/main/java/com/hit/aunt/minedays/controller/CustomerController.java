package com.hit.aunt.minedays.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomerController {
    @RequestMapping("/")
    public String login() {
        //return "index";
        return "login";
    }

}