package com.nepxion.util.database.pool.proxool;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.util.Properties;

import org.logicalcobwebs.proxool.ProxoolException;
import org.logicalcobwebs.proxool.configuration.PropertyConfigurator;

import com.nepxion.util.log.Logger;

public class ProxoolContext
	implements ProxoolConstants
{
	public static void register()
		throws ProxoolException
	{
		register(CONFIG_FILE_PATH);
	}
	
	public static void register(String filePath)
		throws ProxoolException
	{
		try
		{
			PropertyConfigurator.configure(filePath);
		}
		catch (ProxoolException e)
		{
			Logger.fatal(ProxoolConnectionPool.class, e);
			throw e;
		}
	}
	
	public static void register(Properties properties)
		throws ProxoolException
	{
		try
		{
			PropertyConfigurator.configure(properties);
		}
		catch (ProxoolException e)
		{
			Logger.fatal(ProxoolConnectionPool.class, e);
			throw e;
		}
	}
}