package com.nepxion.util.http.apache;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.util.List;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;

import com.nepxion.util.encode.EncodeContext;
import com.nepxion.util.http.HttpConfig;
import com.nepxion.util.http.IClientRequest;

public class ClientRequestGet
	extends HttpGet implements IClientRequest
{	
	private HttpConfig httpConfig;
	private String urlParameter = "";
	
	public ClientRequestGet()
	{
		super();
	}
	
	public ClientRequestGet(HttpConfig httpConfig)
	{
		super(httpConfig.toURI());
		
		this.httpConfig = httpConfig;
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
	
	public String getURLParameter()
	{
		return urlParameter;
	}
	
	public void setParameterEntity(List parameterEntity)
	{
		setParameterEntity(parameterEntity, EncodeContext.getCharset());
	}
	
	public void setParameterEntity(List parameterEntity, String charset)
	{
		String format = URLEncodedUtils.format(parameterEntity, charset);
		if (format != null)
		{	
			urlParameter = "?" + format;
		}
	}	
}