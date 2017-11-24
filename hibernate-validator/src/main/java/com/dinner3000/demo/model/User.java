package com.dinner3000.demo.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class User {

    @NotNull(message = "reason信息不可以为空")
    @Pattern(regexp = "[1-7]+", message = "reason的类型值为1-7中的一个类型")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
