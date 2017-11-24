package com.dinner3000.demo.respbody.advice;

import com.dinner3000.demo.respbody.helper.DataFilter;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class DefaultControllerAOPAdvice {

    public void before(JoinPoint joinPoint){
        System.out.println("###DefaultControllerAOPAdvice - before()");
//        HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
//        System.out.println(String.format("Client-Type: %s", req.getHeader("client-type")));
    }

    public void after(JoinPoint joinPoint){
        System.out.println("###DefaultControllerAOPAdvice - after()");
//        HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
//        System.out.println(String.format("Client-Type: %s", req.getHeader("client-type")));
    }

    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("###DefaultControllerAOPAdvice - around() - before");
//        HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
//        System.out.println(String.format("Client-Type: %s", req.getHeader("client-type")));

        Object retVal = proceedingJoinPoint.proceed();

        retVal = DataFilter.filter(retVal);

        System.out.println("###DefaultControllerAOPAdvice - around() - after");
        return retVal;
    }

    public void afterReturning(JoinPoint joinPoint, Object retVal){
        System.out.println("###DefaultControllerAOPAdvice - afterReturning()");
    }
}
