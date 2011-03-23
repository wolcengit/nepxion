package com.nepxion.util.io;

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
import java.util.HashMap;
import java.util.Map;

public class FileContext
{
	private static Map map = new HashMap();
	
	public static void register(String filePath)
		throws Exception
	{
		try
		{
			InputStream inputStream = FileUtil.getInputStream(filePath, false);
			String content = IOUtil.getString(inputStream);
			map.put(filePath, content);
		}
		catch (Exception e)
		{
			throw e;
		}
	}
	
	public static void register(URL codeBase, String filePath)
		throws Exception
	{
		try
		{
			InputStream inputStream = FileUtil.getInputStream(codeBase, filePath);
			String content = IOUtil.getString(inputStream);
			map.put(filePath, content);
		}
		catch (Exception e)
		{
			throw e;
		}
	}
	
	public static String getContent(String filePath)
	{
		String content = (String) map.get(filePath);
		
		return content;
	}
}