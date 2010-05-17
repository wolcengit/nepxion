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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.nepxion.util.time.TimeUtil;

public class Logger
{	
	public static Log getLog(Class clazz)
	{
		return LogFactory.getLog(clazz);
	}
	
	public static Log getLog(String className)
	{
		return LogFactory.getLog(className);
	}	
	
	// Trace
	public static void trace(Class clazz, Object message)
	{
		getLog(clazz).trace(message);
	}	
	
	public static void trace(String className, Object message)
	{
		getLog(className).trace(message);
	}		
	
	public static void trace(Class clazz, Throwable throwable)
	{
		getLog(clazz).trace("Exception", throwable);
	}	
	
	public static void trace(String className, Throwable throwable)
	{
		getLog(className).trace("Exception", throwable);
	}	
	
	public static void trace(Class clazz, Object message, Throwable throwable)
	{
		getLog(clazz).trace(message, throwable);
	}	
	
	public static void trace(String className, Object message, Throwable throwable)
	{
		getLog(className).trace(message, throwable);
	}	
		
	
	// Debug
	public static void debug(Class clazz, Object message)
	{
		getLog(clazz).debug(message);
	}		
	
	public static void debug(String className, Object message)
	{
		getLog(className).debug(message);
	}	

	public static void debug(Class clazz, Throwable throwable)
	{
		getLog(clazz).debug("Exception", throwable);
	}
	
	public static void debug(String className, Throwable throwable)
	{
		getLog(className).debug("Exception", throwable);
	}
	
	public static void debug(Class clazz, Object message, Throwable throwable)
	{
		getLog(clazz).debug(message, throwable);
	}		
	
	public static void debug(String className, Object message, Throwable throwable)
	{
		getLog(className).debug(message, throwable);
	}	
	

	// Info
	public static void info(Class clazz, Object message)
	{
		getLog(clazz).info(message);
	}	
	
	public static void info(String className, Object message)
	{
		getLog(className).info(message);
	}	
	
	public static void info(Class clazz, Throwable throwable)
	{
		getLog(clazz).info("Exception", throwable);
	}		

	public static void info(String className, Throwable throwable)
	{
		getLog(className).info("Exception", throwable);
	}		
	
	public static void info(Class clazz, Object message, Throwable throwable)
	{
		getLog(clazz).info(message, throwable);
	}		
	
	public static void info(String className, Object message, Throwable throwable)
	{
		getLog(className).info(message, throwable);
	}		
	

	// Warn
	public static void warn(Class clazz, Object message)
	{
		getLog(clazz).warn(message);
	}	
	
	public static void warn(String className, Object message)
	{
		getLog(className).warn(message);
	}	
	
	public static void warn(Class clazz, Throwable throwable)
	{
		getLog(clazz).warn("Exception", throwable);
	}	
	
	public static void warn(String className, Throwable throwable)
	{
		getLog(className).warn("Exception", throwable);
	}	
	
	public static void warn(Class clazz, Object message, Throwable throwable)
	{
		getLog(clazz).warn(message, throwable);
	}
	
	public static void warn(String className, Object message, Throwable throwable)
	{
		getLog(className).warn(message, throwable);
	}	
	

	
	// Error
	public static void error(Class clazz, Object message)
	{
		getLog(clazz).error(message);
	}	
	
	public static void error(String className, Object message)
	{
		getLog(className).error(message);
	}	
	
	public static void error(Class clazz, Throwable throwable)
	{
		getLog(clazz).error("Exception", throwable);
	}		
	
	public static void error(String className, Throwable throwable)
	{
		getLog(className).error("Exception", throwable);
	}		
	
	public static void error(Class clazz, Object message, Throwable throwable)
	{
		getLog(clazz).error(message, throwable);
	}	
	
	public static void error(String className, Object message, Throwable throwable)
	{
		getLog(className).error(message, throwable);
	}	
	
	
	// Fatal
	public static void fatal(Class clazz, Object message)
	{
		getLog(clazz).fatal(message);
	}	
	
	public static void fatal(String className, Object message)
	{
		getLog(className).fatal(message);
	}
	
	public static void fatal(Class clazz, Throwable throwable)
	{
		getLog(clazz).fatal("Exception", throwable);
	}		
	
	public static void fatal(String className, Throwable throwable)
	{
		getLog(className).fatal("Exception", throwable);
	}		
	
	public static void fatal(Class clazz, Object message, Throwable throwable)
	{
		getLog(clazz).fatal(message, throwable);
	}	
	
	public static void fatal(String className, Object message, Throwable throwable)
	{
		getLog(className).fatal(message, throwable);
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