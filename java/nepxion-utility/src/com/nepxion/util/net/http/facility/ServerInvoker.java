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

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServerInvoker
    extends HttpServlet
{
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        ClientHandle clientHandle = null;
        try
        {
            ObjectInputStream ois = new ObjectInputStream(request.getInputStream());
            clientHandle = (ClientHandle) ois.readObject();
            ois.close();

            Object returnObject = invoke(clientHandle);
            ObjectOutputStream oos = new ObjectOutputStream(response.getOutputStream());
            oos.writeObject(returnObject);
            oos.flush();
            oos.close();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    public Object invoke(ClientHandle clientHandle)
    {
        Class actionClass = clientHandle.getActionClass();
        ServerAction serverAction = null;
        try
        {
        	serverAction = (ServerAction) actionClass.newInstance();
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
        catch (InstantiationException e)
        {
            e.printStackTrace();
        }
        serverAction.setClientHandle(clientHandle);
        return serverAction.execute();
    }
}