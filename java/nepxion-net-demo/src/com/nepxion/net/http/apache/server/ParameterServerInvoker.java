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
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nepxion.util.net.http.apache.ServerInvoker;

public class ParameterServerInvoker
	extends ServerInvoker
{
	public ParameterServerInvoker()
	{
		setRequestEntityType(REQUEST_ENTITY_TYPE_PARAMETER);
		setCharset("GBK");
	}
	
	/*
	 * 1. response.getWriter()和response.getOutputStream()方法只允许选择其一被调用，不能同时被调用，否则抛错;
	 * 2. invoke方法返回的对象是通过父类ServerInvoker的outputStream方式回写到客户端，当调用out输出方式，则需要把返回对象置为null；
	 * 3. out输出方式的字符串，在客户端需要通过clientInvoker.getResponseText获得，否则出现乱码；
	 */
    public Object invoke(Object requestObject, HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException    
    {		
    	if (requestObject instanceof Map) // Parameter entity
    	{    		
    		request.setCharacterEncoding("GBK");		
    		response.setCharacterEncoding("GBK");		
    		response.setContentType("text/xml");
    	
    		Map requestMap = (Map) requestObject;   
    		
    		String target = requestMap.get("target").toString();
    		String entity = requestMap.get("entity").toString();
    		
    		PrintWriter out = response.getWriter();
    		out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    		out.println("<records>");
    		out.println("<record index=\"" + 1 + "\" target=\"" + target + "响应" + "\" entity=\"" + entity + "响应" + "\"/>");
    		out.println("</records>");	
    	}	
		return null;
    }
}