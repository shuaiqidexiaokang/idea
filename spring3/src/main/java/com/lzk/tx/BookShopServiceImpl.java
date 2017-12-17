package com.lzk.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;

@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {

    @Autowired
    private BookShopDao bookShopDao;

    //添加事务注解
    //1、使用propagation 指定事务的传播行为，即当前的事务方法被另一个事物方法调用时
    //如何使用事务，默认值为Propagation.REQUIRED：表示使用调用方法的事务
    //Propagation.REQUIRES_NEW:表示事务自己的事务，调用的事务方法的事务被挂起
    //2、使用isolation指定事务的隔离级别，最常用的值为READ_COMMITTED
    //3、默认情况下Spring的声明事务对所有运行时异常进行回滚。也可以通过对应的属性进行设置。通常情况下取默认值即可
    //使用noRollbackFor = {UserAccountException.class}设置运行时异常UserAccountException执行不回滚
    //4、使用readOnly指定事务是否为只读，表示这个事务只读取数据，不更新数据
    //这样可以帮助数据库引擎优化事务，若真的是一个只读取数据库值得方法，应设置为readOnly = true
    //5、使用timeout指定强制回滚之前事务可以占用的时间
    @Transactional(propagation = Propagation.REQUIRES_NEW,
            isolation = Isolation.READ_COMMITTED,
            readOnly = false,timeout = 3)
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
