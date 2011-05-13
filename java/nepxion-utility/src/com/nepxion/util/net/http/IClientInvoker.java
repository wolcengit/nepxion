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

public interface IClientInvoker
	extends HttpConstants
{
	/**
	 * Invokes the web server to get the serializable object.
	 * @param clientRequest the instance of IClientRequest
	 * @return the serializable object
	 * @throws Exception
	 */
	public Object invoke(IClientRequest clientRequest)
		throws Exception;
}