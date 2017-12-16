package com.lzk.dao;

import com.lzk.entity.SuccessKilled;

public interface SuccessKilledDao {
    int insertSuccessKilled(long seckillId, long userPhone);

    SuccessKilled queryByIdWithSeckill(long seckillId);
}
