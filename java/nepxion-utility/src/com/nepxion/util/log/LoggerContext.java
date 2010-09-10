package com.nepxion.util.log;

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
import org.apache.log4j.PropertyConfigurator;

public class LoggerContext
	implements LoggerConstants
{
	private static Log log = LogFactory.getLog(LoggerContext.class);
	
	public static void register()
		throws Exception
	{
		register(CONFIG_FILE_PATH);
	}
	
	public static void register(String filePath)
		throws Exception
	{		
		try
		{
			PropertyConfigurator.configure(filePath);
		}
		catch (Exception e)
		{
			log.fatal(e);
			throw e;
		}
	}
	
	public static void register(Properties properties)
		throws Exception
	{
		try
		{
			PropertyConfigurator.configure(properties);
		}
		catch (Exception e)
		{
			log.fatal(e);
			throw e;
		}
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
}