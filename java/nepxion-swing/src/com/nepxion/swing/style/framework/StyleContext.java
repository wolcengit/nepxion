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
	private static boolean isFrameDecorated = false;
	private static boolean isDialogDecorated = false;
	
	public static void registerStyle(String styleClass)
	{
		StyleContext.styleClass = styleClass;
	}
	
	public static void registerFrameDecorated(boolean isFrameDecorated)
	{
		StyleContext.isFrameDecorated = isFrameDecorated;
	}
	
	public static void registerDialogDecorated(boolean isDialogDecorated)
	{
		StyleContext.isDialogDecorated = isDialogDecorated;
	}
	
	public static String getStyleClass()
	{
		return styleClass;
	}
	
	public static boolean isFrameDecorated()
	{
		return isFrameDecorated;
	}
	
	public static boolean isDialogDecorated()
	{
		return isDialogDecorated;
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