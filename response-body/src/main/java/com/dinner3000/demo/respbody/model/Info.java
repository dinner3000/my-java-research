package com.dinner3000.demo.respbody.model;

import java.math.BigDecimal;

public class Info{
    private int id = 10;
    private String name = "user";
    private double dValue = 12.9999999999F;
    private BigDecimal bValue = new BigDecimal(21.999999999F);

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getdValue() {
        return dValue;
    }

    public void setdValue(double dValue) {
        this.dValue = dValue;
    }

    public BigDecimal getbValue() {
        return bValue;
    }

    public void setbValue(BigDecimal bValue) {
        this.bValue = bValue;
    }
}