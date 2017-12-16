package com.lzk.dao;

import com.lzk.entity.Seckill;

import java.util.Date;
import java.util.List;

public interface SeckillDao {
    long reduceNumber(long seckillId, Date killDate);

    Seckill queryById(long seckillId);

    List<Seckill> queryAll(int offset, int limit);
}
