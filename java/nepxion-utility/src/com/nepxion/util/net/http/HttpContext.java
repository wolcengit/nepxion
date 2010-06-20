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
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Properties;

public class HttpContext
	implements HttpConstants
{
	public static final String HTTP_CONFIG_FILE_PATH = "conf/http.properties";
	
	public static final String PREFIX = "http";
	public static final String DOT = ".";
	
	private static LinkedHashMap httpConfigMap;
	
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
		httpConfigMap = new LinkedHashMap();
		Properties properties = new Properties();
		try
		{
			FileInputStream fis = new FileInputStream(file);
			properties.load(fis);
			
			parseConfig(properties);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void register(URL codeBaseURL)
	{
		httpConfigMap = new LinkedHashMap();
		Properties properties = new Properties();
		try
		{
			codeBaseURL = new URL(codeBaseURL + HTTP_CONFIG_FILE_PATH);
			properties.load(codeBaseURL.openStream());
			
			parseConfig(properties, codeBaseURL);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static HttpConfig getHttpConfig(String alias)
	{
		return (HttpConfig) httpConfigMap.get(alias);
	}
	
	private static void parseConfig(Properties properties)
		throws Exception
	{
		parseConfig(properties, null);
	}
	
	private static void parseConfig(Properties properties, URL codeBaseURL)
		throws Exception
	{
		HashMap propertiesMap = new HashMap();
		for (Iterator iterator = properties.keySet().iterator(); iterator.hasNext();)
		{
			String key = (String) iterator.next();
			String value = properties.getProperty(key);
			
			if (key.startsWith(PREFIX))
			{
				int index = key.indexOf(DOT);
				if (index == -1)
				{
					throw new Exception("Property " + key + " must be of the format " + PREFIX + "*" + DOT + "*");
				}
                String prefix = key.substring(0, index);
                String name = key.substring(index + 1);
                Properties configProperties = (Properties) propertiesMap.get(prefix);
				if (configProperties == null)
				{
					configProperties = new Properties();
					propertiesMap.put(prefix, configProperties);
				}
				configProperties.put(name, value);
			}
		}
		
		for (Iterator iterator = propertiesMap.keySet().iterator(); iterator.hasNext();)
		{
			String key = (String) iterator.next();
			Properties configProperties = (Properties) propertiesMap.get(key);
			HttpConfig config = createConfig(configProperties, codeBaseURL);
			httpConfigMap.put(config.getAlias(), config);
		}	
	}
	
	private static HttpConfig createConfig(Properties configProperties, URL codeBaseURL)
	{
		HttpConfig httpConfig = new HttpConfig();
		
		httpConfig.setAlias(configProperties.getProperty(ALIAS));
		if (!configProperties.getProperty(HOST).equals(""))
		{
			httpConfig.setHost(configProperties.getProperty(HOST));
		}
		else
		{
			if (codeBaseURL != null)
			{
				httpConfig.setHost(codeBaseURL.getHost());
			}
		}
		if (!configProperties.getProperty(PORT).equals(""))
		{
			httpConfig.setPort(Integer.parseInt(configProperties.getProperty(PORT)));
		}
		else
		{
			if (codeBaseURL != null)
			{
				httpConfig.setPort(codeBaseURL.getPort());
			}
		}
		httpConfig.setPath(configProperties.getProperty(PATH));
		
		httpConfig.setConnectionTimeOut(Integer.parseInt(configProperties.getProperty(CONNECTION_TIMEOUT)));
		httpConfig.setResponseTimeOut(Integer.parseInt(configProperties.getProperty(RESPONSE_TIMEOUT)));
		httpConfig.setBufferSize(Integer.parseInt(configProperties.getProperty(BUFFER_SIZE)));
		
		return httpConfig;
	}
}