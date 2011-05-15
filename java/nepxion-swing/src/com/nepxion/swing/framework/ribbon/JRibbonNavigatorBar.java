package com.nepxion.swing.framework.ribbon;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import javax.swing.JPanel;

import com.nepxion.swing.tabbedpane.ITabbedPane;

public abstract class JRibbonNavigatorBar
	extends JPanel
{
	private int tabHeight = -1;
	private int navigatorBarHeight = -1;

	public JRibbonNavigatorBar()
	{
		
	}
	
	public int getTabHeight()
	{
		return tabHeight;
	}
	
	public void setTabHeight(int tabHeight)
	{
		this.tabHeight = tabHeight;
	}
	
	public int getNavigatorBarHeight()
	{
		return navigatorBarHeight;
	}
	
	public void setNavigatorBarHeight(int navigatorBarHeight)
	{
		this.navigatorBarHeight = navigatorBarHeight;
	}
	
	public abstract ITabbedPane getTabbedPane();
}