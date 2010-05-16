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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nepxion.util.net.http.facility.ClientRequest;
import com.nepxion.util.net.http.facility.ServerInvoker;

public class FacilityServerInvoker
	extends ServerInvoker
{
	public Object invoke(ClientRequest clientRequest, HttpServletRequest request, HttpServletResponse response)
	{
		HashMap requestMap = clientRequest.getEntity();
		String target = (String) requestMap.get("target");
		String entity = (String) requestMap.get("entity");
		
		HashMap responseMap = new HashMap();
		responseMap.put("target", target + "响应");
		responseMap.put("entity", entity + "响应");
		return responseMap;
	}	
}