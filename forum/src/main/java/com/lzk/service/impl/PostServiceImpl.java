package com.lzk.service.impl;

import com.lzk.mapper.BoardMapper;
import com.lzk.mapper.PostMapper;
import com.lzk.model.Board;
import com.lzk.model.Post;
import com.lzk.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lzk on 2018/2/17 19:35
 * Description:
 */
@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostMapper postMapper;

    @Autowired
    private BoardMapper boardMapper;

    @Override
    public int addPostByPost(Post post) {
        if (post != null) {
            return postMapper.addPost(post);
        }
        return 0;
    }

    @Override
    public Post findPostByPostId(int postId) {
        return postMapper.findPostByPostId(postId);
    }

    @Override
    public List<Post> listAllPost() {
        return postMapper.listAllPostInfo();
    }

    @Override
    @Transactional
    public int deletePost(int postId) {
        int boardId = postMapper.findPostByPostId(postId).getPostBoardId();
        Board board = boardMapper.findBoardByBoardId(boardId);
        board.setBoardPostNum(board.getBoardPostNum() - 1);
        boardMapper.updateBoardByBoard(board);
        return postMapper.deletePostById(postId);
    }
}
