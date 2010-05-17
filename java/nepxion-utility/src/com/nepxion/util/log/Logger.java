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

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.nepxion.util.time.TimeUtil;

public class Logger
{
	private static HashMap logMap = new HashMap();
	
	public static Log getLog(String clazzName)
	{
		Log log = (Log) logMap.get(clazzName);
		if (log == null)
		{
			log = LogFactory.getLog(clazzName);
			logMap.put(clazzName, log);
		}
		return log;
	}
	
	public static void trace(String clazzName, Object message)
	{
		getLog(clazzName).trace(message);
	}		
	
	public static void trace(String clazzName, Object message, Throwable throwable)
	{
		getLog(clazzName).trace(message, throwable);
	}	
	
	public static void trace(String clazzName, Throwable throwable)
	{
		trace(clazzName, "Exception", throwable);
	}	
		
	public static void debug(String clazzName, Object message)
	{
		getLog(clazzName).debug(message);
	}	
	
	public static void debug(String clazzName, Object message, Throwable throwable)
	{
		getLog(clazzName).debug(message, throwable);
	}	
	
	public static void debug(String clazzName, Throwable throwable)
	{
		debug(clazzName, "Exception", throwable);
	}	
	
	public static void info(String clazzName, Object message)
	{
		getLog(clazzName).info(message);
	}	
	
	public static void info(String clazzName, Object message, Throwable throwable)
	{
		getLog(clazzName).info(message, throwable);
	}		
	
	public static void info(String clazzName, Throwable throwable)
	{
		info(clazzName, "Exception", throwable);
	}	
	
	public static void warn(String clazzName, Object message)
	{
		getLog(clazzName).warn(message);
	}	
	
	public static void warn(String clazzName, Object message, Throwable throwable)
	{
		getLog(clazzName).warn(message, throwable);
	}	
	
	public static void warn(String clazzName, Throwable throwable)
	{
		warn(clazzName, "Exception", throwable);
	}	
	
	public static void error(String clazzName, Object message)
	{
		getLog(clazzName).error(message);
	}	
	
	public static void error(String clazzName, Object message, Throwable throwable)
	{
		getLog(clazzName).error(message, throwable);
	}	
	
	public static void error(String clazzName, Throwable throwable)
	{
		error(clazzName, "Exception", throwable);
	}		
	
	public static void fatal(String clazzName, Object message)
	{
		getLog(clazzName).fatal(message);
	}	
	
	public static void fatal(String clazzName, Object message, Throwable throwable)
	{
		getLog(clazzName).fatal(message, throwable);
	}		
	
	public static void fatal(String clazzName, Throwable throwable)
	{
		fatal(clazzName, "Exception", throwable);
	}		
	
	public static void print(Object message)
	{
		System.out.println(TimeUtil.getCurrentTime() + " : " + message);
	}
		
	public static void print(Exception exception)
	{
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try
        {
        	exception.printStackTrace(new PrintStream(bos));
            bos.close();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        
		System.out.print(TimeUtil.getCurrentTime() + " : ");
		System.err.println(new String(bos.toByteArray()).trim());
	}	
	
	public static void main(String[] args)
	{
		for (int i = 0; i < 5; i++)
		{		
			try
			{
				Integer.parseInt("abc");
			}
			catch (NumberFormatException e)
			{
				Logger.fatal(Logger.class.getName(), "abc", e);
			}
		}
	}
}