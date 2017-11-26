package com.dinner3000.demo.respbody.advice;

import com.dinner3000.demo.respbody.helper.IOSSpecificProcessFlag;
import com.dinner3000.demo.respbody.helper.IOSSpecificProcessor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class ControllerAdvice {

    public void before(JoinPoint joinPoint){
        System.out.println("###ControllerAdvice - before()");
//        HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
//        System.out.println(String.format("Client-Type: %s", req.getHeader("client-type")));
    }

    public void after(JoinPoint joinPoint){
        System.out.println("###ControllerAdvice - after()");
//        HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
//        System.out.println(String.format("Client-Type: %s", req.getHeader("client-type")));
    }

    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("###ControllerAdvice - around() - before");
        HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        Object retVal = proceedingJoinPoint.proceed();

        if(req.getHeader("client-type").contains("IOS")) {
            if(!IOSSpecificProcessFlag.get()) {
                retVal = IOSSpecificProcessor.process(retVal);
                IOSSpecificProcessFlag.set(true);
                System.out.println("IOS float data just processed");
            } else{
                System.out.println("IOS float data already processed, skip");
            }
        }

        System.out.println("###ControllerAdvice - around() - after");
        return retVal;
    }

    public void afterReturning(JoinPoint joinPoint, Object retVal){
        System.out.println("###ControllerAdvice - afterReturning()");
    }
}
