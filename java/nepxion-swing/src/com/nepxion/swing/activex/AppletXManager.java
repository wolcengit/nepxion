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

import netscape.javascript.JSObject;

import com.nepxion.swing.handle.HandleManager;

public class AppletXManager
{
	public static void callWeb(Component component, String url)
		throws Exception
	{
		url = url.replace("\\", "/");
		callJavaScript(component, "window.open('" + url + "')");
	}
	
	public static void callWord(Component component, String filePath, boolean readOnly)
		throws Exception
	{
		filePath = filePath.replace("\\", "/");
		callJavaScript(component, "showWord('" + filePath + "', " + readOnly + ")");
	}
	
	public static void callExcel(Component component, String filePath, boolean readOnly)
		throws Exception
	{
		filePath = filePath.replace("\\", "/");
		callJavaScript(component, "showExcel('" + filePath + "', " + readOnly + ")");
	}
	
	public static void callPowerPoint(Component component, String filePath, boolean readOnly, boolean fullScreen)
		throws Exception
	{
		filePath = filePath.replace("\\", "/");
		callJavaScript(component, "showPowerPoint('" + filePath + "', " + readOnly + ", " + fullScreen + ")");
	}
	
	public static void callJavaScript(Component component, String javascript)
		throws Exception
	{
		JSObject.getWindow(HandleManager.getApplet(component)).eval(javascript);
	}
}