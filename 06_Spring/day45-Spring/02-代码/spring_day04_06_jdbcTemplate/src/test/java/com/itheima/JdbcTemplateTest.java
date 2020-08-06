package com.itheima;

import com.itheima.config.SpringConfig;
import com.itheima.pojo.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 测试类
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class JdbcTemplateTest {

    //依赖注入
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //增
    @Test
    public void save() {
        Account account = new Account();
        account.setName("校花");
        account.setMoney(6666d);

        String sql = "insert into account values(?,?,?)";
        Object[] params = {account.getId(), account.getName(), account.getMoney()};

        jdbcTemplate.update(sql, params);
    }

    //删
    @Test
    public void deleteById() {
        String sql = "delete from account where id=?";

        jdbcTemplate.update(sql, 6);
    }

    //改
    @Test
    public void update() {
        Account account = new Account();
        account.setId(7);
        account.setName("校花");
        account.setMoney(66d);

        String sql = "update account set name=?, money=? where id=?";
        Object[] params = {account.getName(), account.getMoney(), account.getId()};

        jdbcTemplate.update(sql, params);
    }

    //根据id查询
    @Test
    public void findById() {
        String sql = "select * from account where id=?";

        Account account = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Account.class), 7);
        System.out.println("account = " + account);
    }

    //查询所有记录的条数
    @Test
    public void findByTotalCount() {
        String sql = "select count(1) from account";

        Integer count = jdbcTemplate.queryForObject(sql, int.class);
        System.out.println("count = " + count);
    }

    //查询所有
    @Test
    public void findAll() {
        String sql = "select * from account";

        List<Account> accountList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Account.class));
        for (Account account : accountList) {
            System.out.println("account = " + account);
        }
    }

    //查询所有 ( sql语句的字段 与 pojo中的属性名 不一致的情况 如何赋值 )
    @Test
    public void findAll2() {
        String sql = "select id ids, name names, money moneys from account";

        List<Account> accountList = jdbcTemplate.query(sql, new RowMapper<Account>() {
            @Override
            public Account mapRow(ResultSet resultSet, int index) throws SQLException {
                Account account = new Account();
                //为当前的account对象赋值
                account.setId( resultSet.getInt("ids") );
                account.setName( resultSet.getString("names") );
                account.setMoney( resultSet.getDouble("moneys") );
                return account;
            }
        });

        for (Account account : accountList) {
            System.out.println("account = " + account);
        }
    }
}