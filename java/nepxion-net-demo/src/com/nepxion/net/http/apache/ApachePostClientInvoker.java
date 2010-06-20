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
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.nepxion.util.encode.EncodeContext;
import com.nepxion.util.io.IOUtil;
import com.nepxion.util.net.http.HttpConfig;
import com.nepxion.util.net.http.HttpContext;
import com.nepxion.util.net.http.apache.ClientInvoker;
import com.nepxion.util.net.http.apache.ClientParameter;
import com.nepxion.util.net.http.apache.ClientRequestPost;

public class ApachePostClientInvoker
{	
	private static ClientInvoker clientInvoker = new ClientInvoker();
	
	public static void invokeServletForParameter()
	{
		EncodeContext.registerCharset("GB2312");
				
		List entity = new ArrayList();
		entity.add(new ClientParameter("target", "服务调用"));
		entity.add(new ClientParameter("entity", "参数"));
		
		HttpConfig httpConfig = HttpContext.getHttpConfig("ApacheServlet");
		
		ClientRequestPost clientRequestPost = new ClientRequestPost(httpConfig);
		clientRequestPost.setParameterEntity(entity);

		String responseText = null;
		try
		{
			responseText = clientInvoker.getResponseText(clientRequestPost);			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		System.out.println(responseText);		
	}
	
	public static void invokeServerForSerializable()
	{		
		HashMap map = new HashMap();
		map.put("target", "服务调用");
		map.put("entity", "序列化");
		
		HttpConfig httpConfig = HttpContext.getHttpConfig("ApacheServerObjectInvoker");
		
		ClientRequestPost clientRequestPost = new ClientRequestPost(httpConfig);
		clientRequestPost.setSerializableEntity(map, false);		

		Object responseObject = null;
		try
		{
			responseObject = clientInvoker.getResponseObject(clientRequestPost);		
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}   
		System.out.println(responseObject);		
	}
	
	public static void invokeServerForInputStream()
	{		
		List list = new ArrayList();
		list.add("服务调用");
		list.add("流");
		
		InputStream inputStream = null;
		try
		{
			inputStream = IOUtil.getInputStream(list);
		}
		catch (IOException e1)
		{
			e1.printStackTrace();
		}
		
		HttpConfig httpConfig = HttpContext.getHttpConfig("ApacheServerObjectInvoker");
		
		ClientRequestPost clientRequestPost = new ClientRequestPost(httpConfig);
		clientRequestPost.setInputStreamEntity(inputStream);		

		Object responseObject = null;
		try
		{
			responseObject = clientInvoker.getResponseObject(clientRequestPost);		
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}   
		System.out.println(responseObject);		
	}
	
	public static void invokeServerForString()
	{
		EncodeContext.registerCharset("GB2312");
		
		String text = "[目标为服务调用，实体为字符串]";
		
		HttpConfig httpConfig = HttpContext.getHttpConfig("ApacheServerStringInvoker");
		
		ClientRequestPost clientRequestPost = new ClientRequestPost(httpConfig);
		clientRequestPost.setStringEntity(text);		
		
		Object responseObject = null;
		try
		{
			responseObject = clientInvoker.getResponseObject(clientRequestPost);		
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}   
		System.out.println(responseObject);		
	}	
	
	public static void invokeServerForFile()
	{		
		File file = new File("conf/http.properties");
		
		HttpConfig httpConfig = HttpContext.getHttpConfig("ApacheServerStringInvoker");
		
		ClientRequestPost clientRequestPost = new ClientRequestPost(httpConfig);
		clientRequestPost.setFileEntity(file);
		//clientRequestPost.setFileEntity(file, "text/plain; charset=\"UTF-8\"");
		
		Object responseObject = null;
		try
		{
			responseObject = clientInvoker.getResponseObject(clientRequestPost);		
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}   
		System.out.println(responseObject);		
	}	
	
	public static void invokeServerForByteArray()
	{		
		File file = new File("conf/http.properties");
		
		HttpConfig httpConfig = HttpContext.getHttpConfig("ApacheServerObjectInvoker");
		
		ClientRequestPost clientRequestPost = new ClientRequestPost(httpConfig);
		try
		{
			clientRequestPost.setByteArrayEntity(IOUtil.write(file).toByteArray());
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}		

		Object responseObject = null;
		try
		{
			responseObject = clientInvoker.getResponseObject(clientRequestPost);		
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}   
		
		File responseFile = (File) responseObject;
		System.out.println(responseFile.getAbsoluteFile());
	}	
	
	public static void main(String[] args)
	{			
		HttpContext.register();
		
		ApachePostClientInvoker.invokeServletForParameter();		
		ApachePostClientInvoker.invokeServerForSerializable();
		ApachePostClientInvoker.invokeServerForInputStream();		
		ApachePostClientInvoker.invokeServerForString();
		ApachePostClientInvoker.invokeServerForFile();
		ApachePostClientInvoker.invokeServerForByteArray();
		
		clientInvoker.shutdown();
	}	
}