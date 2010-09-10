package com.nepxion.util.net.http.apache;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ClientLogger
{
	private static Log log = LogFactory.getLog(ClientLogger.class);
	
	public static void requestInfo(String method, String charset, String dataType, Object dataInfo)
	{
		log.info("--------- Http Client Invoker Start ---------");
		log.info("Request Method     : " + method);
		log.info("Request Charset    : " + charset);
		log.info("Request Data Type  : " + dataType);
		log.info("Request Data Info  :\n" + dataInfo);
	}
	
	public static void requestInfo(String method, String dataType, Object dataInfo)
	{
		log.info("--------- Http Client Invoker Start ---------");
		log.info("Request Method     : " + method);
		log.info("Request Data Type  : " + dataType);
		log.info("Request Data Info  :\n" + dataInfo);
	}
	
	public static void responseInfo(String charset, String dataType, Object dataInfo)
	{
		log.info("---------------------------------------------");
		log.info("Response Charset   : " + charset);
		log.info("Response Data Type : " + dataType);
		log.info("Response Data Info :\n" + dataInfo);
		log.info("---------- Http Client Invoker End ----------");
	}
	
	public static void responseInfo(String dataType, Object dataInfo)
	{
		log.info("---------------------------------------------");
		log.info("Response Data Type : " + dataType);
		log.info("Response Data Info :\n" + dataInfo);
		log.info("---------- Http Client Invoker End ----------");
	}
	
	public static void fatal(Exception e)
	{
		log.fatal("Http Client Invoker Fatal", e);
	}
}