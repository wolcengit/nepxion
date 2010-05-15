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

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nepxion.util.net.http.apache.ServerInvoker;

public class ApacheServerInvoker
	extends ServerInvoker
{
    public Object invoke(Object requestObject, HttpServletRequest request, HttpServletResponse response)
    {
    	if (requestObject instanceof HashMap) // Serializable Entity
    	{	
    		System.out.println("Serializable Entity for " + requestObject);
    		
	    	HashMap requestMap = (HashMap) requestObject;
			String target = (String) requestMap.get("target");
			String entity = (String) requestMap.get("entity");
			
			HashMap responseMap = new HashMap();
			responseMap.put("target", target + "-response");
			responseMap.put("entity", entity + "-response");
			return responseMap;
    	}
    	else if (requestObject instanceof List) // InputStream Entity
    	{
    		System.out.println("InputStream Entity for " + requestObject);

    		List requestList = (List) requestObject;
    		
			List responseList = new ArrayList();
			responseList.add(requestList.get(0) + "-response");
			responseList.add(requestList.get(1) + "-response");			
			return responseList;    		
    	}
    	else if (requestObject instanceof String) // String entity
    	{
    		System.out.println("String Entity for " + requestObject);
    		
    		return requestObject + "-response";
    	}	
    	else if (requestObject instanceof File)
    	{
    		
    	}	
    	
		return null;
    }
}