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

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.List;

import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;

import com.nepxion.util.net.http.IClientRequest;

public class ClientRequestPost
	extends HttpPost implements IClientRequest
{
	public ClientRequestPost()
	{
		super();
	}
	
	public ClientRequestPost(URI uri)
	{
		super(uri);
	}
	
	public ClientRequestPost(String uri)
	{
		super();
	}
	
	public void setURI(String uri)
	{
		setURI(URI.create(uri));		
	}	
	
	public void setEntity(List entity, String encoding)
	{
		try
		{
			setEntity(new UrlEncodedFormEntity(entity, encoding));
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
	}	
	
	public void setEntity(List entity)
	{
		try
		{
			setEntity(new UrlEncodedFormEntity(entity));
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
	}	
}