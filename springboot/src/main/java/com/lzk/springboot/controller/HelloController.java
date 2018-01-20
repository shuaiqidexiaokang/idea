package com.lzk.springboot.controller;

import com.lzk.springboot.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * Created by lzk on 2018/1/19 16:27
 * Description:
 */
@RestController//==@Controller + @ResponseBody
public class HelloController {
    //通过配置文件设置属性
    @Value(value = "${book.author}")
    private String bookAuthor;
    @Value("${book.name}")
    private String bookName;
    @Value("${book.pinyin}")
    private String bookPinYin;
    @Value("${book.context}")
    private String context;
    @Autowired
    private Book book;

    @RequestMapping(value = "/",produces = "text/plain;charset=UTF-8",method = RequestMethod.GET)
    String index(){
        return "Hello Spring Boot! The BookName is "+bookName+";and Book Author is "+bookAuthor+";and Book PinYin is "+bookPinYin + context;
    }

    @GetMapping(value = {"/hello","hi"})//配置多个映射
    public String hello() {
        return "hello,Spring boot!";
    }

    @GetMapping("/getBookInfo")
    public Book getBookInfo(){
        return book;
    }

    //带参数
    @GetMapping("/testPathVariable/{id}")
    public String testPathVariable(@PathVariable String id) {
        return "testPathVariable:" + id;
    }

    @GetMapping("/testRequestParam")
    public String testRequestParam(@RequestParam String id) {
        return "testRequestParam:" + id;
    }

}
