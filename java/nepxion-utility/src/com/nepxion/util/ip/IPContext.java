package com.nepxion.util.ip;

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
import java.io.IOException;
import java.net.URL;

import com.nepxion.util.io.FileUtil;

public class IPContext
	implements IPConstants
{
	private static File file;
	
	public static void register()
	{
		register(DATA_FILE_PATH);
	}
	
	public static void register(String filePath)
	{
		file = new File(filePath);
	}
	
	public static void register(URL codeBaseURL)
	{				
		String httpURL = codeBaseURL + DATA_FILE_PATH;
		
		try
		{
			file = FileUtil.download(httpURL, DATA_FILE_TEMP_PATH);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}		
	}
	
	public static File getFile()
	{
		return file;
	}
}