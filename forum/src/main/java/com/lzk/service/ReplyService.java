package com.lzk.service;

import com.lzk.model.Reply;

import java.util.List;

/**
 * Created by lzk on 2018/2/17 19:49
 * Description:
 */
public interface ReplyService {
    public int addReply(Reply reply);

    public List<Reply> listReplyByPostId(int postId);

    public int deleteReply(int replyId);
}
