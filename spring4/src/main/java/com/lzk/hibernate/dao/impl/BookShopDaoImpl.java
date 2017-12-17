package com.lzk.hibernate.dao.impl;

import com.lzk.hibernate.dao.BookShopDao;
import com.lzk.hibernate.exception.BookStockException;
import com.lzk.hibernate.exception.UserAccountException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("bookShopDao")
public class BookShopDaoImpl implements BookShopDao {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    public Integer findBookPriceByIsbn(String isbn) {
        String hql = "SELECT b.price from Book b where b.isbn = ? ";
        Query query = getSession().createQuery(hql).setString(0,isbn);
        return (Integer)query.uniqueResult();
    }


    public void updateBookStock(String isbn) {
        String hql1 = "SELECT b.stock from Book b where b.isbn = ?";
        Integer stock =  (Integer) getSession().createQuery(hql1).setString(0,isbn).uniqueResult();
        if (stock == 0 ){
            throw new BookStockException("库存不足！");
        }
        String hql = "update Book b set b.stock = b.stock - 1 where b.isbn = ? ";
        getSession().createQuery(hql).setString(0,isbn).executeUpdate();
    }

    public void updateUserAccount(String username, Integer price) {
        String hql1 = "SELECT a.balance from Accoount a where a.username = ?";
        Integer balance =  (Integer) getSession().createQuery(hql1).setString(0,username).uniqueResult();
        if (balance < price ){
            throw new UserAccountException("余额不足！");
        }
        String hql = "update Accoount a set a.balance = a.balance - ? where a.username = ? ";
        getSession().createQuery(hql).setInteger(0,price).setString(1,username).executeUpdate();
    }
}
