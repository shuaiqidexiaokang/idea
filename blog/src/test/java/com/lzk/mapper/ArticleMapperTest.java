package com.lzk.mapper;

import com.lzk.model.Article;
import com.lzk.model.CreateTimeCount;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-mapper.xml")
public class ArticleMapperTest {
 @Autowired
    private ArticleMapper articleMapper;

    @Test
    public void queryById() throws Exception {
        Article article = articleMapper.queryById(1003);
        System.out.println(article);
    }

    @Test
    public void queryAllSortByTime() throws Exception {
        List<Article> articles = articleMapper.queryAllSortByTime(0,5);
        articles.forEach(System.out::print);
    }

    @Test
    public void queryAllSortByReadNumber() throws Exception {
        List<Article> articles = articleMapper.queryAllSortByReadNumber(0,5);
        articles.forEach(System.out::println);
    }

    @Test
    public void queryAllByTypeIdOrCreateTimeSortByTime() throws Exception {
        List<Article> articles = articleMapper.queryAllByTypeIdOrCreateTimeSortByTime(null,"2018年02月",0,5);
        articles.forEach(System.out::println);
    }

    @Test
    public void queryCountByTypeIdOrCreate() throws Exception {
        int count = articleMapper.queryCountByTypeIdOrCreate(null,null);
        System.out.println(count);
    }

    @Test
    public void queryDate() throws Exception {
        List<CreateTimeCount> dates = articleMapper.queryDate();
        dates.forEach(System.out::println);
    }

    @Test
    public void addArticle() throws Exception {
        Article article = new Article("添加测试标题",2,"添加测试关键字","添加测试概要","添加测试内容");
        int result = articleMapper.addArticle(article);
        System.out.println(result);
    }

    @Test
    public void updateArticle() throws Exception {
        Article article = new Article(1014,"更新测试标题",3,"更新测试关键字","更新测试概要","更新测试内容");
        int result = articleMapper.updateArticle(article);
        System.out.println(result);
    }

    @Test
    public void deleteArticle() throws Exception {
        int result = articleMapper.deleteArticle(1014);
        System.out.println(result);
    }
}
