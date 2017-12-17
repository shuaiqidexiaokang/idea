package com.lzk.dao.impl;

import com.lzk.dao.BookShopDao;
import com.lzk.exception.BookStockException;
import com.lzk.exception.UserAccountException;
import org.springframework.jdbc.core.JdbcTemplate;

public class BookShopDaoImpl implements BookShopDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public double findBookPriceByIsbn(String isbn) {
        String sql = "select price from book where isbn = ?";
        return jdbcTemplate.queryForObject(sql,Double.class,isbn);
    }

    public void updateBookStock(String isbn) {
        String sql = "select stock from book_stock where isbn = ?";
        int stock = jdbcTemplate.queryForObject(sql,Integer.class,isbn);
        if (stock == 0){
            throw new BookStockException("库存不足!");
        }
        sql = "update book_stock set stock = stock - 1 where isbn = ?";
        jdbcTemplate.update(sql,isbn);
    }

    public void updateUserAccount(String username, double price) {
        String sql = "select balance from account where username = ?";
        double balance = jdbcTemplate.queryForObject(sql,Double.class,username);
        if (balance < price){
            throw new UserAccountException("余额不足!");
        }
        sql = "update account set balance = balance - ? where username = ?";
        jdbcTemplate.update(sql,price,username);
    }
}
