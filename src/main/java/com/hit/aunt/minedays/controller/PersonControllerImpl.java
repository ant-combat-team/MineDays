package com.hit.aunt.minedays.controller;
import com.hit.aunt.minedays.entity.Person;
import com.hit.aunt.minedays.service.Impl.PersonServiceImpl;
import com.hit.aunt.minedays.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@RestController
public class PersonControllerImpl {
    @Autowired
    private PersonService personServices;

    /**
     *新增数据
     * */
    @RequestMapping("/add")
    public String save() {
        Person a=new Person();
        Long x=new Long(50);
        a.setUserId(x);
        a.setName("TT");
        a.setProfileImg("5");
        a.setEmail("uuuuu");
        a.setGender("n");
        a.setEnableStatus(1);
        a.setUserType(2);
        Calendar cal= Calendar.getInstance();
        a.setCreateTime(cal.getTime());
        a.setLastEditTime(cal.getTime());
        int row = personServices.add(a);
        //判断结果
        if(row==-1) {
            return "新增失败";
        }
        else{
            return "新增成功";
        }
    }
    /**
     * 查询数据
     * */
    @RequestMapping("/query")
    public String query(){
        //查寻数据
        List list =personServices.query("s");
        //组装数据
        List newlist = new ArrayList();
        //循环取出结果
        for (int i = 0; i <list.size() ; i++) {
            //新建学生对象
            Person person = (Person) list.get(i);
            //填充数据
            newlist.add(person.getUserId());
            newlist.add(person.getName());
            newlist.add(person.getProfileImg());
            newlist.add(person.getEmail());
            newlist.add(person.getGender());
            newlist.add(person.getEnableStatus());
            newlist.add(person.getUserType());
            newlist.add(person.getCreateTime());
            newlist.add(person.getLastEditTime());
        }
        //返回数据
        return newlist.toString();
    }
    /**
     * 更新数据
     * */
    @RequestMapping("/update")
    public String update(){
        //新建对象传递数据
        Person a = new Person();
        Long x=new Long(50);
        a.setUserId(x);
        a.setName("TxgT");
        a.setProfileImg("5xg");
        a.setEmail("uuuuxgu");
        //执行更新操作
        int row = personServices.update(a);
        //判断结果
        if(row==-1){
            return "更新失败";
        }else {
            return "更新成功";
        }
    }

    /**
     * 删除数据
     * */
    @RequestMapping("/delete")
    public String delete(){
        //初始化数据
        Long id =new Long(50);
        //执行删除
        int row = personServices.delete(id);
        //判断结果
        if(row==-1){
            return "删除失败";
        }else{
            return "删除成功";
        }
    }
}
