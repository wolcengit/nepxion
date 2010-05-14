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

import com.nepxion.util.net.http.ClientContext;
import com.nepxion.util.net.http.facility.ClientInvoker;
import com.nepxion.util.net.http.facility.ClientRequest;

public class FacilityInvoker
{
	public static void main(String[] args)
	{
		ClientContext.setURI("http://localhost:8080/Nepxion-Net-Demo/FacilityXMLServlet");
		// ClientContext.setURI("http://localhost:8080/Nepxion-Net-Demo/FacilityObjectServlet");
		
		ClientRequest clientRequest = new ClientRequest();

		HashMap entity = new HashMap();
		entity.put("name", "nepxion");
		entity.put("value", "хн╨ф╬Э");
		clientRequest.setEntity(entity);
				
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
}