package com.dinner3000.demo.respbody.helper;

import com.dinner3000.demo.respbody.helper.IOSSpecificProcessor;
import com.dinner3000.demo.respbody.helper.IOSSpecificProcessFlag;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

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
            if(!IOSSpecificProcessFlag.get()) {
                o = IOSSpecificProcessor.process(o);
                IOSSpecificProcessFlag.set(true);
                System.out.println("IOS float data just processed");
            } else{
                System.out.println("IOS float data already processed, skip");
            }
        }
        return o;
    }


}
