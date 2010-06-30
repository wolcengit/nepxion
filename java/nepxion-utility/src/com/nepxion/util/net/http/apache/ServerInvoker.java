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

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nepxion.util.encode.EncodeContext;
import com.nepxion.util.io.IOUtil;

public class ServerInvoker
	extends HttpServlet
{
	public static final int INPUT_STREAM_TYPE_OBJECT = 0;
	public static final int INPUT_STREAM_TYPE_STRING = 1;
	
	private int inputStreamType = INPUT_STREAM_TYPE_OBJECT;
	private String charset = EncodeContext.getHttpCharset();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException
	{
		doExecute(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException
	{
		doExecute(request, response);
	}
	
	public void doExecute(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException
	{
		try
		{
			Object requestObject = null;
			switch (inputStreamType)
			{
				case INPUT_STREAM_TYPE_OBJECT:
					requestObject = IOUtil.read(request.getInputStream());
					break;
				case INPUT_STREAM_TYPE_STRING:
					requestObject = IOUtil.getString(request.getInputStream(), charset);
					break;
				default:
					requestObject = IOUtil.read(request.getInputStream());
					break;
			}
			
			Object responseObject = invoke(requestObject, request, response);
			
			IOUtil.write(response.getOutputStream(), responseObject);
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
	
	public int getInputStreamType()
	{
		return inputStreamType;
	}
	
	public void setInputStreamType(int inputStreamType)
	{
		this.inputStreamType = inputStreamType;
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