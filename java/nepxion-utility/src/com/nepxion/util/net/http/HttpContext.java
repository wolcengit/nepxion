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

import java.io.FileInputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Properties;

import com.nepxion.util.log.Logger;

public class HttpContext
	implements HttpConstants
{
	private static LinkedHashMap httpConfigMap;
	
	public static void register()
		throws Exception
	{
		register(CONFIG_FILE_PATH);
	}
	
	public static void register(String filePath)
		throws Exception
	{
		Logger.info(HttpContext.class, "----- Http Context Initialization Start -----");
		
		httpConfigMap = new LinkedHashMap();
		Properties properties = new Properties();
		try
		{
			FileInputStream fis = new FileInputStream(filePath);
			properties.load(fis);
			
			parseConfig(properties);
		}
		catch (Exception e)
		{
			Logger.fatal(HttpConstants.class, e);
			throw e;
		}
		
		Logger.info(HttpContext.class, "------ Http Context Initialization End ------");
	}
	
	public static void register(Properties properties)
		throws Exception
	{
		Logger.info(HttpContext.class, "----- Http Context Initialization Start -----");
		
		try
		{
			parseConfig(properties);
		}
		catch (Exception e)
		{
			Logger.fatal(HttpConstants.class, e);
			throw e;
		}
		
		Logger.info(HttpContext.class, "------ Http Context Initialization End ------");
	}
	
	public static void register(URL codeBase)
		throws Exception
	{
		Logger.info(HttpContext.class, "----- Http Context Initialization Start -----");
		
		httpConfigMap = new LinkedHashMap();
		Properties properties = new Properties();
		try
		{
			URL url = new URL(codeBase + CONFIG_FILE_PATH);
			properties.load(url.openStream());
			
			parseConfig(properties, url);
		}
		catch (Exception e)
		{
			Logger.fatal(HttpConstants.class, e);
			throw e;
		}
		
		Logger.info(HttpContext.class, "------ Http Context Initialization End ------");
	}
	
	public static HttpConfig getDefaultHttpConfig()
	{
		return getHttpConfig(DEFAULT_ALIAS);
	}
	
	public static HttpConfig getHttpConfig(String alias)
	{
		HttpConfig httpConfig = (HttpConfig) httpConfigMap.get(alias);
		if (httpConfig == null)
		{
			throw new IllegalArgumentException("Http Config for " + alias + " hasn't been found");
		}
		return httpConfig;
	}
	
	private static void parseConfig(Properties properties)
		throws Exception
	{
		parseConfig(properties, null);
	}
	
	private static void parseConfig(Properties properties, URL url)
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
			HttpConfig config = createConfig(configProperties, url);
			httpConfigMap.put(config.getAlias(), config);
		}
		
		HttpContextLogger.log(httpConfigMap);
	}
	
	private static HttpConfig createConfig(Properties configProperties, URL url)
	{
		HttpConfig httpConfig = new HttpConfig();
		
		httpConfig.setAlias(configProperties.getProperty(ALIAS));
		if (!configProperties.getProperty(HOST).equals(""))
		{
			httpConfig.setHost(configProperties.getProperty(HOST));
		}
		else
		{
			if (url != null)
			{
				httpConfig.setHost(url.getHost());
			}
		}
		if (!configProperties.getProperty(PORT).equals(""))
		{
			httpConfig.setPort(Integer.parseInt(configProperties.getProperty(PORT)));
		}
		else
		{
			if (url != null)
			{
				httpConfig.setPort(url.getPort());
			}
		}
		httpConfig.setPath(configProperties.getProperty(PATH));
		
		httpConfig.setConnectionTimeOut(Integer.parseInt(configProperties.getProperty(CONNECTION_TIMEOUT)));
		httpConfig.setResponseTimeOut(Integer.parseInt(configProperties.getProperty(RESPONSE_TIMEOUT)));
		httpConfig.setBufferSize(Integer.parseInt(configProperties.getProperty(BUFFER_SIZE)));
		
		return httpConfig;
	}
}