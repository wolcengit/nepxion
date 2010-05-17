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
import com.nepxion.util.net.http.ClientContext;
import com.nepxion.util.net.http.apache.ClientInvoker;
import com.nepxion.util.net.http.apache.ClientParameter;
import com.nepxion.util.net.http.apache.ClientRequestGet;

public class ApacheGetClientInvoker
{	
	private static ClientInvoker clientInvoker = new ClientInvoker();
	
	public static void invokeServletForParameter()
	{
		//ClientContext.registerURL("http://localhost:8080/Nepxion-Net-Demo/ApacheServlet");
		ClientContext.register();
		EncodeContext.registerCharset("GB2312");
		
		List list = new ArrayList();
		list.add(new ClientParameter("target", "服务调用"));
		list.add(new ClientParameter("entity", "参数"));
		
		ClientRequestGet clientRequestGet = new ClientRequestGet();
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
		ApacheGetClientInvoker.invokeServletForParameter();
		
		clientInvoker.shutdown();
	}	
}