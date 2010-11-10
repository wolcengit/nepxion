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
		log.info("Request Data Info  :\n" + dataInfo);
		log.info("---------- Http Server Invoker End ----------");
	}
}