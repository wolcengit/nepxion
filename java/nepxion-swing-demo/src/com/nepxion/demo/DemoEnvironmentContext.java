package com.nepxion.demo;

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

import com.nepxion.swing.activex.ActiveXContext;
import com.nepxion.util.encode.EncodeContext;
import com.nepxion.util.net.http.ClientContext;

public class DemoEnvironmentContext
{	
	public DemoEnvironmentContext()
	{
		
	}
	
	public void initialize()
	{
		ClientContext.register();
		EncodeContext.registerCharset("GB2312");			
		ActiveXContext.registerStrategy(ActiveXContext.STRATEGY_APPLICATION);
	}
	
	public void initialize(URL codeBase)
	{
		ClientContext.register(codeBase);
		EncodeContext.registerCharset("GB2312");		
		ActiveXContext.registerStrategy(ActiveXContext.STRATEGY_APPLET);
	}	
}
