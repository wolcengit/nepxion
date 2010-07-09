package com.nepxion.net.http.apache.server;

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
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nepxion.util.net.http.apache.ServerInvoker;

public class SerializableServerInvoker
	extends ServerInvoker
{
	public SerializableServerInvoker()
	{		
		setRequestEntityType(REQUEST_ENTITY_TYPE_SERIALIZABLE);
	}
	
    public Object invoke(Object requestObject, HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException    
    {
    	if (requestObject instanceof HashMap) // Serializable Entity
    	{	    		
	    	HashMap requestMap = (HashMap) requestObject;
			String target = (String) requestMap.get("target");
			String entity = (String) requestMap.get("entity");
			
			HashMap responseMap = new HashMap();
			responseMap.put("target", target + "响应");
			responseMap.put("entity", entity + "响应");
			return responseMap;
    	}
    	else if (requestObject instanceof List) // InputStream Entity
    	{
    		List requestList = (List) requestObject;
    		
			List responseList = new ArrayList();
			responseList.add(requestList.get(0) + "响应");
			responseList.add(requestList.get(1) + "响应");			
			return responseList;    		
    	}
    	else if (requestObject instanceof File) // File Entity
    	{    		
    		File requestFile = (File) requestObject;    		
    		return requestFile;
    	}	
		return null;
    }
}