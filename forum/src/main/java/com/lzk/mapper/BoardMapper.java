package com.lzk.mapper;

import com.lzk.model.Board;

import java.util.List;

public interface BoardMapper {
    /**
     * 添加论坛版块（论坛名称、论坛描述、帖子数目）
     * @param board
     */
    public int addBoard(Board board);

    /**
     * 查询所有论坛版块信息
     * @return
     */
    public List<Board> listAllBoard();

    /**
     * 查询指定论坛版块id的论坛帖子
     * @param boardId
     * @return
     */
    public Board listAllPostsOfBoard(int boardId);

    /**
     * 根据论坛id查询论坛信息
     * @param boardId
     * @return
     */
    public Board findBoardByBoardId(int boardId);

    /**
     * 根据论坛名称查询论坛信息
     * @param boardName
     * @return
     */
    public Board findBoardByBoardName(String boardName);

    /**
     * 修改论坛信息
     * @param board
     */
    public int updateBoardByBoard(Board board);

    /**
     * 根据论坛id删除论坛
     * @param boardId
     */
    public int deleteBoardById(int boardId);
}
