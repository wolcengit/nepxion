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

import java.util.ArrayList;
import java.util.List;

import org.apache.http.message.BasicNameValuePair;

import com.nepxion.util.net.http.ClientContext;
import com.nepxion.util.net.http.apache.ClientInvoker;
import com.nepxion.util.net.http.apache.ClientRequestGet;

public class ApacheGetClientInvoker
{	
	public static void invokeServletForParameter()
	{
		ClientContext.setURL("http://localhost:8080/Nepxion-Net-Demo/ApacheServlet");
				
		List list = new ArrayList();
		list.add(new BasicNameValuePair("target", "servlet"));
		list.add(new BasicNameValuePair("entity", "parameter"));
		
		ClientRequestGet clientRequestGet = new ClientRequestGet();
		clientRequestGet.setParameterEntity(list, "GBK");		
  
		ClientInvoker clientInvoker = new ClientInvoker();

		String responseText = null;
		try
		{
			responseText = clientInvoker.getResponseText(clientRequestGet);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		System.out.println(responseText);
		
		clientInvoker.close();
	}
	
	public static void main(String[] args)
	{		
		ApacheGetClientInvoker.invokeServletForParameter();
	}	
}