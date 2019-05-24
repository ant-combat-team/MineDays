package com.hit.minedays.service.Impl;
import com.hit.minedays.entity.Account;
import com.hit.minedays.service.AccountService;
import com.hit.minedays.service.PersonService;
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
@Service("accountServices")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private JdbcTemplate  jdbcTemplate;
    private PersonService personServices;
    //JDBC 写入数据
    @Override
    public int add(Account x) {
        //执行写入
        int row = jdbcTemplate.update("INSERT INTO tab_account(email, password, createtime, lastedittime) VALUES (?,?,?,?)",  new PreparedStatementSetter(){
            //映射数据
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                //ps.setLong(1, x.getUserID());
                ps.setString(1, x.getEmail());
                ps.setString(2,x.getPassword());
                ps.setDate(3,new Date(x.getCreateTime().getTime()));
                ps.setDate(4,new Date(x.getLastEditTime().getTime()));
            }
        });
        //返回结果
        return row;
    }
    //删除数据
    @Override
    public int delete(Long id) {
        //SQL+结果
        int resRow = jdbcTemplate.update("DELETE FROM tab_account WHERE userID=?", new PreparedStatementSetter() {
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
    public List<Account> emlquery(String emails)  {
        //SQL
        String sql = "SELECT *  FROM tab_account WHERE email='"+emails+"'";
        //结果
        List<Account> list = jdbcTemplate.query(sql, new RowMapper<Account>() {
            //映射每行数据
            @Override
            public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
                Account account =new Account();
                account.setAccountID(rs.getLong("accountID"));
                account.setEmail(rs.getString("email"));
                account.setPassword(rs.getString("password"));
                account.setCreateTime(rs.getDate("createTime"));
                account.setLastEditTime(rs.getDate("lastEditTime"));
                account.setUserID(rs.getLong("userID"));
                return account;
            }

        });
        //返回结果
        return list;
    }
    @Override
    public List<Account> idquery(Long id)  {
        //SQL
        String sql = "SELECT *  FROM tab_account WHERE userID="+id;
        //结果
        List<Account> list = jdbcTemplate.query(sql, new RowMapper<Account>() {
            //映射每行数据
            @Override
            public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
                Account account =new Account();
                account.setAccountID(rs.getLong("accountID"));
                account.setEmail(rs.getString("email"));
                account.setPassword(rs.getString("password"));
                account.setCreateTime(rs.getDate("createTime"));
                account.setLastEditTime(rs.getDate("lastEditTime"));
                account.setUserID(rs.getLong("userID"));
                return account;
            }
        });
        //返回结果
        return list;
    }
    //JDBC 更新数据
    @Override
    public int update(Account account) {
        //SQL
        String sql = "update tab_account set email=?,password=?,lastEditTime=? where accountID=?";
        //结果
        int row = jdbcTemplate.update(sql, new PreparedStatementSetter() {
            //映射数据
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1, account.getEmail());
                preparedStatement.setString(2, account.getPassword());
                Calendar cal= Calendar.getInstance();
                preparedStatement.setDate(3,new Date(cal.getTime().getTime()));
                preparedStatement.setLong(4,account.getAccountID());
            }
        });
        //结果
        return row;
    }
}
