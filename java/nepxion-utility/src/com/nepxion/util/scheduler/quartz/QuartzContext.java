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

import java.net.URL;
import java.util.Properties;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;

import com.nepxion.util.database.pool.proxool.ProxoolConnectionPool;
import com.nepxion.util.log.Logger;

public class QuartzContext
	implements QuartzConstants
{
	private static QuartzSchedulerFactory factory;
	private static Scheduler scheduler;
	
	public static void register()
		throws SchedulerException
	{
		register(CONFIG_FILE_PATH);
	}
	
	public static void register(String filePath)
		throws SchedulerException
	{
		Logger.info(QuartzContext.class, "--- Quartz Scheduler Initialization Start ---");
		
		try
		{
			factory = new QuartzSchedulerFactory(filePath);
			scheduler = factory.getScheduler();
		}
		catch (SchedulerException e)
		{
			Logger.fatal(QuartzContext.class, e);
			throw e;
		}
		
		Logger.info(QuartzContext.class, "---- Quartz Scheduler Initialization End ----");
	}
	
	public static void register(Properties properties)
		throws SchedulerException
	{
		Logger.info(QuartzContext.class, "--- Quartz Scheduler Initialization Start ---");
		
		try
		{
			factory = new QuartzSchedulerFactory(properties);
			scheduler = factory.getScheduler();
		}
		catch (SchedulerException e)
		{
			Logger.fatal(QuartzContext.class, e);
			throw e;
		}
		
		Logger.info(QuartzContext.class, "---- Quartz Scheduler Initialization End ----");
	}
	
	public static void register(URL codeBaseURL)
		throws Exception
	{
		Properties properties = new Properties();
		try
		{
			URL url = new URL(codeBaseURL + CONFIG_FILE_PATH);
			properties.load(url.openStream());
			
			register(properties);
		}
		catch (Exception e)
		{
			Logger.fatal(ProxoolConnectionPool.class, e);
			throw e;
		}
	}
	
	public static QuartzSchedulerFactory getFactory()
	{
		return factory;
	}
	
	public static Scheduler getScheduler()
	{
		return scheduler;
	}
}