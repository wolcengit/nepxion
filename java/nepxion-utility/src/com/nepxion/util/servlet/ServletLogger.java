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

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ServletLogger
{
	private static Log log = LogFactory.getLog(ServletLogger.class);
	
	public static void requestInfo(String method, String dataType, HttpServletRequest request)
	{
		String dataInfo = ServletUtil.getDataInfo(request, dataType);
		requestInfo(method, dataType, dataInfo);
	}
	
	public static void requestInfo(String method, String dataType, Object dataInfo)
	{
		log.info("--------- Http Server Invoker Start ---------");
		log.info("Request Method     : " + method);
		log.info("Request Data Type  : " + dataType);
		log.info("Request Data Info  :\n" + paser(dataInfo));
		log.info("---------- Http Server Invoker End ----------");
	}
	
	public static String paser(Object dataInfo)
	{
		if (dataInfo instanceof List)
		{
			List list = (List) dataInfo;
			int size = list.size();
			
			if (size > 10)
			{	
				String classInfo = "List";
				String containClassInfo = "";
				if (size > 0)
				{
					containClassInfo = "[" + list.get(0).getClass().getName() + "]";
				}	
	
				String sizeInfo = ", Size is " + size;
				
				return  classInfo + containClassInfo + sizeInfo;
			}
		}
		
		return dataInfo.toString();
	}
}