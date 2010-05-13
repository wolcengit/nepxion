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

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class ClientEnvironment
{
    public static final String CONFIG_PATH = "conf/config.properties";
    
    public static final String TAG_HOST = "host";
    public static final String TAG_PORT = "port";
    public static final String TAG_SERVLET = "servlet";
    
	private static String host;
	private static int port = 0;
	private static String servlet;
        
    public static void initialize(File file)
    {
        Properties properties = new Properties();
        try
        {
        	FileInputStream fis = new FileInputStream(file);
            properties.load(fis);
            
            host = properties.getProperty(TAG_HOST);
            port = Integer.parseInt(properties.getProperty(TAG_PORT));
            servlet = properties.getProperty(TAG_SERVLET);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }    	
    }
    
    public static void initialize(URL url)
    {
        Properties properties = new Properties();
        try
        {
        	URL filePath = new URL(url + CONFIG_PATH);
            properties.load(filePath.openStream());
            
            host = url.getHost();
            port = url.getPort();
            servlet = properties.getProperty(TAG_SERVLET);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }    	
    }
    
	public static String getHost()
	{
		return host;
	}
	
	public static int getPort()
	{
		return port;
	}
	
	public static String getServlet()
	{
		return servlet;
	}	
}