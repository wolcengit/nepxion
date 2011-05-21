package com.nepxion.util.context;

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
import java.util.Properties;

public abstract class AbstractContextRegister
	implements IContextRegister
{	
	/**
	 * Registers the context by a context file path.
	 * The context file is a native file.
	 * @param filePath the context file path
	 * @throws Exception
	 */
	public void register(String filePath)
		throws Exception
	{
		Properties properties = new Properties();
		try
		{
			FileInputStream fis = new FileInputStream(filePath);
			properties.load(fis);
			fis.close();
		}
		catch (Exception e)
		{
			throw e;
		}
		
		initializeContext(properties);
	}
	
	/**
	 * Registers the context by an url and context file path.
	 * The context file is a remote file.
	 * @param codeBase the instance of URL
	 * @param filePath the context file path
	 * @throws Exception
	 */
	public void register(URL codeBase, String filePath)
		throws Exception
	{		
		Properties properties = new Properties();
		try
		{
			URL url = new URL(codeBase + filePath);
			properties.load(url.openStream());
		}
		catch (Exception e)
		{
			throw e;
		}
		
		initializeContext(codeBase, properties);
	}
}