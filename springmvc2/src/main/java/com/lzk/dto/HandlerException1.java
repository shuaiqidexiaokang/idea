package com.lzk.dto;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by lzk on 2017/12/30 14:49
 * Description:
 */
@ControllerAdvice
public class HandlerException1 {

    @ExceptionHandler({RuntimeException.class})
    public ModelAndView handlerArithmeticExceptionq(Exception ex){
        System.out.println("-----[出异常了]:" +ex);
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("exception",ex);
        return modelAndView;
    }
}
