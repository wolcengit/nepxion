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

import com.nepxion.util.net.http.IClientRequest;

public class ClientRequest
    implements IClientRequest
{	
	private static final long serialVersionUID = -2619050867163898049L;
	
	private String responseKey;
	private Class responseClass;
	private URI uri;
	
	private HashMap entity;

    public ClientRequest()
    {
    	this((String) null);
    }
    
    public ClientRequest(URI uri)
    {
    	this(null, uri);
    }
    
    public ClientRequest(String responseKey)
    {
    	this(responseKey, null);
    }    
    
    public ClientRequest(String responseKey, URI uri)
    {
    	this(responseKey, null, uri);
    }       
    
    public ClientRequest(String responseKey, Class responseClass, URI uri)
    {
    	this.responseKey = responseKey;
    	this.responseClass = responseClass;
    	this.uri = uri;
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
    
    public URI getURI()
    {
    	return uri;
    }
    
    public void setURI(URI uri)
    {
    	this.uri = uri;
    }
    
	public void setURI(String uri)
	{
		setURI(URI.create(uri));		
	}   
	
	public HashMap getEntity()
	{
		return entity;
	}
	
	public void setEntity(HashMap entity)
	{
		this.entity = entity;
	}
	
	public String getURLParameter()
	{
		return "";
	}	
}