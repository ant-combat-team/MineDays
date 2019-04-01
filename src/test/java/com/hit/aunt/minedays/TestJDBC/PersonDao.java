package com.hit.aunt.minedays.TestJDBC;
import com.hit.aunt.minedays.entity.Person;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

public class PersonDao {
    //增加
    public void addPerson(Person g) throws SQLException {
        //获取连接
        Connection conn = DbUtil.getConnection();
        //sql
        String sql = "INSERT INTO tab_person(userID,userName,profileImg,email,gender,enableStatus,userType,createTime,lastEditTime)\n" +
                "                       VALUES\n" +
                "                       (?,?,?,?,?,?,?,CURRENT_DATE(),CURRENT_DATE());";
        //预编译
        PreparedStatement ptmt = conn.prepareStatement(sql); //预编译SQL，减少sql执行

        //传参
        ptmt.setLong(1, g.getUserId());
        ptmt.setString(2, g.getName());
        ptmt.setString(3, g.getProfileImg());
        ptmt.setString(4, g.getEmail());
        ptmt.setString(5, g.getGender());
        ptmt.setInt(6, g.getEnableStatus());
        ptmt.setInt(7, g.getUserType());
        //ptmt.setDate(8, new Date(g.getCreateTime().getTime()));
        //ptmt.setDate(9, new Date(g.getLastEditTime().getTime()));
        //执行
        ptmt.execute();
    }
//    //修改
//    public void updateGoddess(){
//        //获取连接
//        Connection conn = DbUtil.getConnection();
//        //sql, 每行加空格
//        String sql = "UPDATE imooc_goddess" +
//                " set user_name=?, sex=?, age=?, birthday=?, email=?, mobile=?,"+
//                " update_user=?, update_date=CURRENT_DATE(), isdel=? "+
//                " where id=?";
//        //预编译
//        PreparedStatement ptmt = conn.prepareStatement(sql); //预编译SQL，减少sql执行
//
//        //传参
//        ptmt.setString(1, g.getUser_name());
//        ptmt.setInt(2, g.getSex());
//        ptmt.setInt(3, g.getAge());
//        ptmt.setDate(4, new Date(g.getBirthday().getTime()));
//        ptmt.setString(5, g.getEmail());
//        ptmt.setString(6, g.getMobile());
//        ptmt.setString(7, g.getUpdate_user());
//        ptmt.setInt(8, g.getIsDel());
//        ptmt.setInt(9, g.getId());
//
//        //执行
//        ptmt.execute();
//    }
//    //删除
//    public void delGoddess(){
//        //获取连接
//        Connection conn = DbUtil.getConnection();
//        //sql, 每行加空格
//        String sql = "delete from imooc_goddess where id=?";
//        //预编译SQL，减少sql执行
//        PreparedStatement ptmt = conn.prepareStatement(sql);
//
//        //传参
//        ptmt.setInt(1, id);
//
//        //执行
//        ptmt.execute();
//    }
//
//    public List<Person> query() throws SQLException {
//        Connection conn = DbUtil.getConnection();
//        Statement stmt = conn.createStatement();
//        ResultSet rs = stmt.executeQuery("SELECT user_name, age FROM imooc_goddess");
//
//        List<Person> gs = new ArrayList<Person>();
//        Person g = null;
//        while(rs.next()){
//            g = new Person();
//            g.setUser_name(rs.getString("user_name"));
//            g.setAge(rs.getInt("age"));
//
//            gs.add(g);
//        }
//        return gs;
//    }
//    //查
//    public Person get(){
//        Person g = null;
//        //获取连接
//        Connection conn = DbUtil.getConnection();
//        //sql, 每行加空格
//        String sql = "select * from  imooc_goddess where id=?";
//        //预编译SQL，减少sql执行
//        PreparedStatement ptmt = conn.prepareStatement(sql);
//        //传参
//        ptmt.setInt(1, id);
//        //执行
//        ResultSet rs = ptmt.executeQuery();
//        while(rs.next()){
//            g = new Person();
//            g.setId(rs.getInt("id"));
//            g.setUser_name(rs.getString("user_name"));
//            g.setAge(rs.getInt("age"));
//            g.setSex(rs.getInt("sex"));
//            g.setBirthday(rs.getDate("birthday"));
//            g.setEmail(rs.getString("email"));
//            g.setMobile(rs.getString("mobile"));
//            g.setCreate_date(rs.getDate("create_date"));
//            g.setCreate_user(rs.getString("create_user"));
//            g.setUpdate_date(rs.getDate("update_date"));
//            g.setUpdate_user(rs.getString("update_user"));
//            g.setIsDel(rs.getInt("isdel"));
//        }
//        return g;
//    }
}
