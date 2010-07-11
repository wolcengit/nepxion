package com.nepxion.util.net.http;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.util.Iterator;
import java.util.LinkedHashMap;

import com.nepxion.util.log.Logger;

public class HttpContextLogger
{
	public static void log(LinkedHashMap httpConfigMap)
	{
		int index = 0;
		int size = httpConfigMap.keySet().size() - 1;
		for (Iterator iterator = httpConfigMap.keySet().iterator(); iterator.hasNext();)
		{
			String alias = (String) iterator.next();			
			HttpConfig httpConfig = (HttpConfig) httpConfigMap.get(alias);
			Logger.info(HttpContextLogger.class, "Alias : " + httpConfig.getAlias());
			Logger.info(HttpContextLogger.class, "Host : " + httpConfig.getHost());
			Logger.info(HttpContextLogger.class, "Port : " + httpConfig.getPort());
			Logger.info(HttpContextLogger.class, "path : " + httpConfig.getPath());
			Logger.info(HttpContextLogger.class, "Connection TimeOut : " + httpConfig.getConnectionTimeOut());
			Logger.info(HttpContextLogger.class, "Response TimeOut : " + httpConfig.getResponseTimeOut());
			Logger.info(HttpContextLogger.class, "Buffer Size : " + httpConfig.getBufferSize());
			if (index < size)
			{	
				Logger.info(HttpContextLogger.class, "---------------------------------------------");
			}
			index++;
		}		
	}
}