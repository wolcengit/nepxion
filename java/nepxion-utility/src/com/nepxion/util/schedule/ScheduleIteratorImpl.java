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

import java.util.Calendar;
import java.util.Date;

public class ScheduleIteratorImpl
    implements ScheduleIterator
{
    private final Calendar calendar = Calendar.getInstance();

    private int[] intervalDayTime = {0, 0, 0, 1, 0};

    public ScheduleIteratorImpl()
    {
    }

    public int[] getIntervalDayTime()
    {
        return intervalDayTime;
    }

    public void setScheduleDayTime(Date date, int[] time)
    {
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, time[0]);
        calendar.set(Calendar.MINUTE, time[1]);
        calendar.set(Calendar.SECOND, time[2]);
        calendar.set(Calendar.MILLISECOND, 0);
        if (!calendar.getTime().before(date))
        {
            calendar.add(Calendar.DATE, -1);
        }
    }

    public void setIntervalDayTime(int[] intervalDayTime)
    {
        this.intervalDayTime = intervalDayTime;
    }

    public Date next()
    {
        calendar.add(Calendar.HOUR, intervalDayTime[0] * 24 + intervalDayTime[1]);
        calendar.add(Calendar.MINUTE, intervalDayTime[2]);
        calendar.add(Calendar.SECOND, intervalDayTime[3]);
        calendar.add(Calendar.MILLISECOND, intervalDayTime[4]);

        return calendar.getTime();
    }
}