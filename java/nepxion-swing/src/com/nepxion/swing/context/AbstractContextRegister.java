package com.nepxion.swing.context;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
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
	
	public void register(String filePath, URL codeBase)
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
		
		initializeContext(properties, codeBase);
	}
}