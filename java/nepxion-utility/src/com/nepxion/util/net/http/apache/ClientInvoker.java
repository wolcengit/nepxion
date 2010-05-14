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

import java.io.InputStream;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;

import com.nepxion.util.io.FileUtil;
import com.nepxion.util.net.http.ClientContext;
import com.nepxion.util.net.http.IClientInvoker;
import com.nepxion.util.net.http.IClientRequest;

public class ClientInvoker
	extends DefaultHttpClient implements IClientInvoker
{
	public Object invoke(IClientRequest clientRequest)
		throws Exception
	{
		ClientContext.initialize(clientRequest);
		
		if (clientRequest.getURI() == null)
		{
			throw new IllegalArgumentException("Invalid URI parameter for remote invoking");
		}
		
		HttpUriRequest request = (HttpUriRequest) clientRequest;
		HttpResponse response = execute(request);
		
		getConnectionManager().shutdown();
		
		return response;
	}
	
	public HttpResponse getResponse(IClientRequest clientRequest)
		throws Exception
	{
		HttpResponse response = (HttpResponse) invoke(clientRequest);
		return response;
	}
	
	public String getResponseContent(IClientRequest clientRequest, String encoding)
		throws Exception	
	{
		HttpResponse response = getResponse(clientRequest);
		
		InputStream inputStream = response.getEntity().getContent();
		String content = FileUtil.transfer(inputStream, encoding);
		return content;		
	}
}