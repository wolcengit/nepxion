package com.nepxion.swing.framework.ribbon.action;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

public class RibbonToggleContext
{
	private static int tabHeight = -1;
	private static int robbinBarHeight = -1;
	
	protected static int getTabHeight()
	{
		return tabHeight;
	}
	
	protected static void setTabHeight(int customTabHeight)
	{
		tabHeight = customTabHeight;
	}
	
	protected static int getRobbinBarHeight()
	{
		return robbinBarHeight;
	}
	
	protected static void setRobbinBarHeight(int customRobbinBarHeight)
	{
		robbinBarHeight = customRobbinBarHeight;
	}
}