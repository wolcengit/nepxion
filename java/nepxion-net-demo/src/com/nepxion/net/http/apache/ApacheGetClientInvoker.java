package com.nepxion.net.http.apache;

/**
 * <p>Title: Nepxion Server</p>
 * <p>Description: Nepxion Server Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.List;

import com.nepxion.util.encode.EncodeContext;
import com.nepxion.util.net.http.HttpConfig;
import com.nepxion.util.net.http.HttpContext;
import com.nepxion.util.net.http.apache.ClientInvoker;
import com.nepxion.util.net.http.apache.ClientParameter;
import com.nepxion.util.net.http.apache.ClientRequestGet;

public class ApacheGetClientInvoker
{	
	private static ClientInvoker clientInvoker = new ClientInvoker();
	
	public static void invokeServletForParameter()
	{		
		List list = new ArrayList();
		list.add(new ClientParameter("target", "服务调用"));
		list.add(new ClientParameter("entity", "参数"));
		
		HttpConfig httpConfig = HttpContext.getHttpConfig("ApacheServlet");
		
		ClientRequestGet clientRequestGet = new ClientRequestGet(httpConfig);
		clientRequestGet.setParameterEntity(list);		

		String responseText = null;
		try
		{
			responseText = clientInvoker.getResponseText(clientRequestGet);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		System.out.println(responseText);
	}
	
	public static void main(String[] args)
	{		
		HttpContext.register();
		EncodeContext.registerCharset("GB2312");
		
		ApacheGetClientInvoker.invokeServletForParameter();
		
		clientInvoker.shutdown();
	}	
}