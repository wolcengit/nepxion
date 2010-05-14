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
import com.nepxion.util.net.http.apache.ClientRequestPost;

public class ApacheInvoker
{	
	public static void main(String[] args)
	{		
		ClientContext.setURI("http://localhost:8080/Nepxion-Net-Demo/ApacheXmlServlet");
				
		List entity = new ArrayList();
		entity.add(new BasicNameValuePair("name", "nepxion"));
		entity.add(new BasicNameValuePair("value", "хн╨ф╬Э"));
		
		ClientRequestPost clientRequestPost = new ClientRequestPost();
		clientRequestPost.setEntity(entity, "GBK");
  
		ClientInvoker clientInvoker = new ClientInvoker();

		String responseContent = null;
		try
		{
			responseContent = clientInvoker.getResponseContent(clientRequestPost, "GBK");			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		System.out.println(responseContent);
	}	
}