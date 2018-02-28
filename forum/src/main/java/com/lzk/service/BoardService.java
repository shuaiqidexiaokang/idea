package com.lzk.service;

import com.lzk.model.Board;

import java.util.List;

/**
 * Created by lzk on 2018/2/17 19:15
 * Description:
 */
public interface BoardService {
    public int addBoardByBoard(Board board);

    public int deleteBoardByBoardName(String boardName);

    public List<Board> listAllBoard();

    public Board listAllPostOfBoard(int boardId);

    public Board queryBoardByBoardId(int boardId);

    public Board queryBoardByBoardName(String boardName);

    /**
     * 使指定论坛模块id的帖子数+1
     * @param boardId
     * @return
     */
    public int updatePostNum(int boardId);

    public int updateBoardInfo(Board board);

    public int deleteBoard(int boardId);
}
