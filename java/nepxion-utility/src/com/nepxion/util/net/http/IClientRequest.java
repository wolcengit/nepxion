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

import java.io.Serializable;
import java.net.URI;

public interface IClientRequest
	extends Serializable
{				
	public URI getURI();
	
	public void setURI(URI uri);
	
	public void setURI(String uri);
	
	public String getURLParameter();
	
	public void abort();
}
