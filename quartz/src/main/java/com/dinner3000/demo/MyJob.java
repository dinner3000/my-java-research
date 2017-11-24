package com.dinner3000.demo;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MyJob implements Job {
    private String arg0;

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
//        System.out.println("Hello " + jobExecutionContext.getMergedJobDataMap().getString("arg0") + "!");
        System.out.println("Hello " + arg0 + "!");
    }

    public String getArg0() {
        return arg0;
    }

    public void setArg0(String arg0) {
        this.arg0 = arg0;
    }
}
