package com.lzk.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by lzk on 2017/12/30 16:44
 * Description:
 */
@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "用户名密码不匹配")
public class UserNameNotMatchPasswordException extends RuntimeException {


}
