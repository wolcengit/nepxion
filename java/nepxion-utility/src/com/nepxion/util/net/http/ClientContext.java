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
import java.net.URI;
import java.net.URL;
import java.util.Properties;

public class ClientContext
{
    public static final String CONFIG_PATH = "conf/config.properties";
    
    public static final String HOST = "Host";
    public static final String PORT = "Port";
    public static final String PATH = "Path";
    public static final String TIMEOUT = "TimeOut";
    public static final String CONNECTION_TIMEOUT = "CollectionTimeOut";
    
	private static String host;
	private static int port = 0;
	private static String path;
	private static int timeOut = -1;
	private static int connectionTimeOut = -1;
	
	private static URI uri;
	
	public static void initialize()
	{
		initialize(CONFIG_PATH);
	}
	
	public static void initialize(String filePath)
	{
		initialize(new File(filePath));
	}
	
    public static void initialize(File file)
    {
        Properties properties = new Properties();
        try
        {
        	FileInputStream fis = new FileInputStream(file);
            properties.load(fis);
            
            host = properties.getProperty(HOST);
            port = Integer.parseInt(properties.getProperty(PORT));
            path = properties.getProperty(PATH);
            timeOut = Integer.parseInt(properties.getProperty(TIMEOUT));
            connectionTimeOut = Integer.parseInt(properties.getProperty(CONNECTION_TIMEOUT));
            
            uri = createURI(host, port, path);            
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
            path = properties.getProperty(PATH);
            timeOut = Integer.parseInt(properties.getProperty(TIMEOUT));
            connectionTimeOut = Integer.parseInt(properties.getProperty(CONNECTION_TIMEOUT));            
            
            uri = createURI(host, port, path);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }    	
    }
    
    public static URI createURI(String host, int port, String path)
    {
    	if (host != null && port != 0 && path != null)
    	{    		
    		String url = "http://" + host + ":" + port + path;
    		return URI.create(url);
    	}      	
    	return null;
    }
    
	public static String getHost()
	{
		return host;
	}
	
	public static void setHost(String value)
	{
		host = value;
	}
	
	public static int getPort()
	{
		return port;
	}
	
	public static void setPort(int value)
	{
		port = value;
	}
	
	public static String getPath()
	{
		return path;
	}
	
	public static void setPath(String value)
	{
		path = value;
	}
	
	public static int getTimeOut()
	{
		return timeOut;
	}
	
	public static void setTimeOut(int value)
	{
		timeOut = value;
	}
	
	public static int getConnectionTimeOut()
	{
		return connectionTimeOut;
	}
	
	public static void setConnectionTimeOut(int value)
	{
		connectionTimeOut = value;
	}	
	
	public static URI getURI()
	{  
		return uri;
	}
	
	public static void setURI(URI value)
	{
		uri = value;
	}
	
	public static void setURI(String value)
	{
		uri = URI.create(value);
	}	
}