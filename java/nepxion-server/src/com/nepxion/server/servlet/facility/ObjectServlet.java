package com.nepxion.server.servlet.facility;

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
import java.util.HashMap;
import java.util.List;

import com.nepxion.util.net.http.facility.ClientRequest;
import com.nepxion.util.net.http.facility.ServerInvoker;

public class ObjectServlet
	extends ServerInvoker
{
	public Object invoke(ClientRequest clientRequest)
	{
		HashMap entity = clientRequest.getEntity();
		String name = (String) entity.get("name");
		String value = (String) entity.get("value");
		
		List object = new ArrayList();
		object.add(name);
		object.add(value);
		return object;
	}	
}