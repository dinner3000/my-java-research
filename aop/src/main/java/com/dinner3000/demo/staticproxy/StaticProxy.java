package com.dinner3000.demo.staticproxy;

import com.dinner3000.demo.model.User;
import com.dinner3000.demo.service.IUserService;
import com.dinner3000.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StaticProxy implements IUserService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    IUserService userService = null;
    public StaticProxy(IUserService subject){
        this.userService = subject;
    }

    public User queryUser(String id) {
        User ret;
        logger.info("###Static proxy - before");
        ret = userService.queryUser(id);
        logger.info("###Static proxy - after");

        return ret;
    }
}
