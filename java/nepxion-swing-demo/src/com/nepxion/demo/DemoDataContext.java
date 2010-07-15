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
import com.nepxion.util.searcher.ip.local.IPContext;

public class DemoDataContext
{	
	public DemoDataContext()
	{
		
	}
	
	public void initialize()
	{
		try
		{
			// HttpContext.register();
			// ProxoolContext.register();
			// QuartzContext.register();
			IPContext.register();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}		
		EncodeContext.registerIOCharset("GBK");
		EncodeContext.registerHttpCharset("UTF-8");
		ActiveXContext.registerStrategy(ActiveXContext.STRATEGY_APPLICATION);
	}
	
	public void initialize(URL codeBase)
	{
		try
		{
			// HttpContext.register(codeBase);
			// ProxoolContext.register(codeBase);
			// QuartzContext.register(codeBase);
			IPContext.register(codeBase);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		EncodeContext.registerIOCharset("GBK");
		EncodeContext.registerHttpCharset("UTF-8");		
		ActiveXContext.registerStrategy(ActiveXContext.STRATEGY_APPLET);
	}	
}