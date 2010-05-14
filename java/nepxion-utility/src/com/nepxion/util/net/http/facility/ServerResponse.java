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

public abstract class ServerResponse
{
    private ClientRequest clientRequest;
    
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

    public abstract Object execute();
}