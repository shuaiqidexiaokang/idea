package com.lzk.service.impl;

import com.lzk.mapper.PostMapper;
import com.lzk.mapper.ReplyMapper;
import com.lzk.model.Post;
import com.lzk.model.Reply;
import com.lzk.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by lzk on 2018/2/17 19:49
 * Description:
 */
@Service
public class ReplyServiceImpl implements ReplyService {
    @Autowired
    private ReplyMapper replyMapper;

    @Autowired
    private PostMapper postMapper;

    @Transactional
    @Override
    public int addReply(Reply reply) {
        // 更新post信息
        int postId = reply.getReplyPostId();
        Post post = postMapper.findPostByPostId(postId);
        post.setPostReplyCount(post.getPostReplyCount() + 1);
        postMapper.updatePostByPost(post);

        // 添加回复
        reply.setReplyCreateTime(new Timestamp(new Date().getTime()));
        return replyMapper.addReply(reply);
    }

    @Override
    public List<Reply> listReplyByPostId(int postId) {
        return replyMapper.listReplyByPostId(postId);
    }

    @Override
    public int deleteReply(int replyId) {
        // 更新post信息
        Reply reply = replyMapper.findReplyByReplyId(replyId);
        int postId = reply.getReplyPostId();
        Post post = postMapper.findPostByPostId(postId);
        post.setPostReplyCount(post.getPostReplyCount() - 1);
        postMapper.updatePostByPost(post);

        // 删除回复
        reply.setReplyCreateTime(new Timestamp(new Date().getTime()));
        return replyMapper.deleteReplyById(replyId);
    }
}
