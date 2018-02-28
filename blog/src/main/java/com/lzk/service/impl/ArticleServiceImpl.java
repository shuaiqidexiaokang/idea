package com.lzk.service.impl;

import com.lzk.mapper.ArticleMapper;
import com.lzk.model.Article;
import com.lzk.model.CreateTimeCount;
import com.lzk.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/*
 *
 * Created by lzk on 2018/2/11 17:36
 * Description:
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public List<Article> queryArticles(int pageNo,int size) {
        return articleMapper.queryAllSortByTime(pageNo,size);
    }

    @Override
    public int queryCount(){
        return articleMapper.queryCountByTypeIdOrCreate(null,null);
    }

    @Override
    public int queryCountByTypeId(Integer typeId) {
        return articleMapper.queryCountByTypeIdOrCreate(typeId,null);
    }

    @Override
    public int queryCountByCreateTime(String createTime) {
        return articleMapper.queryCountByTypeIdOrCreate(null,createTime);
    }

    @Override
    public Article queryById(int articleId) {
        return articleMapper.queryById(articleId);
    }

    @Override
    public List<Article> queryHotArticles() {
        return articleMapper.queryAllSortByReadNumber(0,5);
    }

    @Override
    public List<Article> queryNewArticles() {
        return articleMapper.queryAllSortByTime(0,5);
    }

    @Override
    public List<Article> queryArticlesByTypeId(int typeId, int pageNo, int size) {
        return articleMapper.queryAllByTypeIdOrCreateTimeSortByTime(typeId, null,pageNo, size);
    }

    @Override
    public List<Article> queryArticlesByCreateTime(String createTime, int pageNo, int size) {
        return articleMapper.queryAllByTypeIdOrCreateTimeSortByTime(null, createTime,pageNo, size);
    }

    @Override
    public List<CreateTimeCount> queryDates() {
        //return articleMapper.queryDate();
        return articleMapper.queryDate();
    }
}
