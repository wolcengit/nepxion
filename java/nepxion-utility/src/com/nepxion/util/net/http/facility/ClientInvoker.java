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

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

import com.nepxion.util.io.IOUtil;
import com.nepxion.util.net.http.IClientInvoker;
import com.nepxion.util.net.http.IClientRequest;

public class ClientInvoker
	implements IClientInvoker
{
    /**
     * The portal of invoke. If the uri is not null, it will execute the invokeRemote method, otherwise the invokeNative method
     * @param clientRequest  the instance of ClientRequest.It should be serialized
     * @return               the return object.It may be entity object or exception object
     * @throws               Exception
     */
    public Object invoke(IClientRequest clientRequest)
    	throws Exception
    {    	
    	if (clientRequest.getURI() != null)
    	{
    		return invokeRemote(clientRequest);
    	}	
    	else
    	{
    		return invokeNative(clientRequest);
    	}
    }
    
    /**
     * The invoking and alternation between client(Application & Applet) and Servlet in the remote mode
     * @param clientRequest  the instance of ClientRequest.It should be serialized
     * @return               the return object.It may be entity object or exception object
     * @throws               Exception
     */
    public Object invokeRemote(IClientRequest clientRequest)
        throws Exception
    {    
    	URI uri = clientRequest.getURI();
    	if (uri == null)
    	{
    		throw new IllegalArgumentException("Invalid URL parameter for invoking");
    	}	
    	
        Object responseObject = null;
        try
        {
            URL url = uri.toURL();
            URLConnection connection = url.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setUseCaches(true);
            connection.setDefaultUseCaches(true);
            connection.setRequestProperty("Content-Type", "application/octet-stream"); // application/x-java-serialized-object
                        
            IOUtil.write(connection.getOutputStream(), clientRequest);
            
            responseObject = IOUtil.read(connection.getInputStream());
        }
        catch (ClassNotFoundException e)
        {
        	throw new IllegalArgumentException("Invalid connection request exception for " + uri, e);
        }
        catch (MalformedURLException e)
        {
        	throw new IllegalArgumentException("Invalid connection request exception for " + uri, e);
        }
        catch (IOException e)
        {
        	throw new IllegalArgumentException("Invalid connection request exception for " + uri, e);
        }
        
        if (responseObject instanceof Exception)
        {
            Exception e = (Exception) responseObject;
            throw e;
        }
        return responseObject;
    }

    /**
     * The invoking and alternation between Application and Servlet in the native mode
     * @param clientRequest  the instance of ClientRequest.It should be serialized
     * @return               the return object.It may be entity object or exception object
     * @throws               Exception
     */
    public Object invokeNative(IClientRequest clientRequest)
        throws Exception
    {
        ServerInvoker serverInvoker = new ServerInvoker();
        Object responseObject = serverInvoker.invoke((ClientRequest) clientRequest, null, null);

        if (responseObject instanceof Exception)
        {
            Exception e = (Exception) responseObject;
            throw e;
        }
        return responseObject;
    }
}