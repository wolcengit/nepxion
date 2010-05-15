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

import java.net.URI;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;

import com.nepxion.util.net.http.ClientContext;
import com.nepxion.util.net.http.IClientInvoker;
import com.nepxion.util.net.http.IClientRequest;

public class ClientInvoker
	extends DefaultHttpClient implements IClientInvoker
{
	public Object invoke(IClientRequest clientRequest)
		throws Exception
	{
		if (clientRequest.getURI() == null)
		{
			URI uri = ClientContext.getURI();
			if (uri != null)
			{
				clientRequest.setURI(uri);
			}
		}
				
		if (clientRequest.getURI() == null)
		{
			throw new IllegalArgumentException("Invalid URL parameter for invoking");
		}
		
		if (getTimeOut() == -1)
		{
			int timeOut = ClientContext.getTimeOut();
			if (timeOut != -1)
			{
				setTimeOut(timeOut);
			}	
		}
		
		if (getConnectionTimeOut() == -1)
		{
			int connectionTimeOut = ClientContext.getConnectionTimeOut();
			if (connectionTimeOut != -1)
			{
				setConnectionTimeOut(connectionTimeOut);
			}	
		}			
		
		HttpUriRequest request = (HttpUriRequest) clientRequest;
		HttpResponse response = execute(request);
		
		getConnectionManager().shutdown();
		
		return response;
	}
	
	public int getTimeOut()
	{
		return getParams().getIntParameter(HttpConnectionParams.SO_TIMEOUT, -1);	
	}
	
	public void setTimeOut(int timeOut)
	{
		getParams().setIntParameter(HttpConnectionParams.SO_TIMEOUT, timeOut);		
	}
	
	public int getConnectionTimeOut()
	{
		return getParams().getIntParameter(HttpConnectionParams.CONNECTION_TIMEOUT, -1);	
	}	
	
	public void setConnectionTimeOut(int timeOut)
	{
		getParams().setIntParameter(HttpConnectionParams.CONNECTION_TIMEOUT, timeOut);		
	}
	
	public HttpEntity getEntity(IClientRequest clientRequest)
		throws Exception
	{
		HttpResponse response = (HttpResponse) invoke(clientRequest);
		HttpEntity entity = response.getEntity();		
		return entity;
	}
	
	public String getContent(IClientRequest clientRequest)
		throws Exception
	{
		return getContent(clientRequest, null);
	}	
	
	public String getContent(IClientRequest clientRequest, String encoding)
		throws Exception
	{
		HttpEntity entity = getEntity(clientRequest);
		String content = EntityUtils.toString(entity, encoding);		
		return content;
	}
}