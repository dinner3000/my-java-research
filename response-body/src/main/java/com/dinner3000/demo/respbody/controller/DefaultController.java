package com.dinner3000.demo.respbody.controller;

import com.dinner3000.demo.respbody.model.Info;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class DefaultController {

    @RequestMapping("getList")
    public @ResponseBody Object getList(){
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("d");
        list.add("c");

        return list;
    }

    @RequestMapping("getInfo")
    public @ResponseBody Object getInfo(){
        System.out.println("###DefaultController - getInfo()");
        return new Info();
    }


}
