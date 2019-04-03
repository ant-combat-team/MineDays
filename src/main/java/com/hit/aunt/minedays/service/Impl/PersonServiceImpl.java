package com.hit.aunt.minedays.service.Impl;
import com.hit.aunt.minedays.entity.Person;
import com.hit.aunt.minedays.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
@Service("personServices")
public class PersonServiceImpl implements PersonService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    //JDBC 写入数据
    @Override
    public int add(Person x) {
        //执行写入
        int row = jdbcTemplate.update("INSERT INTO tab_person VALUES (?,?,?,?,?,?,?,?,?)",  new PreparedStatementSetter(){
            //映射数据
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setLong(1, x.getUserId());
                ps.setString(2, x.getName());
                ps.setString(3,x.getProfileImg());
                ps.setString(4,x.getEmail());
                ps.setString(5,x.getGender());
                ps.setInt(6,x.getEnableStatus());
                ps.setInt(7,x.getUserType());
                ps.setDate(8,new Date(x.getCreateTime().getTime()));
                ps.setDate(9,new Date(x.getLastEditTime().getTime()));

            }
        });
        //返回结果
        return row;
    }
    //删除数据
    @Override
    public int delete(Long id) {
        //SQL+结果
        int resRow = jdbcTemplate.update("DELETE FROM tab_person WHERE userID=?", new PreparedStatementSetter() {
            //映射数据
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setLong(1, id);
            }
        });
        //返回结果
        return resRow;
    }

    //JDBC 更新数据
    @Override
    public int update(Person person) {
        //SQL
        String sql = "update tab_person set userName=?,profileImg=?,email=?,lastEditTime=? where userID=?";
        //结果
        int row = jdbcTemplate.update(sql, new PreparedStatementSetter() {
            //映射数据
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1, person.getName());
                preparedStatement.setString(2, person.getProfileImg());
                preparedStatement.setString(3, person.getEmail());
                Calendar cal= Calendar.getInstance();
                preparedStatement.setDate(4,new Date(cal.getTime().getTime()));
                preparedStatement.setLong(5, person.getUserId());
            }
        });
        //结果
        return row;
    }
    //JDBC 查询数据
    @Override
    public List<Person> emlquery(String emails)  {
        //SQL
        String sql = "SELECT *  FROM tab_person WHERE email='"+emails+"'";
        //结果
        List<Person> list = jdbcTemplate.query(sql, new RowMapper<Person>() {
            //映射每行数据
            @Override
            public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
                Person person =new Person();
                person.setUserId(rs.getLong("userID"));
                person.setName(rs.getString("userName"));
                person.setProfileImg(rs.getString("profileImg"));
                person.setEmail(rs.getString("email"));
                person.setGender(rs.getString("gender"));
                person.setEnableStatus(rs.getInt("enableStatus"));
                person.setUserType(rs.getInt("userType"));
                person.setCreateTime(rs.getDate("createTime"));
                person.setLastEditTime(rs.getDate("lastEditTime"));
                return person;
            }

        });
        //返回结果
        return list;
    }
    @Override
    public List<Person> idquery(Long id)  {
        //SQL
        String sql = "SELECT *  FROM tab_person WHERE userID="+id;
        //结果
        List<Person> list = jdbcTemplate.query(sql, new RowMapper<Person>() {
            //映射每行数据
            @Override
            public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
                Person person =new Person();
                person.setUserId(rs.getLong("userID"));
                person.setName(rs.getString("userName"));
                person.setProfileImg(rs.getString("profileImg"));
                person.setEmail(rs.getString("email"));
                person.setGender(rs.getString("gender"));
                person.setEnableStatus(rs.getInt("enableStatus"));
                person.setUserType(rs.getInt("userType"));
                person.setCreateTime(rs.getDate("createTime"));
                person.setLastEditTime(rs.getDate("lastEditTime"));
                return person;
            }

        });
        //返回结果
        return list;
    }
}
