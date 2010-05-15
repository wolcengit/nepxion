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

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentProducer;
import org.apache.http.entity.EntityTemplate;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.entity.SerializableEntity;
import org.apache.http.entity.StringEntity;

import com.nepxion.util.io.IOUtil;
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
	
	public UrlEncodedFormEntity setParameterEntity(List parameterEntity)
	{
		UrlEncodedFormEntity entity = null;
		try
		{
			entity = new UrlEncodedFormEntity(parameterEntity);
			
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		entity.setChunked(true);
		setEntity(entity);
		return entity;
	}
	
	public UrlEncodedFormEntity setParameterEntity(List parameterEntity, String encoding)
	{
		UrlEncodedFormEntity entity = null;
		try
		{
			entity = new UrlEncodedFormEntity(parameterEntity, encoding);
			
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		entity.setChunked(true);
		setEntity(entity);
		return entity;
	}
		
	public SerializableEntity setSerializableEntity(Serializable serializable, boolean bufferize)
	{
		SerializableEntity entity = null;
		try
		{
			entity = new SerializableEntity(serializable, bufferize);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		entity.setChunked(true);
		setEntity(entity);
		return entity;
	}
	
	public InputStreamEntity setInputStreamEntity(InputStream inputStream)
	{
		return setInputStreamEntity(inputStream, -1);
	}
	
	public InputStreamEntity setInputStreamEntity(InputStream inputStream, long length)
	{
		InputStreamEntity entity = new InputStreamEntity(inputStream, length);
		entity.setContentType("binary/octet-stream");
		entity.setChunked(true);
		setEntity(entity);
		return entity;
	}
	
	public StringEntity setStringEntity(String text)
	{
		StringEntity entity = null;
		try
		{
			entity = new StringEntity(text);
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		entity.setChunked(true);
		setEntity(entity);		
		return entity;
	}
	
	public StringEntity setStringEntity(String text, String encoding)
	{
		StringEntity entity = null;
		try
		{
			entity = new StringEntity(text, encoding);
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		entity.setChunked(true);
		setEntity(entity);
		return entity;
	}
	
	public FileEntity setFileEntity(File file)
	{
		FileEntity entity = new FileEntity(file, "binary/octet-stream");
		entity.setChunked(true);
		setEntity(entity);
		return entity;
	}
	
	public BufferedHttpEntity setBufferedEntity(HttpEntity httpEntity)
	{
		BufferedHttpEntity entity = null;
		try
		{
			entity = new BufferedHttpEntity(httpEntity);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		setEntity(entity);
		return entity;
	}
	
	public ByteArrayEntity setByteArrayEntity(byte[] bytes)
	{
		ByteArrayEntity entity = new ByteArrayEntity(bytes);
		entity.setChunked(true);
		setEntity(entity);
		return entity;
	}
	
	public EntityTemplate setEntityTemplate(ContentProducer contentProducer)
	{
		EntityTemplate entityTemplate = new EntityTemplate(contentProducer);
		return entityTemplate;
	}
}