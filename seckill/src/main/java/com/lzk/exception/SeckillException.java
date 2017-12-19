package com.lzk.exception;

/**
 * Created by lzk on 2017/12/17 19:00
 * Description:秒杀基础异常
 */
public class SeckillException extends RuntimeException {
    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
