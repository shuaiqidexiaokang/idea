package com.lzk.mapper;

import com.lzk.model.Type;

import java.util.List;

/**
 * Created by lzk on 2018/2/10 22:05
 * Description:
 */
public interface TypeMapper {
    /**
     * 查询所有类别
     * @return 所有类别
     */
    List<Type> queryAll();
}
