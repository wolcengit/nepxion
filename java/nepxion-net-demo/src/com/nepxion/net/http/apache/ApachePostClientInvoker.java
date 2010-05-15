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
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.message.BasicNameValuePair;

import com.nepxion.util.io.IOUtil;
import com.nepxion.util.net.http.ClientContext;
import com.nepxion.util.net.http.apache.ClientInvoker;
import com.nepxion.util.net.http.apache.ClientRequestPost;

public class ApachePostClientInvoker
{	
	public static void invokeServletForParameter()
	{
		ClientContext.setURL("http://localhost:8080/Nepxion-Net-Demo/ApacheServlet");
				
		List entity = new ArrayList();
		entity.add(new BasicNameValuePair("target", "servlet"));
		entity.add(new BasicNameValuePair("entity", "parameter"));
		
		ClientRequestPost clientRequestPost = new ClientRequestPost();
		clientRequestPost.setParameterEntity(entity, "GBK");
  
		ClientInvoker clientInvoker = new ClientInvoker();

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
		ClientContext.setURL("http://localhost:8080/Nepxion-Net-Demo/ApacheServerInvoker");
		
		HashMap map = new HashMap();
		map.put("target", "server");
		map.put("entity", "serializable");
		
		ClientRequestPost clientRequestPost = new ClientRequestPost();
		clientRequestPost.setSerializableEntity(map, false);
  
		ClientInvoker clientInvoker = new ClientInvoker();			

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
		ClientContext.setURL("http://localhost:8080/Nepxion-Net-Demo/ApacheServerInvoker");
		
		List list = new ArrayList();
		list.add("server");
		list.add("inputStream");
		
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
  
		ClientInvoker clientInvoker = new ClientInvoker();			

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
		ClientContext.setURL("http://localhost:8080/Nepxion-Net-Demo/ApacheServerInvoker");
		
		String text = "the target is server, the entity is string";
		
		ClientRequestPost clientRequestPost = new ClientRequestPost();
		clientRequestPost.setStringEntity(text);
  
		ClientInvoker clientInvoker = new ClientInvoker();			

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
	
	public static void main(String[] args)
	{				
		ApachePostClientInvoker.invokeServletForParameter();
		ApachePostClientInvoker.invokeServerForSerializable();
		ApachePostClientInvoker.invokeServerForInputStream();
		ApachePostClientInvoker.invokeServerForString();
	}	
}