package com.nepxion.util.schedule;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune хн╨ф╬Э
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.util.*;

public abstract class SchedulerTask
    implements Runnable
{
    final Object lock = new Object();

    public static final int VIRGIN = 0;
    public static final int SCHEDULED = 1;
    public static final int CANCELLED = 2;

    protected int state = VIRGIN;

    TimerTask timerTask;

    protected SchedulerTask()
    {
    }

    public abstract void run();

    public boolean cancel()
    {
        synchronized (lock)
        {
            if (timerTask != null)
            {
                timerTask.cancel();
            }
            boolean result = (state == SCHEDULED);
            state = CANCELLED;
            return result;
        }
    }

    public int getState()
    {
        return state;
    }

    public long scheduledExecutionTime()
    {
        synchronized (lock)
        {
            return timerTask == null ? 0 : timerTask.scheduledExecutionTime();
        }
    }
}