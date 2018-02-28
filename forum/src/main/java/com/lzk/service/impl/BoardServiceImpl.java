package com.lzk.service.impl;

import com.lzk.mapper.BoardMapper;
import com.lzk.model.Board;
import com.lzk.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lzk on 2018/2/17 20:19
 * Description:
 */
@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    private BoardMapper boardMapper;

    @Override
    public int addBoardByBoard(Board board) {
        //todo 添加帖子不需要更新论坛版块中的帖子数目么？？？
        return boardMapper.addBoard(board);
    }

    @Override
    public int deleteBoardByBoardName(String boardName) {
        Board board = boardMapper.findBoardByBoardName(boardName);
        return boardMapper.deleteBoardById(board.getBoardId());
    }

    @Override
    public List<Board> listAllBoard() {
        return boardMapper.listAllBoard();
    }

    @Override
    public Board listAllPostOfBoard(int boardId) {
        return boardMapper.listAllPostsOfBoard(boardId);
    }

    @Override
    public Board queryBoardByBoardId(int boardId) {
        return boardMapper.findBoardByBoardId(boardId);
    }

    @Override
    public Board queryBoardByBoardName(String boardName) {
        return boardMapper.findBoardByBoardName(boardName);
    }

    @Override
    public int updatePostNum(int boardId) {
        Board board = boardMapper.findBoardByBoardId(boardId);
        board.setBoardPostNum(board.getBoardPostNum() + 1);
        return boardMapper.updateBoardByBoard(board);
    }

    @Override
    public int updateBoardInfo(Board board) {
        return boardMapper.updateBoardByBoard(board);
    }

    @Override
    public int deleteBoard(int boardId) {
        return boardMapper.deleteBoardById(boardId);
    }
}
