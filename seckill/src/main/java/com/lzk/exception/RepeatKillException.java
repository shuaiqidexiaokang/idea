package com.lzk.exception;

/**
 * Created by lzk on 2017/12/17 18:57
 * Description:重复秒杀异常，不需要我们手动去try catch
 */
public class RepeatKillException extends  SeckillException {
    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
