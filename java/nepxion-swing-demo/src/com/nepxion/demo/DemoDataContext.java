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

import com.nepxion.swing.activex.ActiveXConstants;
import com.nepxion.swing.activex.ActiveXContext;
import com.nepxion.util.encoder.EncoderContext;
import com.nepxion.util.locale.LocaleConstants;
import com.nepxion.util.locale.LocaleContext;
import com.nepxion.util.log.LoggerContext;
import com.nepxion.util.scheduler.quartz.QuartzContext;
import com.nepxion.util.searcher.ip.local.IPContext;
import com.nepxion.util.searcher.zone.local.ZoneContext;

public class DemoDataContext
{	
	private static URL url;
	
	public static void initialize()
	{	
		EncoderContext.registerIOCharset("GBK");
		EncoderContext.registerHttpCharset("UTF-8");
		LocaleContext.registerLocale(LocaleConstants.LOCALE_EN_US);
		// LocaleContext.registerLocale(LocaleConstants.LOCALE_ZH_CN);
		ActiveXContext.registerStrategy(ActiveXConstants.STRATEGY_APPLICATION);		
		
		try
		{
			LoggerContext.register();
			// HttpContext.register();
			// ProxoolContext.register();
			QuartzContext.register();
			IPContext.register();
			ZoneContext.register();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}	
	}
	
	public static void initialize(URL codeBase)
	{
		EncoderContext.registerIOCharset("GBK");
		EncoderContext.registerHttpCharset("UTF-8");
		LocaleContext.registerLocale(LocaleConstants.LOCALE_EN_US);
		// LocaleContext.registerLocale(LocaleConstants.LOCALE_ZH_CN);
		ActiveXContext.registerStrategy(ActiveXConstants.STRATEGY_APPLET);
		
		try
		{
			LoggerContext.register(codeBase);
			// HttpContext.register(codeBase);
			// ProxoolContext.register(codeBase);
			QuartzContext.register(codeBase);
			IPContext.register(codeBase);
			ZoneContext.register(codeBase);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}	
		
		registerURL(codeBase);
	}
	
	public static void registerURL(URL codeBase)
	{
		url = codeBase;
	}
	
	public static URL getURL()
	{
		return url;
	}	
}