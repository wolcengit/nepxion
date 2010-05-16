package com.nepxion.util.schedule;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.util.Date;

import com.nepxion.util.time.TimeUtil;

public class ScheduleExecuter
{
    private Scheduler scheduler;
    private ScheduleIteratorImpl scheduleIterator;
    
    public ScheduleExecuter()
    {
    	scheduler = new Scheduler();
    	scheduleIterator = new ScheduleIteratorImpl();
    }

    public void executeScheduler(SchedulerTask schedulerTask)
    {
        executeScheduler(schedulerTask, scheduleIterator.getIntervalDayTime());
    }

    public void executeScheduler(SchedulerTask schedulerTask, int[] intervalDayTime)
    {
        executeScheduler(schedulerTask, intervalDayTime, new Date(), new int[]{TimeUtil.getCurrentHour(), TimeUtil.getCurrentMinute(), TimeUtil.getCurrentSecond()});
    }

    public void executeScheduler(SchedulerTask schedulerTask, int[] intervalDayTime, Date startDay, int[] startTime)
    {
        scheduleIterator.setScheduleDayTime(startDay, startTime);
        scheduleIterator.setIntervalDayTime(intervalDayTime);

        scheduler.schedule(schedulerTask, scheduleIterator);
    }
}