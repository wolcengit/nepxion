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

import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicNameValuePair;

import com.nepxion.util.encode.EncodeContext;
import com.nepxion.util.io.IOUtil;
import com.nepxion.util.net.http.ClientContext;
import com.nepxion.util.net.http.apache.ClientInvoker;
import com.nepxion.util.net.http.apache.ClientRequestPost;

public class ApachePostClientInvoker
{	
	private static ClientInvoker clientInvoker = new ClientInvoker();
	
	public static void invokeServletForParameter()
	{
		ClientContext.registerURL("http://localhost:8080/Nepxion-Net-Demo/ApacheServlet");
		EncodeContext.registerCharset("GB2312");
				
		List entity = new ArrayList();
		entity.add(new BasicNameValuePair("target", "服务调用"));
		entity.add(new BasicNameValuePair("entity", "参数"));
		
		ClientRequestPost clientRequestPost = new ClientRequestPost();
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
		ClientContext.registerURL("http://localhost:8080/Nepxion-Net-Demo/ApacheServerObjectInvoker");
		
		HashMap map = new HashMap();
		map.put("target", "服务调用");
		map.put("entity", "序列化");
		
		ClientRequestPost clientRequestPost = new ClientRequestPost();
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
		ClientContext.registerURL("http://localhost:8080/Nepxion-Net-Demo/ApacheServerObjectInvoker");
		
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
		
		ClientRequestPost clientRequestPost = new ClientRequestPost();
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
		ClientContext.registerURL("http://localhost:8080/Nepxion-Net-Demo/ApacheServerStringInvoker");
		EncodeContext.registerCharset("GB2312");
		
		String text = "[目标为服务调用，实体对字符串]";
		
		ClientRequestPost clientRequestPost = new ClientRequestPost();
		StringEntity entity = clientRequestPost.setStringEntity(text);		
		
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
		ClientContext.registerURL("http://localhost:8080/Nepxion-Net-Demo/ApacheServerStringInvoker");
		
		File file = new File("conf/config.properties");
		
		ClientRequestPost clientRequestPost = new ClientRequestPost();
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
		ClientContext.registerURL("http://localhost:8080/Nepxion-Net-Demo/ApacheServerObjectInvoker");
		
		File file = new File("conf/config.properties");
		
		ClientRequestPost clientRequestPost = new ClientRequestPost();
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
		ApachePostClientInvoker.invokeServletForParameter();		
		ApachePostClientInvoker.invokeServerForSerializable();
		ApachePostClientInvoker.invokeServerForInputStream();		
		ApachePostClientInvoker.invokeServerForString();
		ApachePostClientInvoker.invokeServerForFile();
		ApachePostClientInvoker.invokeServerForByteArray();
		
		clientInvoker.shutdown();
	}	
}