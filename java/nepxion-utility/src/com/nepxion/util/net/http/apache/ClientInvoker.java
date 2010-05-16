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

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;

import com.nepxion.util.encode.EncodeContext;
import com.nepxion.util.io.IOUtil;
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
			String url = ClientContext.getURL();
			if (url != null)
			{
				// If the method is HttpGet, the URLParameter is ""
				clientRequest.setURI(url + clientRequest.getURLParameter());
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
		HttpResponse response = null;
		try
		{
			response = execute(request);
		}
		catch (ClientProtocolException e)
		{
			request.abort();
			e.printStackTrace();
			throw e;
		}
		catch (IOException e)
		{
			request.abort();
			e.printStackTrace();
			throw e;			
		}		
		return response;
	}
	
	public HttpEntity getResponseEntity(IClientRequest clientRequest)
		throws Exception
	{
		HttpResponse response = (HttpResponse) invoke(clientRequest);
		HttpEntity entity = response.getEntity();
		return entity;
	}
	
	public Object getResponseObject(IClientRequest clientRequest)
		throws Exception
	{
		HttpEntity entity = getResponseEntity(clientRequest);
		Object object = IOUtil.read(entity.getContent());
		entity.consumeContent();
		clientRequest.abort();
		return object;
	}
	
	public String getResponseText(IClientRequest clientRequest)
		throws Exception
	{
		return getResponseText(clientRequest, EncodeContext.getCharset());
	}
	
	public String getResponseText(IClientRequest clientRequest, String charset)
		throws Exception
	{
		HttpEntity entity = getResponseEntity(clientRequest);
		String text = IOUtil.getString(entity.getContent(), charset);
		entity.consumeContent();
		clientRequest.abort();
		return text;
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
	
	public void shutdown()
	{
		getConnectionManager().shutdown();
	}
}