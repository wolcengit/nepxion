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

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class ClientInvoker
{
    public static URL codeBase;
    public static String module;

    /**
     * Register servlet path
     * @param newCodeBase  applet codeBase
     * @param newModule    web module
     */
    public static void registerServletPath(URL newCodeBase, String newModule)
    {
        codeBase = newCodeBase;
        module = newModule;
    }

    /**
     * The portal of invoke.If codeBase and module are all not null,it will invoke in applet mode, otherwise in application mode
     * @param invokerHandle  the handle of InvokerAction.It should be serialized
     * @return Object        the return object.It may be entity object or exception object
     */
    public static Object invoke(InvokerHandle invokerHandle)
        throws Exception
    {
        try
        {
            if (codeBase != null && module != null)
            {
                return ClientInvoker.invokeApplet(codeBase, module, invokerHandle);
            }
            else
            {
                return ClientInvoker.invokeAppliciton(invokerHandle);
            }
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    /**
     * The invoking and alternation between applet and servlet 
     * @param codeBase       applet codeBase
     * @param module         web module
     * @param invokerHandle  the handle of InvokerAction.It should be serialized
     * @return Object        the return object.It may be entity object or exception object
     * @throws Exception
     */
    public static Object invokeApplet(URL codeBase, String module, InvokerHandle invokerHandle)
        throws Exception
    {
        String servletAbsolutePath = "http://" + codeBase.getHost() + ":" + codeBase.getPort() + module + "/Servlet.ServerInvoker";
        Object returnObject = null;
        try
        {
            URL url = new URL(servletAbsolutePath);
            URLConnection connection = url.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setUseCaches(true);
            connection.setDefaultUseCaches(true);
            connection.setRequestProperty("Content-Type", "application/octet-stream");

            ObjectOutputStream oos = new ObjectOutputStream(connection.getOutputStream());
            oos.writeObject(invokerHandle);
            oos.flush();
            oos.close();

            ObjectInputStream ois = new ObjectInputStream(connection.getInputStream());
            returnObject = ois.readObject();
            ois.close();
        }
        catch (ClassNotFoundException e)
        {
        	throw new Exception("Invalid connection request exception for " + servletAbsolutePath, e);
        }
        catch (MalformedURLException e)
        {
        	throw new Exception("Invalid connection request exception for " + servletAbsolutePath, e);
        }
        catch (IOException e)
        {
        	throw new Exception("Invalid connection request exception for " + servletAbsolutePath, e);
        }
        if (returnObject instanceof Exception)
        {
            Exception e = (Exception) returnObject;
            throw e;
        }
        return returnObject;
    }

    /**
     * The invoking and alternation between application and servlet 
     * @param invokerHandle  the handle of InvokerAction.It should be serialized
     * @return Object        the return object.It may be entity object or exception object
     */
    public static Object invokeAppliciton(InvokerHandle invokerHandle)
        throws Exception
    {
        ServerInvoker serverInvoker = new ServerInvoker();
        Object returnObject = serverInvoker.invoke(invokerHandle);

        if (returnObject instanceof Exception)
        {
            Exception e = (Exception) returnObject;
            throw e;
        }
        return returnObject;
    }
}