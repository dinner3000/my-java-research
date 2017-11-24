package com.dinner3000.demo.dynamicproxy;

import com.dinner3000.demo.model.User;
import com.dinner3000.demo.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy implements InvocationHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    IUserService userService = null;
    public DynamicProxy(IUserService subject){
        this.userService = subject;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        User ret;
        logger.info("###Dynamic proxy - before");
        ret = (User)method.invoke(userService, args);
        logger.info("###Dynamic proxy - after");

        return ret;
    }
}
