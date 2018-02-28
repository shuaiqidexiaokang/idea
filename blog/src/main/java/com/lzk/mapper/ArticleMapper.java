package com.lzk.mapper;

import com.lzk.model.Article;
import com.lzk.model.CreateTimeCount;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by lzk on 2018/2/11 14:40
 * Description:
 */
public interface ArticleMapper {

    /**
     * 根据id查询文章
     * @param articleId id
     * @return
     */
    public Article queryById(int articleId);


    /**
     * 根据偏移量查询文章，文章创建时间进行降序排序--热度文章
     * @param offset
     * @param limit
     * @return
     */
    //public List<Article> queryAllSortByTime(@Param("offset") int offset, @Param("limit") int limit);
    public List<Article> queryAllSortByTime(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 根据偏移量查询文章，文章阅读数进行降序排序--热度文章
     * @param offset
     * @param limit
     * @return
     */
    public List<Article> queryAllSortByReadNumber(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 根据偏移量、类型或文章日期查询文章，文章创建时间进行降序排序--分类目录
     * @param typeId 文章类别
     * @param createTime 文章创建时间 2018年02
     * @param offset 偏移位置
     * @param limit  查询数量
     * @return 查询的文章
     */
    public List<Article> queryAllByTypeIdOrCreateTimeSortByTime(@Param("typeId") Integer typeId,@Param("createTime") String createTime, @Param("offset") int offset, @Param("limit") int limit);

    /**
     * 根据条件查询总数量
     * @return
     */
    public int queryCountByTypeIdOrCreate(@Param("typeId") Integer typeId,@Param("createTime") String createTime);

    /**
     * 日期归档，查询所有日期月份 和数量
     * @return
     */
    public List<CreateTimeCount> queryDate();

    /**
     * 添加文章
     *
     * @param article
     * @return 添加的记录数 1：成功 0：失败
     */
    public int addArticle(Article article);

    /**
     * 根据文章编号修改文章
     *
     * @param article
     * @return 修改的记录数 1：成功 0：失败
     */
    public int updateArticle(Article article);

    /**
     * 根据编号删除文章
     *
     * @param articleId
     * @return 删除的记录数 1：成功 0：失败
     */
    public int deleteArticle(Integer articleId);
}
