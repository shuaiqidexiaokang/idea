package com.lzk.exception;

/**
 * Created by lzk on 2017/12/17 19:01
 * Description:秒杀已经关闭异常，当秒杀结束就会出现这个异常
 */
public class SeckillCloseException extends SeckillException{
    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
