package com.hit.aunt.minedays.service;

import com.hit.aunt.minedays.entity.Person;
import com.hit.aunt.minedays.entity.Schedule;

import java.util.List;

public interface ScheduleService {
    //写入数据
    int add(Schedule x);

    //删除数据
    int delete(Long x);

    //根据用户查询
    List<Schedule> perquery(Person p);

    //根据ID查询
    List<Schedule> idquery(Long id);

    //更新数据
    int update(Schedule x);
}
