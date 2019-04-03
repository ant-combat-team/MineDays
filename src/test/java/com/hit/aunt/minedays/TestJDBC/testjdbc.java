package com.hit.aunt.minedays.TestJDBC;
import com.hit.aunt.minedays.entity.Person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class testjdbc {

    //public static final String URL = "jdbc:mysql://localhost:3306/mydays";
    //public static final String USER = "root";
    //public static final String PASSWORD = "123456";

    public static void main(String[] args) throws Exception {
        //获得数据库连接
        //Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        //操作数据库，实现增删改查
        //Statement stmt = conn.createStatement();
        //ResultSet rs = stmt.executeQuery("SELECT userName FROM tab_person");
        //如果有数据，rs.next()返回true
        //while(rs.next()){
        // System.out.println(" 姓名："+rs.getString("userName"));
        //}
        Person a=new Person();
        Long x=new Long(20);
        a.setUserId(x);
        a.setName("Wu");
        a.setProfileImg("4");
        a.setEmail("rrrrr");
        a.setGender("n");
        a.setEnableStatus(1);
        a.setUserType(2);
        PersonDao pd=new PersonDao();
        pd.addPerson(a);
    }
}