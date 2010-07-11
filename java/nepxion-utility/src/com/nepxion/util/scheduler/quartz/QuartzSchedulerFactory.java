package com.nepxion.util.scheduler.quartz;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.util.Properties;

import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzSchedulerFactory
	extends StdSchedulerFactory
{
	public QuartzSchedulerFactory()
	{
		super();
	}
	
	public QuartzSchedulerFactory(String filePath)
		throws SchedulerException
	{
		super(filePath);
	}
	
	public QuartzSchedulerFactory(Properties properties)
		throws SchedulerException
	{
		super(properties);
	}
}