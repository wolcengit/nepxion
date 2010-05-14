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

import com.nepxion.util.net.http.facility.ClientRequest;
import com.nepxion.util.net.http.facility.ServerInvoker;

public class FacilityXMLServlet
	extends ServerInvoker
{
	public Object invoke(ClientRequest clientRequest)
	{
		HashMap entity = clientRequest.getEntity();
		String name = (String) entity.get("name");
		String value = (String) entity.get("value");
		
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		stringBuffer.append("<records>");
		stringBuffer.append("<record index=\"" + 1 + "\" name=\"" + name + "\" value=\"" + value + "\"/>");
		stringBuffer.append("</records>");
		
		return stringBuffer.toString();
	}	
}