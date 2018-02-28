package com.lzk.service;

import com.lzk.model.Article;
import com.lzk.model.CreateTimeCount;
import com.lzk.model.Type;

import java.util.List;

/**
 * Created by lzk on 2018/2/11 17:21
 * Description:
 */
public interface ArticleService {

    /**
     * 分页，根据页码和每页显示数查询文章
     *
     * @param pageNo
     * @param size
     * @return
     */
    List<Article> queryArticles(int pageNo, int size);

    /**
     * 查询文章总数
     *
     * @return
     */
    int queryCount();

    /**
     * 根据类型查询文章总数
     *
     * @return
     */
    int queryCountByTypeId(Integer typeId);

    /**
     * 根据创建时间查询文章总数
     *
     * @return
     */
    int queryCountByCreateTime(String createTime);

    /**
     * 根据articleId查询文章
     *
     * @param articleId
     * @return
     */
    Article queryById(int articleId);

    /**
     * 查询热门文章
     *
     * @return
     */
    List<Article> queryHotArticles();

    /**
     * 查询近期文章
     *
     * @return
     */
    List<Article> queryNewArticles();

    /**
     * 根据文章类型查询对应的文章
     *
     * @param typeId
     * @param pageNo
     * @param size
     * @return
     */
    List<Article> queryArticlesByTypeId(int typeId, int pageNo, int size);

    /**
     * 根据文章创建时间查询对应的文章
     *
     * @param createTime
     * @param pageNo
     * @param size
     * @return
     */
    List<Article> queryArticlesByCreateTime(String createTime, int pageNo, int size);

    /**
     * 日期归档。查询所有日期年月
     * @return
     */
    List<CreateTimeCount> queryDates();
}
