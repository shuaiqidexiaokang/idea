package com.lzk.mapper;

import com.lzk.model.Post;
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
public class PostMapperTest {
    @Autowired
    private PostMapper postMapper;
    @Test
    public void addPost() throws Exception {
        Post post = new Post(1,"aa","帖子标题","帖子内容",new Timestamp(new Date().getTime()),new Timestamp(new Date().getTime()));
        postMapper.addPost(post);
    }

    @Test
    public void findPostByPostId() throws Exception {
        Post post = postMapper.findPostByPostId(2);
        System.out.println(post);
    }

    @Test
    public void listAllPostInfo() throws Exception {
        List<Post> posts =  postMapper.listAllPostInfo();
        posts.forEach(System.out::println);
    }

    @Test
    public void deletePostById() throws Exception {
        postMapper.deletePostById(3);
    }

    @Test
    public void updatePostByPost() throws Exception {
        Post post = new Post(1,20);
        postMapper.updatePostByPost(post);
    }

}