package com.lzk.service;

import com.lzk.model.Post;

import java.util.List;

/**
 * Created by lzk on 2018/2/17 19:16
 * Description:
 */
public interface PostService {
    public int addPostByPost(Post post);

    public Post findPostByPostId(int postId);

    public List<Post> listAllPost();

    public int deletePost(int postId);
}
