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
    
    public static final String TAG_HOST = "Host";
    public static final String TAG_PORT = "Port";
    public static final String TAG_PATH = "Path";
    
	private static String host;
	private static int port = 0;
	private static String path;
	
	private static URI uri;
	
	public static void initialize(IClientRequest clientRequest)
	{
		if (clientRequest.getURI() == null)
		{
			URI uri = ClientContext.getURI();
			if (uri != null)
			{
				clientRequest.setURI(uri);
			}
		}		
	}	
	
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
            
            host = properties.getProperty(TAG_HOST);
            port = Integer.parseInt(properties.getProperty(TAG_PORT));
            path = properties.getProperty(TAG_PATH);
            
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
            path = properties.getProperty(TAG_PATH);
            
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