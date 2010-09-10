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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;

public class QuartzContext
	implements QuartzConstants
{
	private static Log log = LogFactory.getLog(QuartzContext.class);
	
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
		log.info("--- Quartz Scheduler Initialization Start ---");
		
		try
		{
			factory = new QuartzSchedulerFactory(filePath);
			scheduler = factory.getScheduler();
		}
		catch (SchedulerException e)
		{
			log.fatal(e);
			throw e;
		}
		
		log.info("---- Quartz Scheduler Initialization End ----");
	}
	
	public static void register(Properties properties)
		throws SchedulerException
	{
		log.info("--- Quartz Scheduler Initialization Start ---");
		
		try
		{
			factory = new QuartzSchedulerFactory(properties);
			scheduler = factory.getScheduler();
		}
		catch (SchedulerException e)
		{
			log.fatal(e);
			throw e;
		}
		
		log.info("---- Quartz Scheduler Initialization End ----");
	}
	
	public static void register(URL codeBase)
		throws Exception
	{
		Properties properties = new Properties();
		try
		{
			URL url = new URL(codeBase + CONFIG_FILE_PATH);
			properties.load(url.openStream());
			
			register(properties);
		}
		catch (Exception e)
		{
			log.fatal(e);
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