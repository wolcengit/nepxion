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
import java.net.URL;
import java.net.URLConnection;

import com.nepxion.util.net.http.ClientEnvironment;
import com.nepxion.util.net.http.IClientHandle;
import com.nepxion.util.net.http.IClientInvoker;

public class ClientInvoker
	implements IClientInvoker
{
    /**
     * The portal of invoke. If the remotePath is not null, it will execute the invokeRemote method, otherwise the invokeNative method
     * @param clientHandle  the handle of ServerAction.It should be serialized
     * @return Object       the return object.It may be entity object or exception object
     * @throws Exception
     */
    public Object invoke(IClientHandle clientHandle)
    	throws Exception
    {
    	String remotePath = null;
    	
    	String host = ClientEnvironment.getHost();
    	int port = ClientEnvironment.getPort();
    	String servlet = ClientEnvironment.getServlet();
    	
    	if (host == null || port == 0 || servlet == null)
    	{
    		remotePath = "http://" + host + ":" + port + servlet;    			
    	}
    	
    	if (remotePath != null)
    	{
    		return invokeRemote(clientHandle, remotePath);
    	}	
    	else
    	{
    		return invokeNative(clientHandle);
    	}
    }
    
    /**
     * The invoking and alternation between client(Application & Applet) and Servlet in the remote mode
     * @param clientHandle  the handle of ServerAction.It should be serialized
     * @return Object       the return object.It may be entity object or exception object
     * @throws Exception
     */
    public Object invokeRemote(IClientHandle clientHandle, String remotePath)
        throws Exception
    {    	
    	if (remotePath == null)
    	{
    		throw new IllegalArgumentException("Invalid URL parameter for remote invoking");
    	}	
    	
        Object returnObject = null;
        try
        {
            URL url = new URL(remotePath);
            URLConnection connection = url.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setUseCaches(true);
            connection.setDefaultUseCaches(true);
            connection.setRequestProperty("Content-Type", "application/octet-stream");

            ObjectOutputStream oos = new ObjectOutputStream(connection.getOutputStream());
            oos.writeObject(clientHandle);
            oos.flush();
            oos.close();

            ObjectInputStream ois = new ObjectInputStream(connection.getInputStream());
            returnObject = ois.readObject();
            ois.close();
        }
        catch (ClassNotFoundException e)
        {
        	throw new IllegalArgumentException("Invalid connection request exception for " + remotePath, e);
        }
        catch (MalformedURLException e)
        {
        	throw new IllegalArgumentException("Invalid connection request exception for " + remotePath, e);
        }
        catch (IOException e)
        {
        	throw new IllegalArgumentException("Invalid connection request exception for " + remotePath, e);
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
     * @param clientHandle  the handle of ServerAction.It should be serialized
     * @return Object       the return object.It may be entity object or exception object
     * @throws Exception
     */
    public Object invokeNative(IClientHandle clientHandle)
        throws Exception
    {
        ServerInvoker serverInvoker = new ServerInvoker();
        Object returnObject = serverInvoker.invoke((ClientHandle) clientHandle);

        if (returnObject instanceof Exception)
        {
            Exception e = (Exception) returnObject;
            throw e;
        }
        return returnObject;
    }
}