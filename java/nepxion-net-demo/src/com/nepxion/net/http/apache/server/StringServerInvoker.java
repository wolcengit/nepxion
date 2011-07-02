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

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nepxion.util.net.http.apache.ServerInvoker;

public class StringServerInvoker
	extends ServerInvoker
{
	public StringServerInvoker()
	{
		setRequestEntityType(REQUEST_ENTITY_TYPE_STRING);
		setResponseEntityType(RESPONSE_ENTITY_TYPE_STREAM);
		setCharset("GBK");
	}
	
	public Object invoke(Object requestObject, HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException
	{
		if (requestObject instanceof String) // String entity
		{
			request.setCharacterEncoding("GBK");
			response.setCharacterEncoding("GBK");
			
			String reponseObject = requestObject.toString();
			
			return reponseObject + "œÏ”¶";
		}
		
		return null;
	}
}