package com.hit.aunt.minedays.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    @RequestMapping("/hit")
    public String index() {

        return "MineDays（在线行程管理系统）";

    }
}