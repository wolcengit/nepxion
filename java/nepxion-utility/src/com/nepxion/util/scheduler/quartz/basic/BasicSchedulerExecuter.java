package com.nepxion.util.scheduler.quartz.basic;

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

import org.quartz.Scheduler;
import org.quartz.SchedulerException;

import com.nepxion.util.scheduler.quartz.QuartzConstants;
import com.nepxion.util.scheduler.quartz.QuartzContext;
import com.nepxion.util.scheduler.quartz.QuartzJobDetail;

public class BasicSchedulerExecuter
	implements QuartzConstants
{
	private String jobName;
	private String jobGroup = Scheduler.DEFAULT_GROUP;
	private Class jobClass;
	
	private String triggerName;
	private String triggerGroup = Scheduler.DEFAULT_GROUP;
	private Date startTime;
	private Date endTime;
	private int repeatCount = BasicTrigger.REPEAT_INDEFINITELY;
	private int[] repeatInterval = new int[] {0, 0, 0, 5, 0};
	
	private Scheduler scheduler;
	private boolean isScheduled = false;
	
	public QuartzJobDetail jobDetail;
	public BasicTrigger trigger;
	
	public BasicSchedulerExecuter()
	{
		scheduler = QuartzContext.getScheduler();	
	}
	
	public void scheduleJob()
	{
		if (scheduler == null)
		{
			return;
		}
		
		if (isScheduled)
		{
			return;
		}
		
		jobDetail = new QuartzJobDetail(jobName, jobGroup, jobClass);
		trigger = new BasicTrigger(triggerName, triggerGroup, jobName, jobGroup, startTime != null ? startTime : new Date(), endTime, repeatCount, repeatInterval);
		try
		{
			scheduler.scheduleJob(jobDetail, trigger);
			isScheduled = true;
		}
		catch (SchedulerException e)
		{
			e.printStackTrace();
		}
	}
	
	public void unscheduleJob()
	{
		if (scheduler == null)
		{
			return;
		}
		
		if (!isScheduled)
		{
			return;
		}
		
		try
		{
			scheduler.deleteJob(jobName, jobGroup);
			isScheduled = false;
		}
		catch (SchedulerException e)
		{
			e.printStackTrace();
		}
	}
	
	public void start()
	{
		if (scheduler == null)
		{
			return;
		}
		
		try
		{
			scheduler.start();
		}
		catch (SchedulerException e)
		{
			e.printStackTrace();
		}
	}
	
	public void pauseJob()
	{
		if (scheduler == null)
		{
			return;
		}
		
		try
		{
			scheduler.pauseJob(jobName, jobGroup);
		}
		catch (SchedulerException e)
		{
			e.printStackTrace();
		}
	}
	
	public void resumeJob()
	{
		if (scheduler == null)
		{
			return;
		}
		
		try
		{
			scheduler.resumeJob(jobName, jobGroup);
		}
		catch (SchedulerException e)
		{
			e.printStackTrace();
		}
	}
	
	public void shutDown()
	{
		if (scheduler == null)
		{
			return;
		}
		
		try
		{
			scheduler.shutdown(true);
		}
		catch (SchedulerException e)
		{
			e.printStackTrace();
		}
	}
	
	public boolean isStarted()
	{
		if (scheduler == null)
		{
			return false;
		}
		
		try
		{
			return scheduler.isStarted();
		}
		catch (SchedulerException e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean isShutDown()
	{
		if (scheduler == null)
		{
			return true;
		}
		
		try
		{
			return scheduler.isShutdown();
		}
		catch (SchedulerException e)
		{
			e.printStackTrace();
		}
		return true;
	}
	
	public boolean isScheduled()
	{
		return isScheduled;
	}
	
	public void setJobClass(Class jobClass)
		throws Exception
	{
		if (isScheduled)
		{
			throw new Exception("The job has been scheduled");
		}
		this.jobName = jobClass.getName();
		this.jobClass = jobClass;
		
		this.triggerName = jobClass.getName();
	}
	
	public void setStartTime(Date startTime)
	{
		this.startTime = startTime;
	}
	
	public void setEndTime(Date endTime)
	{
		this.endTime = endTime;
	}
	
	public void setRepeatCount(int repeatCount)
	{
		this.repeatCount = repeatCount;
	}
	
	public void setRepeatInterval(int[] repeatInterval)
	{
		this.repeatInterval = repeatInterval;
	}
}