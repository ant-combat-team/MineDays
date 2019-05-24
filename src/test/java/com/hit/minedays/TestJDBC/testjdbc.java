package com.hit.minedays.TestJDBC;
import com.hit.minedays.entity.Person;

public class testjdbc {

    //public static final String URL = "jdbc:mysql://localhost:3306/mydays";
    //public static final String USER = "root";
    //public static final String PASSWORD = "123456";

    public static void main(String[] args) throws Exception {
        //2. 获得数据库连接
        //Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        //3.操作数据库，实现增删改查
        //Statement stmt = conn.createStatement();
        //ResultSet rs = stmt.executeQuery("SELECT userName FROM tab_person");
        //如果有数据，rs.next()返回true
        //while(rs.next()){
        // System.out.println(" 姓名："+rs.getString("userName"));
        //}
        Person a=new Person();
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