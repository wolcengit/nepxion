package com.nepxion.swing.style.framework;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

public class StyleContext
{
	private static String styleClass;
	private static boolean isThemeDecorated = true;
	private static boolean isFrameDecorated = false;
	private static boolean isDialogDecorated = false;
	private static boolean isTabbedPaneDecorated = true;
	
	public static void registerStyle(String customStyleClass)
	{
		styleClass = customStyleClass;
	}
	
	public static void registerThemeDecorated(boolean isCustomThemeDecorated)
	{
		isThemeDecorated = isCustomThemeDecorated;
	}
	
	public static void registerFrameDecorated(boolean isCustomFrameDecorated)
	{
		isFrameDecorated = isCustomFrameDecorated;
	}
	
	public static void registerDialogDecorated(boolean isCustomDialogDecorated)
	{
		isDialogDecorated = isCustomDialogDecorated;
	}
	
	public static void registerTabbedPaneDecorated(boolean isCustomTabbedPaneDecorated)
	{
		isTabbedPaneDecorated = isCustomTabbedPaneDecorated;
	}
	
	public static String getStyleClass()
	{
		return styleClass;
	}
	
	public static boolean isThemeDecorated()
	{
		return isThemeDecorated;
	}
	
	public static boolean isFrameDecorated()
	{
		return isFrameDecorated;
	}
	
	public static boolean isDialogDecorated()
	{
		return isDialogDecorated;
	}
	
	public static boolean isTabbedPaneDecorated()
	{
		return isTabbedPaneDecorated;
	}
	
	public static boolean setPriorityContext()
	{
		if (styleClass != null)
		{
			StyleManager.setStyle(styleClass);
			return true;
		}
		return false;
	}
}