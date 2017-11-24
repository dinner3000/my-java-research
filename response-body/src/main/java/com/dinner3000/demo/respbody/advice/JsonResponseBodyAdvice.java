package com.dinner3000.demo.respbody.advice;

import com.dinner3000.demo.respbody.model.Info;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class JsonResponseBodyAdvice implements ResponseBodyAdvice {
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        System.out.println("###JsonResponseBodyAdvice - supports()");
        return true;
    }

    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        System.out.println("###JsonResponseBodyAdvice - beforeBodyWrite()");
        HttpHeaders headers = serverHttpRequest.getHeaders();
        if(headers != null && headers.get("client-type").contains("IOS")){
//            o = DataFilter.filter(o);
        }
        return o;
    }


}
