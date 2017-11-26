package com.dinner3000.demo.respbody.interceptor;


import com.dinner3000.demo.respbody.helper.IOSSpecificProcessFlag;
import org.springframework.core.NamedThreadLocal;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

public class IOSSpecificProcessInterceptor implements WebRequestInterceptor {
    public void preHandle(WebRequest webRequest) throws Exception {

        System.out.println("###IOSSpecificProcessInterceptor - preHandle()");
        IOSSpecificProcessFlag.set(false);
    }

    public void postHandle(WebRequest webRequest, ModelMap modelMap) throws Exception {

        System.out.println("###IOSSpecificProcessInterceptor - postHandle()");
    }

    public void afterCompletion(WebRequest webRequest, Exception e) throws Exception {

        System.out.println("###IOSSpecificProcessInterceptor - afterCompletion()");
        IOSSpecificProcessFlag.remove();
    }
}
