package com.dinner3000.demo;

import com.dinner3000.demo.dynamicproxy.DynamicProxy;
import com.dinner3000.demo.service.IUserService;
import com.dinner3000.demo.service.UserService;
import com.dinner3000.demo.staticproxy.StaticProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Proxy;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        Logger logger = LoggerFactory.getLogger(App.class);
        logger.info("Go go go!");

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserService userService = context.getBean("userService", UserService.class);
        userService.queryUser("1");

/*
        IUserService userService1 = new StaticProxy(new UserService());
        userService1.queryUser("1");
*/

/*        IUserService userService2 = (IUserService) Proxy.newProxyInstance(App.class.getClassLoader(), new Class[]{IUserService.class}, new DynamicProxy(new UserService()));
        userService2.queryUser("1");*/
/*        userService.addUser(new User());
        userService.modUser(new User());
        userService.delUser("1");*/
    }
}
