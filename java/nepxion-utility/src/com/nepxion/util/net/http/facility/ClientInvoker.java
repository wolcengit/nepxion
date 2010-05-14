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
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

import com.nepxion.util.net.http.ClientContext;
import com.nepxion.util.net.http.IClientRequest;
import com.nepxion.util.net.http.IClientInvoker;

public class ClientInvoker
	implements IClientInvoker
{
    /**
     * The portal of invoke. If the uri is not null, it will execute the invokeRemote method, otherwise the invokeNative method
     * @param clientRequest  the instance of ClientRequest.It should be serialized
     * @return Object        the return object.It may be entity object or exception object
     * @throws Exception
     */
    public Object invoke(IClientRequest clientRequest)
    	throws Exception
    {
    	ClientContext.initialize(clientRequest);
    	
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
     * @return Object        the return object.It may be entity object or exception object
     * @throws Exception
     */
    public Object invokeRemote(IClientRequest clientRequest)
        throws Exception
    {    
    	URI uri = clientRequest.getURI();
    	if (uri == null)
    	{
    		throw new IllegalArgumentException("Invalid URL parameter for remote invoking");
    	}	
    	
        Object returnObject = null;
        try
        {
            URL url = uri.toURL();
            URLConnection connection = url.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setUseCaches(true);
            connection.setDefaultUseCaches(true);
            connection.setRequestProperty("Content-Type", "application/octet-stream");

            ObjectOutputStream oos = new ObjectOutputStream(connection.getOutputStream());
            oos.writeObject(clientRequest);
            oos.flush();
            oos.close();

            ObjectInputStream ois = new ObjectInputStream(connection.getInputStream());
            returnObject = ois.readObject();
            ois.close();
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
        
        if (returnObject instanceof Exception)
        {
            Exception e = (Exception) returnObject;
            throw e;
        }
        return returnObject;
    }

    /**
     * The invoking and alternation between Application and Servlet in the native mode
     * @param clientRequest  the instance of ClientRequest.It should be serialized
     * @return Object        the return object.It may be entity object or exception object
     * @throws Exception
     */
    public Object invokeNative(IClientRequest clientRequest)
        throws Exception
    {
        ServerInvoker serverInvoker = new ServerInvoker();
        Object returnObject = serverInvoker.invoke((ClientRequest) clientRequest);

        if (returnObject instanceof Exception)
        {
            Exception e = (Exception) returnObject;
            throw e;
        }
        return returnObject;
    }
}