package com.nepxion.util.searcher.ip.zone;

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
import java.net.URL;

import org.dom4j.Document;

import com.nepxion.util.log.Logger;
import com.nepxion.util.xml.dom4j.Dom4JReader;

public class ZoneContext
	implements ZoneConstants
{
	private static Document document;
	
	public static void register()
		throws Exception
	{
		register(CONFIG_FILE_PATH);
	}
	
	public static void register(String filePath)
		throws Exception	
	{
		try
		{
			document = Dom4JReader.getDocument(new File(filePath));
		}
		catch (Exception e)
		{
			Logger.fatal(ZoneContext.class, e);
			throw e;
		}
	}
	
	public static void register(URL codeBaseURL)
		throws Exception
	{
		try
		{
			URL url = new URL(codeBaseURL + CONFIG_FILE_PATH);
			
			document = Dom4JReader.getDocument(url.openStream());
		}
		catch (Exception e)
		{
			Logger.fatal(ZoneContext.class, e);
			throw e;
		}
	}
	
	public static Document getDocument()
	{
		return document;
	}
}