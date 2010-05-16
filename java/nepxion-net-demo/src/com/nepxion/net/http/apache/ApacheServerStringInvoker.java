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

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nepxion.util.encode.EncodeUtil;
import com.nepxion.util.net.http.apache.ServerInvoker;

public class ApacheServerStringInvoker
	extends ServerInvoker
{
	public ApacheServerStringInvoker()
	{		
		setInputStreamType(ServerInvoker.INPUT_STREAM_TYPE_STRING);
	}
	
    public Object invoke(Object requestObject, HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException    
    {
    	System.out.println(requestObject);
		request.setCharacterEncoding("GBK");		
		response.setCharacterEncoding("GBK");	
		
    	if (requestObject instanceof String) // String entity
    	{
    		String reponseObject = EncodeUtil.formatGBK(requestObject.toString());
    		
    		System.out.println("String Entity for " + reponseObject);
    		
    		return reponseObject + "响应";
    	}	
		return null;
    }
}