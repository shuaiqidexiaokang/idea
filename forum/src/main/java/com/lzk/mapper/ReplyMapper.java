package com.lzk.mapper;

import com.lzk.model.Reply;

import java.util.List;

public interface ReplyMapper {
    /**
     * 添加回复（帖子id，回复者用户名，回复内容，回复时间）
     * @param reply
     */
    public int addReply(Reply reply);

    /**
     * 查询所有回复
     * @return
     */
    public List<Reply> listAllReply();

    /**
     * 根据帖子id查询所有回复
     * @param postId
     * @return
     */
    public List<Reply> listReplyByPostId(int postId);

    /**
     * 根据回复id删除回复
     * @param postId
     */
    public int deleteReplyById(int postId);

    /**
     * 根据回复id查询回复信息
     * @param replyId
     * @return
     */
    public Reply findReplyByReplyId(int replyId);
}
