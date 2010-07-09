package com.nepxion.util.net.http.apache;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nepxion.util.encode.EncodeContext;
import com.nepxion.util.encode.EncodeUtil;
import com.nepxion.util.io.IOUtil;

public class ServerInvoker
	extends HttpServlet
{
	public static final int REQUEST_ENTITY_TYPE_PARAMETER = 0;
	public static final int REQUEST_ENTITY_TYPE_STRING = 1;
	public static final int REQUEST_ENTITY_TYPE_SERIALIZABLE = 2;

	private int requestEntityType = REQUEST_ENTITY_TYPE_SERIALIZABLE;
	private String charset = EncodeContext.getHttpCharset();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException
	{
		doExecute(request, response, "Get");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException
	{
		doExecute(request, response, "Post");
	}
	
	public void doExecute(HttpServletRequest request, HttpServletResponse response, String method)
		throws ServletException, IOException
	{
		try
		{
			Object requestObject = null;
			switch (requestEntityType)
			{
				case REQUEST_ENTITY_TYPE_PARAMETER :
				{						
					Map parameters = new HashMap();
					for (Enumeration enumeration = request.getParameterNames(); enumeration.hasMoreElements();)
					{
						String key = (String) enumeration.nextElement();
						String value = request.getParameter(key);
						
						if (method.equals("Get"))
						{	
							value = EncodeUtil.format(value, charset);
						}						
						parameters.put(key, value);
					}	
					requestObject = parameters;
					ServerInvokerLogger.requestLog(method, charset, "List - [URL Parameter]", requestObject);
					break;
				}	
				case REQUEST_ENTITY_TYPE_STRING :
				{	
					requestObject = IOUtil.getString(request.getInputStream(), charset);
					ServerInvokerLogger.requestLog(method, charset, "String - [Text, XML, JSON, Properties ...]", requestObject);
					break;
				}
				case REQUEST_ENTITY_TYPE_SERIALIZABLE :
				{	
					requestObject = IOUtil.read(request.getInputStream());
					ServerInvokerLogger.requestLog(method, "Serializable Entity", requestObject);
					break;
				}	
			}
			
			Object responseObject = invoke(requestObject, request, response);
			if (responseObject != null)
			{	
				ServerInvokerLogger.responseLog("Serializable Entity", responseObject);
				
				IOUtil.write(response.getOutputStream(), responseObject);
			}
			else
			{
				ServerInvokerLogger.responseLog("Unknown Entity", "Invoked By Another Course - [OutputStream, PrintWriter ...]");
			}
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
			throw new IOException(e.toString());
		}
	}
	
	public Object invoke(Object requestObject, HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException
	{
		return null;
	}
	
	public int getRequestEntityType()
	{
		return requestEntityType;
	}
	
	public void setRequestEntityType(int requestEntityType)
	{
		this.requestEntityType = requestEntityType;
	}
	
	public String getCharset()
	{
		return charset;
	}
	
	public void setCharset(String charset)
	{
		this.charset = charset;
	}
}