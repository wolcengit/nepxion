package com.nepxion.net.http.facility;

/**
 * <p>Title: Nepxion Server</p>
 * <p>Description: Nepxion Server Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.util.HashMap;

import com.nepxion.util.net.http.HttpConfig;
import com.nepxion.util.net.http.HttpContext;
import com.nepxion.util.net.http.facility.ClientInvoker;
import com.nepxion.util.net.http.facility.ClientRequest;

public class FacilityClientInvoker
{
	public static void invokeServer()
	{				
		HashMap map = new HashMap();
		map.put("target", "服务调用");
		map.put("entity", "对象");
		
		HttpConfig httpConfig = HttpContext.getHttpConfig("FacilityServerInvoker");
		
		ClientRequest clientRequest = new ClientRequest(httpConfig);
		clientRequest.setEntity(map);
				
		ClientInvoker clientInvoker = new ClientInvoker();
		
		Object object = null;
		try
		{
			object = clientInvoker.invoke(clientRequest);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		System.out.println(object);		
	}
	
	public static void main(String[] args)
	{		
		HttpContext.register();
		
		FacilityClientInvoker.invokeServer();
	}
}