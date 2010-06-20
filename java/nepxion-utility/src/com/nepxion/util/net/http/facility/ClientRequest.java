package com.nepxion.util.net.http.facility;

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
import java.util.HashMap;

import com.nepxion.util.net.http.HttpConfig;
import com.nepxion.util.net.http.IClientRequest;

public class ClientRequest
	implements IClientRequest
{
	private static final long serialVersionUID = -2619050867163898049L;
	
	private HttpConfig httpConfig;
	private URI uri;
	
	private String responseKey;
	private Class responseClass;
	
	private HashMap entity;
	
	public ClientRequest()
	{
		this((String) null);
	}
	
	public ClientRequest(HttpConfig httpConfig)
	{
		this(httpConfig, null);
	}
	
	public ClientRequest(String responseKey)
	{
		this(null, responseKey);
	}
	
	public ClientRequest(HttpConfig httpConfig, String responseKey)
	{
		this(httpConfig, responseKey, null);
	}
	
	public ClientRequest(HttpConfig httpConfig, String responseKey, Class responseClass)
	{		
		setHttpConfig(httpConfig);
		
		this.responseKey = responseKey;
		this.responseClass = responseClass;		
	}
	
	public HttpConfig getHttpConfig()
	{
		return httpConfig;
	}

	public void setHttpConfig(HttpConfig httpConfig)
	{
		this.httpConfig = httpConfig;
		
		setURI(httpConfig.toURI());
	}	
		
	public URI getURI()
	{
		return uri;
	}

	public void setURI(URI uri)
	{		
		this.uri = uri;
	}	
	
	public String getURLParameter()
	{
		return "";
	}
	
	public void abort()
	{
		
	}	
	
	public String getResponseKey()
	{
		return responseKey;
	}
	
	public void setResponseKey(String responseKey)
	{
		this.responseKey = responseKey;
	}
	
	public Class getResponseClass()
	{
		return responseClass;
	}
	
	public void setResponseClass(Class responseClass)
	{
		this.responseClass = responseClass;
	}
	
	public HashMap getEntity()
	{
		return entity;
	}
	
	public void setEntity(HashMap entity)
	{
		this.entity = entity;
	}
}