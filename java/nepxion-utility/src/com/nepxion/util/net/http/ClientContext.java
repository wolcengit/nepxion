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
    public static final String HTTP_CONFIG_FILE_PATH = "conf/http.properties";
    
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
	
	private static String url;
	
	public static void register()
	{
		register(HTTP_CONFIG_FILE_PATH);
	}
	
	public static void register(String filePath)
	{
		register(new File(filePath));
	}
	
    public static void register(File file)
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
            
            url = createURL(host, port, path);            
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }    	
    }
    
    public static void register(URL codeBaseURL)
    {
        Properties properties = new Properties();
        try
        {
        	codeBaseURL = new URL(codeBaseURL + HTTP_CONFIG_FILE_PATH);
            properties.load(codeBaseURL.openStream());
            
            if (properties.getProperty(HOST) != null && !properties.getProperty(HOST).equals(""))
            {
            	host = properties.getProperty(HOST);
            }
            else
            {
            	host = codeBaseURL.getHost();
            }
            
            if (properties.getProperty(PORT) != null && !properties.getProperty(PORT).equals(""))
            {
            	port = Integer.parseInt(properties.getProperty(PORT));
            }
            else
            {
            	port = codeBaseURL.getPort();
            }
            
            path = properties.getProperty(PATH);
            timeOut = Integer.parseInt(properties.getProperty(TIMEOUT));
            connectionTimeOut = Integer.parseInt(properties.getProperty(CONNECTION_TIMEOUT));            
            
            url = createURL(host, port, path);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }    	
    }
    
    public static String createURL(String host, int port, String path)
    {
    	if (host != null && port != 0 && path != null)
    	{    		
    		return "http://" + host + ":" + port + path;
    	}      	
    	return null; 	
    }
    
    public static URI createURI(String host, int port, String path)
    {
    	String url = createURL(host, port, path);
    	if (url != null)
    	{    		
    		return URI.create(url);
    	}      	
    	return null;
    }
    
	public static void registerHost(String value)
	{
		host = value;
	}
	
	public static String getHost()
	{
		return host;
	}
	
	public static void registerPort(int value)
	{
		port = value;
	}
	
	public static int getPort()
	{
		return port;
	}
	
	public static void registertPath(String value)
	{
		path = value;
	}
	
	public static String getPath()
	{
		return path;
	}
	
	public static void registerTimeOut(int value)
	{
		timeOut = value;
	}
	
	public static int getTimeOut()
	{
		return timeOut;
	}
	
	public static void registerConnectionTimeOut(int value)
	{
		connectionTimeOut = value;
	}
	
	public static int getConnectionTimeOut()
	{
		return connectionTimeOut;
	}	
	
	public static void registerURL(String value)
	{
		url = value;
	}	
	
	public static String getURL()
	{  
		return url;
	}
}