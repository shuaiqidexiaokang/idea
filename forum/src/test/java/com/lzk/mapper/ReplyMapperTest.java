package com.lzk.mapper;

import com.lzk.model.Reply;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/*.xml")
public class ReplyMapperTest {

    @Autowired
    private ReplyMapper replyMapper;
    @Test
    public void addReply() throws Exception {
        Reply reply = new Reply(1,"aa","测试",new Timestamp(new Date().getTime()));
        replyMapper.addReply(reply);
    }

    @Test
    public void listAllReply() throws Exception {
        List<Reply> replies = replyMapper.listAllReply();
        replies.forEach(System.out::println);
    }

    @Test
    public void listReplyByPostId() throws Exception {
        List<Reply> replies = replyMapper.listReplyByPostId(1);
        replies.forEach(System.out::println);
    }

    @Test
    public void deleteReplyById() throws Exception {
        replyMapper.deleteReplyById(2);
    }

    @Test
    public void findReplyByReplyId() throws Exception {
        Reply reply = replyMapper.findReplyByReplyId(3);
        System.out.println(reply);
    }

}