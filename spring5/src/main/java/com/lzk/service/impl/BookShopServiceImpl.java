package com.lzk.service.impl;

import com.lzk.dao.BookShopDao;
import com.lzk.service.BookShopService;

public class BookShopServiceImpl implements BookShopService {
    private BookShopDao bookShopDao;

    public void setBookShopDao(BookShopDao bookShopDao) {
        this.bookShopDao = bookShopDao;
    }

    public void purchase(String username, String isbn) {
        double price = bookShopDao.findBookPriceByIsbn(isbn);
        bookShopDao.updateBookStock(isbn);
        bookShopDao.updateUserAccount(username,price);
    }
}
