package com.lzk.hibernate.service.impl;

import com.lzk.hibernate.service.BookShopService;
import com.lzk.hibernate.service.CashierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("cashier")
public class CashierServiceImpl implements CashierService {

    @Autowired
    private BookShopService bookShopService;

    public void checkout(String username, List<String> isbns) {
        for (String isbn:isbns){
            bookShopService.purchase(username,isbn);
        }
    }
}
