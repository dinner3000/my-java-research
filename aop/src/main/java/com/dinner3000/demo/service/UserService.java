package com.dinner3000.demo.service;

import com.dinner3000.demo.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService implements IUserService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public User queryUser(String id) {
        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName());
        return new User();
    }

/*    public void addUser(User user) {
        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName());
    }
    public void modUser(User user) {
        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName());
    }
    public void delUser(String id) {
        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName());
    }*/
}
