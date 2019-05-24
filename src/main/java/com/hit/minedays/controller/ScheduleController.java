package com.hit.minedays.controller;

import com.hit.minedays.MinedaysApplication;
import com.hit.minedays.entity.GlobalValues;
import com.hit.minedays.entity.Schedule;
import com.hit.minedays.service.ScheduleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class ScheduleController {

    private ScheduleService scheduleService;
    private GlobalValues gv;
    @RequestMapping("addschedule")
    public String addschedule(Schedule schedule) {
        schedule.setAccountID(MinedaysApplication.gv.getAccountid());
        System.out.println("accountid记录成功");
        scheduleService.add(schedule);
        System.out.println("日程添加成功");
        return "SUCCESS";
    }
}
