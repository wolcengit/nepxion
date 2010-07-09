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

import com.nepxion.util.log.Logger;

public class ClientInvokerLogger
{
	public static void requestLog(String method, String charset, String dataType, Object dataInfo)
	{
		Logger.info(ClientInvokerLogger.class, "-------- Http Client Invoker Start --------");
		Logger.info(ClientInvokerLogger.class, "Request Method     : " + method);
		Logger.info(ClientInvokerLogger.class, "Request Charset    : " + charset);
		Logger.info(ClientInvokerLogger.class, "Request Data Type  : " + dataType);
		Logger.info(ClientInvokerLogger.class, "Request Data Info  :\n" + dataInfo);
	}

	public static void requestLog(String method, String dataType, Object dataInfo)
	{
		Logger.info(ClientInvokerLogger.class, "-------- Http Client Invoker Start --------");
		Logger.info(ClientInvokerLogger.class, "Request Method     : " + method);
		Logger.info(ClientInvokerLogger.class, "Request Data Type  : " + dataType);
		Logger.info(ClientInvokerLogger.class, "Request Data Info  :\n" + dataInfo);
	}
	
	public static void responseLog(String charset, String dataType, Object dataInfo)
	{		
		Logger.info(ClientInvokerLogger.class, "-------------------------------------------");
		Logger.info(ClientInvokerLogger.class, "Response Charset   : " + charset);
		Logger.info(ClientInvokerLogger.class, "Response Data Type : " + dataType);
		Logger.info(ClientInvokerLogger.class, "Response Data Info :\n" + dataInfo);
		Logger.info(ClientInvokerLogger.class, "--------- Http Client Invoker End ---------");
	}

	public static void responseLog(String dataType, Object dataInfo)
	{		
		Logger.info(ClientInvokerLogger.class, "-------------------------------------------");
		Logger.info(ClientInvokerLogger.class, "Response Data Type : " + dataType);
		Logger.info(ClientInvokerLogger.class, "Response Data Info :\n" + dataInfo);
		Logger.info(ClientInvokerLogger.class, "--------- Http Client Invoker End ---------");
	}
}