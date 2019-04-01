package com.hit.aunt.minedays.service;
import com.hit.aunt.minedays.entity.Person;
import java.util.List;
public interface PersonService {

    //写入数据
    int add(Person x);

    //删除数据
    int delete(Long x);

    //查询
    List<Person> query(String email);

    //更新数据
    int update(Person x);
}
