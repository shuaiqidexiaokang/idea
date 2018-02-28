package com.lzk.service.impl;

import com.lzk.mapper.TypeMapper;
import com.lzk.model.Type;
import com.lzk.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lzk on 2018/2/12 11:36
 * Description:
 */
@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeMapper typeMapper;

    @Override
    public List<Type> queryAll() {
        return typeMapper.queryAll();
    }
}
