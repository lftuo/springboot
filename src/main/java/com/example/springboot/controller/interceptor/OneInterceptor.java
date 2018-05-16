package com.example.springboot.controller.interceptor;

import com.example.springboot.pojo.IMoocJSONResult;
import com.example.springboot.utils.JsonUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public class OneInterceptor implements HandlerInterceptor {

    /**
     * 在请求处理之前调用
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("被one拦截，放行...");
        return true;
    }

    /**
     * 请求处理之后进行调用，但在视图被渲染之前（Controller方法调用之后）
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 在整个请求结束之后被调用，也就是在DispatcherServlet渲染了对应的视图之后执行
     * （主要用于进行资源清理工作）
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

   public void returnErrorResponse(HttpServletResponse response, IMoocJSONResult jsonResult) throws IOException {
       OutputStream outputStream = null;

       try {
           response.setCharacterEncoding("UTF-8");
           response.setContentType("text/json");
           outputStream.write(JsonUtils.objectToJson(jsonResult).getBytes("utf-8"));
           outputStream.flush();
       } finally {
           if (outputStream != null){
               outputStream.close();
           }
       }


   }
}
