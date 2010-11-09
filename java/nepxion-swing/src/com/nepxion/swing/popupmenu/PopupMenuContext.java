package com.nepxion.swing.popupmenu;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

public class PopupMenuContext
	implements PopupMenuConstants
{	
	private static String title = DEFAULT_TITLE;
	
	public static void registerTitle(String customTitle)
	{
		title = customTitle;
	}
	
	public static String getTitle()
	{
		return title;
	}
}