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
import java.util.Properties;

public interface IContextRegister
{
	public void register(String filePath)
		throws Exception;
	
	public void register(String filePath, URL codeBase)
		throws Exception;
	
	public void initializeContext(Properties properties);
	
	public void initializeContext(Properties properties, URL codeBase);
}