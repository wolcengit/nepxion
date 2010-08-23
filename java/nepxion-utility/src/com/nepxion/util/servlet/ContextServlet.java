package com.nepxion.util.servlet;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.io.FileInputStream;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.PropertyConfigurator;
import org.logicalcobwebs.proxool.ProxoolException;
import org.quartz.SchedulerException;

import com.nepxion.util.database.pool.proxool.ProxoolContext;
import com.nepxion.util.scheduler.quartz.QuartzContext;

public class ContextServlet
	extends HttpServlet
{
	public void init(ServletConfig config)
		throws ServletException
	{
		super.init(config);
		
		initLogger();
		initProxool();
		initQuartz();
	}
	
	private void initLogger()
	{
		String loggerPath = getInitParameter("loggerPath");
		if (loggerPath != null)
		{
			loggerPath = getServletContext().getRealPath(loggerPath);
			
			Properties properties = new Properties();
			
			try
			{
				FileInputStream fis = new FileInputStream(loggerPath);
				properties.load(fis);
				fis.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			
			loggerPath = loggerPath.substring(0, loggerPath.lastIndexOf("\\") + 1);
			
			properties.setProperty("log4j.appender.FileAppender.File", loggerPath + properties.getProperty("log4j.appender.FileAppender.File"));
			properties.setProperty("log4j.appender.RollingFileAppender.File", loggerPath + properties.getProperty("log4j.appender.RollingFileAppender.File"));
			
			PropertyConfigurator.configure(properties);
		}
	}
	
	private void initProxool()
	{
		String proxoolPath = getInitParameter("proxoolPath");
		if (proxoolPath != null)
		{
			proxoolPath = getServletContext().getRealPath(proxoolPath);
			try
			{
				ProxoolContext.register(proxoolPath);
			}
			catch (ProxoolException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	private void initQuartz()
	{
		String quartzPath = getInitParameter("quartzPath");
		if (quartzPath != null)
		{
			quartzPath = getServletContext().getRealPath(quartzPath);
			try
			{
				QuartzContext.register(quartzPath);
			}
			catch (SchedulerException e)
			{
				e.printStackTrace();
			}
		}
	}
}