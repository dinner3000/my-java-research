package com.dinner3000.demo.respbody.advice;


import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

public class DefaultControllerInterceptor implements WebRequestInterceptor {
    public void preHandle(WebRequest webRequest) throws Exception {

        System.out.println("###DefaultControllerInterceptor - preHandle()");
    }

    public void postHandle(WebRequest webRequest, ModelMap modelMap) throws Exception {

        System.out.println("###DefaultControllerInterceptor - postHandle()");
    }

    public void afterCompletion(WebRequest webRequest, Exception e) throws Exception {

        System.out.println("###DefaultControllerInterceptor - afterCompletion()");
    }
}
