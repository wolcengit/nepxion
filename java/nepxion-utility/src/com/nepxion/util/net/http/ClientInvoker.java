package com.nepxion.util.net.http;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune 任浩军
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.net.*;
import java.io.*;

public class ClientInvoker
{
    public static URL codeBase;
    public static String module;

    /**
     * 注册Servlet的路径
     * @param newCodeBase URL   Applet CodeBase
     * @param newModule String  Web Module
     */
    public static void registerServletPath(URL newCodeBase, String newModule)
    {
        codeBase = newCodeBase;
        module = newModule;
    }

    /**
     * 调用入口
     * @param invokerHandle InvokerHandle  InvokerAction的句柄，该类必须被序列化过
     * @return Object                      返回对象
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
        catch (Exception ex)
        {
            throw ex;
        }
    }

    /**
     * 实现Applet向Servlet调用数据的功能，通过Http流的方式
     * @param codeBase URL                 Applet CodeBase
     * @param module String                Web Module
     * @param InvokerHandle invokerHandle  InvokerAction的句柄，该类必须被序列化过
     * @return Object                      返回调用结果(实体类或异常类)
     * @throws Exception                   异常信息
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
            connection.setDoInput(true); //允许数据流输入
            connection.setDoOutput(true); //允许数据流输出;
            connection.setUseCaches(true); //本次连接启动缓存
            connection.setDefaultUseCaches(true); //下次连接启动缓存
            connection.setRequestProperty("Content-Type", "application/octet-stream");

            ObjectOutputStream oos = new ObjectOutputStream(connection.getOutputStream());
            oos.writeObject(invokerHandle);
            oos.flush();
            oos.close();

            ObjectInputStream ois = new ObjectInputStream(connection.getInputStream());
            returnObject = ois.readObject();
            ois.close();
        }
        catch (ClassNotFoundException ex)
        {
            Exception e = new Exception("请求连接服务 " + servletAbsolutePath + " 异常", ex);
            throw e;
        }
        catch (MalformedURLException ex)
        {
            Exception e = new Exception("请求连接服务 " + servletAbsolutePath + " 异常", ex);
            throw e;
        }
        catch (IOException ex)
        {
            Exception e = new Exception("请求连接服务 " + servletAbsolutePath + " 异常", ex);
            throw e;
        }
        if (returnObject instanceof Exception)
        {
            Exception e = (Exception) returnObject;
            throw e;
        }
        return returnObject;
    }

    /**
     * 实现Application向Servlet调用数据的功能
     * @param InvokerHandle invokerHandle  InvokerAction的句柄，该类必须被序列化过
     * @return Object                      返回调用结果(实体类或异常类)
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