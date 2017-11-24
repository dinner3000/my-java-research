package com.dinner3000.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectAdvice {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Pointcut("execution(* com.dinner3000.demo.service.UserService.*(..))")
    public void pointcut(){

    }

    @Before("pointcut()")
    public void before(JoinPoint jp){
        logger.info("###" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }
    @After("pointcut()")
    public void after(JoinPoint jp){
        logger.info("###" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }
    @Around("pointcut()")
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        logger.info("###" + Thread.currentThread().getStackTrace()[1].getMethodName() + " - before");
        pjp.proceed();
        logger.info("###" + Thread.currentThread().getStackTrace()[1].getMethodName() + " - after");
    }
}
