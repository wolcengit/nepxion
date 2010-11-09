package com.nepxion.swing.activex;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.Component;

import com.nepxion.util.jni.ApplicationUtil;

public class ActiveXManager
	implements ActiveXConstants
{
	public static void callWeb(Component component, String url)
		throws Exception
	{
		/*if (ActiveXContext.getStrategy() == ActiveXContext.STRATEGY_APPLICATION)
		{
			ApplicationXManager.callInternetExplorer(url);
		}
		else if (ActiveXContext.getStrategy() == ActiveXContext.STRATEGY_APPLET)
		{
			AppletXManager.callWeb(component, url);
		}*/
		ApplicationUtil.callApplication(url);
	}
	
	public static void callWord(Component component, String filePath, boolean readOnly)
		throws Exception
	{
		if (ActiveXContext.getStrategy() == STRATEGY_APPLICATION)
		{
			ApplicationXManager.callWord(filePath, readOnly);
		}
		else if (ActiveXContext.getStrategy() == STRATEGY_APPLET)
		{
			AppletXManager.callWord(component, filePath, readOnly);
		}
	}
	
	public static void callExcel(Component component, String filePath, boolean readOnly)
		throws Exception
	{
		if (ActiveXContext.getStrategy() == STRATEGY_APPLICATION)
		{
			ApplicationXManager.callExcel(filePath, readOnly);
		}
		else if (ActiveXContext.getStrategy() == STRATEGY_APPLET)
		{
			AppletXManager.callExcel(component, filePath, readOnly);
		}
	}
	
	public static void callPowerPoint(Component component, String filePath, boolean readOnly, boolean fullScreen)
		throws Exception
	{
		if (ActiveXContext.getStrategy() == STRATEGY_APPLICATION)
		{
			ApplicationXManager.callPowerPoint(filePath, readOnly, fullScreen);
		}
		else if (ActiveXContext.getStrategy() == STRATEGY_APPLET)
		{
			AppletXManager.callPowerPoint(component, filePath, readOnly, fullScreen);
		}
	}
}