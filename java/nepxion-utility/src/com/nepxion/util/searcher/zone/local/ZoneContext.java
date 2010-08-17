package com.nepxion.util.searcher.zone.local;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.io.InputStream;
import java.net.URL;

import com.nepxion.util.io.FileUtil;
import com.nepxion.util.io.IOUtil;

public class ZoneContext
	implements ZoneConstants
{
	private static String content;
	
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
			InputStream inputStream = FileUtil.getInputStream(filePath, false);
			content = IOUtil.getString(inputStream);
		}
		catch (Exception e)
		{
			throw e;
		}
	}
	
	public static void register(URL codeBase)
		throws Exception
	{
		try
		{
			InputStream inputStream = FileUtil.getInputStream(codeBase, CONFIG_FILE_PATH);
			content = IOUtil.getString(inputStream);
		}
		catch (Exception e)
		{
			throw e;
		}
	}
	
	public static String getContent()
	{
		return content;
	}
}