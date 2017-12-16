package com.lzk.xml.service.impl;

import com.lzk.xml.BookShopDao;
import com.lzk.xml.service.BookShopService;

public class BookShopServiceImpl implements BookShopService {

    private BookShopDao bookShopDao;

    public void setBookShopDao(BookShopDao bookShopDao) {
        this.bookShopDao = bookShopDao;
    }

    @Override
    public void purchase(String username, String isbn) {
        //1.获取书的单价
        double price = bookShopDao.findBookPriceByIsbn(isbn);

        //2.更新书的库存
        bookShopDao.updateBookStock(isbn);

        //3.更新用户的余额
        bookShopDao.updateUserAccount(username,price);
    }
}
