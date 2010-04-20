package com.nepxion.util.schedule;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune 任浩军
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.util.*;

import com.nepxion.util.time.*;

public class ScheduleExecuter
{
    private Scheduler scheduler = new Scheduler();
    private ScheduleIteratorImpl scheduleIterator = new ScheduleIteratorImpl();

    public void executeScheduler(SchedulerTask schedulerTask)
    {
        executeScheduler(schedulerTask, scheduleIterator.getIntervalDayTime());
    }

    // 当前时间开始定时
    public void executeScheduler(SchedulerTask schedulerTask, int[] intervalDayTime)
    {
        executeScheduler(schedulerTask, intervalDayTime, new Date(), new int[]{TimeUtil.getCurrentHour(), TimeUtil.getCurrentMinute(), TimeUtil.getCurrentSecond()});
    }

    public void executeScheduler(SchedulerTask schedulerTask, int[] intervalDayTime, Date startDay, int[] startTime)
    {
        // 定时开始时间 -- 日期，时间(天/小时/分钟/秒)
        scheduleIterator.setScheduleDayTime(startDay, startTime);

        // 定时间隔时间 -- 时间(天/小时/分钟/秒/毫秒)
        scheduleIterator.setIntervalDayTime(intervalDayTime);

        // 定时开始
        scheduler.schedule(schedulerTask, scheduleIterator);
        /*try
        {
            schedulerTask.run();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }*/
    }
}