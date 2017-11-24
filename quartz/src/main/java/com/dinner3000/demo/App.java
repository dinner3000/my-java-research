package com.dinner3000.demo;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws SchedulerException {

        JobDetail jd = JobBuilder.newJob(MyJob.class).withIdentity("myJob", "group1")
                .usingJobData("arg0", "aaa").build();

        Trigger tg = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1")
                .usingJobData("arg0", "bbb")
                .startNow().withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2)
                        .repeatForever()).build();

        Scheduler scheduler = (new StdSchedulerFactory()).getScheduler();
        scheduler.scheduleJob(jd, tg);

        scheduler.start();
    }

}
