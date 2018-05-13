package com.example.springboot.exception;

import com.example.springboot.pojo.IMoocJSONResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class SpringBootExceptionHandler {

    public static final String SPRING_BOOT_VIEW = "error";

    //@ExceptionHandler(value = Exception.class)
    /*public Object errorHandler(HttpServletRequest request, HttpServletResponse response, Exception e) throws Exception{
        e.printStackTrace();
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", request.getRequestURL());
        mav.setViewName(SPRING_BOOT_VIEW);

        return mav;
    }*/

    @ExceptionHandler(value = Exception.class)
    public Object errorHandler(HttpServletRequest request, HttpServletResponse response, Exception e) throws Exception{
        e.printStackTrace();

        if (isAjax(request)){
            return IMoocJSONResult.errorException(e.getMessage());
        } else {

            ModelAndView mav = new ModelAndView();
            mav.addObject("exception", e);
            mav.addObject("url", request.getRequestURL());
            mav.setViewName(SPRING_BOOT_VIEW);

            return mav;
        }
    }

    /**
     * 判断是否是ajax请求
     * @param request
     * @return
     */
    public static boolean isAjax(HttpServletRequest request){
        return (request.getHeader("X-Requested-with") != null
                && "XMLHttpRequest".equals(request.getHeader("X-Requested-with").toString()));
    }

}
