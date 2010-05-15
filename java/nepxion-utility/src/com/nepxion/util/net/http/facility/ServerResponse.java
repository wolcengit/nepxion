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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class ServerResponse
{
    private ClientRequest clientRequest;
    
    private HttpServletRequest httpServletRequest;
    private HttpServletResponse httpServletResponse;
          
    public ServerResponse()
    {    	
    }
    
    public ClientRequest getClientRequest()
    {
        return clientRequest;
    }

    public void setClientRequest(ClientRequest clientRequest)
    {
        this.clientRequest = clientRequest;
    }
    
    public HttpServletRequest getHttpServletRequest()
    {
    	return httpServletRequest;
    }
    
    public void setHttpServletRequest(HttpServletRequest httpServletRequest)
    {
    	this.httpServletRequest = httpServletRequest;
    }
    
    public HttpServletResponse getHttpServletResponse()
    {
    	return httpServletResponse;
    }
    
    public void setHttpServletResponse(HttpServletResponse httpServletResponse)
    {
    	this.httpServletResponse = httpServletResponse;
    }    

    public abstract Object execute();
}