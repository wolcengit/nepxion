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

import com.nepxion.util.exception.ExceptionUtil;
import com.nepxion.util.time.TimeUtil;

public class Logger
{		
	public static void print(Object message)
	{
		System.out.println(TimeUtil.getCurrentTime() + " : " + message);
	}
		
	public static void print(Exception e)
	{		
		System.out.print(TimeUtil.getCurrentTime() + " : ");
		System.err.println(ExceptionUtil.getText(e));
	}	
}