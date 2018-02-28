package com.lzk.mapper;

import com.lzk.model.Post;

import java.util.List;

public interface PostMapper {

    /**
     * 添加帖子信息（帖子版块id，发帖者用户名，帖子标题，帖子内容，帖子创建时间，帖子更新时间）
     *
     * @param post
     */
    public int addPost(Post post);

    /**
     * 根据帖子id查询帖子信息
     *
     * @param postId
     * @return
     */
    public Post findPostByPostId(int postId);

    /**
     * 查询所有帖子信息
     *
     * @return
     */
    public List<Post> listAllPostInfo();

    /**
     * 根据帖子id删除帖子
     *
     * @param postId
     */
    public int deletePostById(int postId);

    /**
     * 修改帖子（其实就只能修改回帖数）
     *
     * @param post
     */
    public int updatePostByPost(Post post);
}
