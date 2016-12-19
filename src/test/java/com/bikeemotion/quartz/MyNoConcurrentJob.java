package com.bikeemotion.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://github.com/FlavioF/quartz-scheduler-hazelcast-jobstore/blob/master/src/test/java/com/bikeemotion/quartz/MyNoConcurrentJob.java<br>
 */
public class MyNoConcurrentJob implements Job, Serializable {

    private static final Logger LOG = LoggerFactory.getLogger(MyNoConcurrentJob.class);

    public static int count = 0;
    public static Queue<String> jobKeys = new LinkedList<>();
    public static Queue<String> triggerKeys = new LinkedList<>();
    public static long waitTime = 300;

    @Override
    public void execute(final JobExecutionContext jobCtx)
            throws JobExecutionException {

        jobKeys.add(jobCtx.getJobDetail().getKey().getName());
        triggerKeys.add(jobCtx.getTrigger().getKey().getName());
        count++;
        LOG.info("Processing Trigger " + jobCtx.getTrigger().getKey().getName() + " " + new Date());
        try {
            Thread.sleep(waitTime);
        } catch (InterruptedException ex) {
        }
        LOG.info("All job done");
    }
}