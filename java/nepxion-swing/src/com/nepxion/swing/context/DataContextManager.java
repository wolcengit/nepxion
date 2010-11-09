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

import java.net.URL;

public class DataContextManager
	implements DataContextConstants
{	
	public static void initialize()
	{
		initialize(CONTEXT_FILE_PATH);
	}
	
	public static void initialize(String filePath)
	{
		IContextRegister dataContextRegister = new DataContextRegister();
		try
		{
			dataContextRegister.register(filePath);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void initialize(URL codeBase)
	{
		initialize(CONTEXT_FILE_PATH, codeBase);
	}
	
	public static void initialize(String filePath, URL codeBase)
	{
		IContextRegister dataContextRegister = new DataContextRegister();
		try
		{
			dataContextRegister.register(filePath, codeBase);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}