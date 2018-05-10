package com.example.springboot.exception;

/**
 * springboot的异常捕获，ajax异常处理
 */

import com.example.springboot.pojo.IMoocJSONResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class SpringBootAjaxExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public IMoocJSONResult defaultErrorHandler(HttpServletRequest request, Exception e) throws Exception{
        e.printStackTrace();
        return IMoocJSONResult.errorException(e.getMessage());
    }

}
