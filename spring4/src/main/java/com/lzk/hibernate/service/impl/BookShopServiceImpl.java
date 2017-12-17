package com.lzk.hibernate.service.impl;

import com.lzk.hibernate.dao.BookShopDao;
import com.lzk.hibernate.service.BookShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {
    @Autowired
    private BookShopDao bookShopDao;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void purchase(String username, String isbn) {
        Integer price =  bookShopDao.findBookPriceByIsbn(isbn);
        bookShopDao.updateUserAccount(username,price);
        bookShopDao.updateBookStock(isbn);

    }
}
