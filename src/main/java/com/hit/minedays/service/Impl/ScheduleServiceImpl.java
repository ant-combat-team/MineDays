package com.hit.minedays.service.Impl;
import com.hit.minedays.entity.Person;
import com.hit.minedays.entity.Schedule;
import com.hit.minedays.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private JdbcTemplate  jdbcTemplate;
    private ScheduleService scheduleServices;
    //JDBC 写入数据
    @Override
    public int add(Schedule x) {
        //执行写入
        int row = jdbcTemplate.update("INSERT INTO tab_shcedule VALUES (?,?,?,?,?,?,?,?,?)",  new PreparedStatementSetter(){
            //映射数据
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1,x.getTitle());
                ps.setString(2,x.getTaskDesc());
                ps.setString(3,x.getStartTime());
                ps.setString(4,x.getEndTime());
                ps.setDate(5,new Date(x.getCreateTime().getTime()));
                ps.setDate(6,new Date(x.getLastEditTime().getTime()));
                ps.setLong(7,x.getUserID());
                ps.setInt(8, x.getPerorities());
                ps.setInt(9,x.getEnableStatus());
            }
        });
        //返回结果
        return row;
    }
    //删除数据
    @Override
    public int delete(Long id) {
        //SQL+结果
        int resRow = jdbcTemplate.update("DELETE FROM tab_schedule WHERE userID=?", new PreparedStatementSetter() {
            //映射数据
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setLong(1, id);
            }
        });
        //返回结果
        return resRow;
    }

    //JDBC 查询数据

    @Override
    //根据用户查询
    public List<Schedule> perquery(Person p)  {
        //SQL
        String sql = "SELECT *  FROM tab_schedule WHERE u="+p.getUserId();
        //结果
        List<Schedule> list = jdbcTemplate.query(sql, new RowMapper<Schedule>() {
            //映射每行数据
            @Override
            public Schedule mapRow(ResultSet rs, int rowNum) throws SQLException {
                Schedule schedule=new Schedule();
                schedule.setTaskID(rs.getLong("taskID"));
                schedule.setTitle(rs.getString("title"));
                schedule.setTaskDesc(rs.getString("taskDesc"));
                schedule.setStartTime(rs.getString("startTime"));
                schedule.setEndTime(rs.getString("endTime"));
                schedule.setCreateTime(rs.getDate("createTime"));
                schedule.setLastEditTime(rs.getDate("lastEditTime"));
                schedule.setUserID(rs.getLong("userID"));
                schedule.setPerorities(rs.getInt("perorities"));
                schedule.setEnableStatus(rs.getInt("enableStatus"));
                return schedule;
            }
        });
        //返回结果
        return list;
    }
    @Override
    //根据ID查询
    public List<Schedule> idquery(Long id) {
        //SQL
        String sql = "SELECT *  FROM tab_schedule WHERE userID="+id;
        //结果
        List<Schedule> list = jdbcTemplate.query(sql, new RowMapper<Schedule>() {
            //映射每行数据
            @Override
            public Schedule mapRow(ResultSet rs, int rowNum) throws SQLException {
                Schedule schedule=new Schedule();
                schedule.setTaskID(rs.getLong("taskID"));
                schedule.setTitle(rs.getString("title"));
                schedule.setTaskDesc(rs.getString("taskDesc"));
                schedule.setStartTime(rs.getString("startTime"));
                schedule.setEndTime(rs.getString("endTime"));
                schedule.setCreateTime(rs.getDate("createTime"));
                schedule.setLastEditTime(rs.getDate("lastEditTime"));
                schedule.setUserID(rs.getLong("userID"));
                schedule.setPerorities(rs.getInt("perorities"));
                schedule.setEnableStatus(rs.getInt("enableStatus"));
                return schedule;
            }
        });
        //返回结果
        return list;
    }
    //JDBC 更新数据
    @Override
    public int update(Schedule x) {
        //SQL
        String sql = "update tab_schedule set title=?,taskDesc=?,startTime=?,endTime=?,lastEditTime=?,enableStatus=? where taskID=?";
        //结果
        int row = jdbcTemplate.update(sql, new PreparedStatementSetter() {
            //映射数据
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1,x.getTitle());
                preparedStatement.setString(2, x.getTaskDesc());
                preparedStatement.setString(3,x.getStartTime());
                preparedStatement.setString(4, x.getEndTime());
                Calendar cal= Calendar.getInstance();
                preparedStatement.setDate(5,new Date(cal.getTime().getTime()));
                preparedStatement.setInt(6,x.getEnableStatus());
                preparedStatement.setLong(7,x.getTaskID());
            }
        });
        //结果
        return row;
    }
}
