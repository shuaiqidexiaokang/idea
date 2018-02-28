package com.lzk.mapper;

import com.lzk.model.Comment;

import java.util.List;

/**
 * Created by lzk on 2018/2/11 14:40
 * Description:
 */
//todo
public interface CommentMapper {
    /**
     * 根据文章编号 ，评论者姓名，评论者邮箱，内容进行评论
     * @param articleId 文章编号
     * @param name 评论者姓名
     * @param email 评论者邮箱
     * @param context 内容
     * @return 插入结果 1：成功 0：失败
     */
    int addComment(int articleId,String name,String email,String context);

    /*根据文章编号、评论时间进行降序排序查询评论
根据文章编号、评论热度进行降序排序查询评论*/
}
