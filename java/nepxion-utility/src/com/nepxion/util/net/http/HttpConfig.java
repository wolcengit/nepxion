package com.nepxion.util.net.http;

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

public class HttpConfig
	implements HttpConstants
{
	private static final long serialVersionUID = -7078182861655615084L;

	private String alias;
	private String host;
	private int port = 0;
	private String path;
	private int connectionTimeOut = DEFAULT_CONNECTION_TIMEOUT;
	private int responseTimeOut = DEFAULT_RESPONSE_TIMEOUT;
	private int bufferSize = DEFAULT_BUFFER_SIZE;
	
	public HttpConfig()
	{
		
	}
	
	public String getAlias()
	{
		return alias;
	}
	
	public void setAlias(String alias)
	{
		this.alias = alias;
	}
	
	public String getHost()
	{
		return host;
	}
	
	public void setHost(String host)
	{
		this.host = host;
	}
	
	public int getPort()
	{
		return port;
	}
	
	public void setPort(int port)
	{
		this.port = port;
	}
	
	public String getPath()
	{
		return path;
	}
	
	public void setPath(String path)
	{
		this.path = path;
	}
	
	public int getConnectionTimeOut()
	{
		return connectionTimeOut;
	}
	
	public void setConnectionTimeOut(int connectionTimeOut)
	{
		this.connectionTimeOut = connectionTimeOut;
	}
	
	public int getResponseTimeOut()
	{
		return responseTimeOut;
	}
	
	public void setResponseTimeOut(int responseTimeOut)
	{
		this.responseTimeOut = responseTimeOut;
	}
	
	public int getBufferSize()
	{
		return bufferSize;
	}
	
	public void setBufferSize(int bufferSize)
	{
		this.bufferSize = bufferSize;
	}
	
	public String toURL()
	{
		if (host != null && port != 0 && path != null)
		{
			return "http://" + host + ":" + port + path;
		}
		return null;
	}
	
	public URI toURI()
	{
		String url = toURL();
		if (url != null)
		{
			return URI.create(url);
		}
		return null;
	}
}