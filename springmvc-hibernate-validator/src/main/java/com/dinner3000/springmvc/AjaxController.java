package com.dinner3000.springmvc;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@Validated
public class AjaxController {

    @RequestMapping("index")
    public Object index(@NotEmpty String id){
        return "Ok";
    }
}
