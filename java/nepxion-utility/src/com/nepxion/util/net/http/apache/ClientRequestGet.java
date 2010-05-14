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

import org.apache.http.client.methods.HttpGet;

import com.nepxion.util.net.http.IClientRequest;

public class ClientRequestGet
	extends HttpGet implements IClientRequest
{	
	public ClientRequestGet()
	{
		super();
	}
	
	public ClientRequestGet(URI uri)
	{
		super(uri);
	}
	
	public ClientRequestGet(String uri)
	{
		super();
	}
	
	public void setURI(String uri)
	{
		setURI(URI.create(uri));
	}
}