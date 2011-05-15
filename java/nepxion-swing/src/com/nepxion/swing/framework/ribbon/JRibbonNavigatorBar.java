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

import java.awt.BorderLayout;

import javax.swing.JComponent;
import javax.swing.JPanel;

import com.nepxion.swing.framework.ribbon.action.JRibbonToggleHeightAction;
import com.nepxion.swing.tabbedpane.ITabbedPane;

public abstract class JRibbonNavigatorBar
	extends JPanel
{
	private int tabHeight = -1;
	private int navigatorBarHeight = -1;

	private ITabbedPane tabbedPane;
	
	public JRibbonNavigatorBar(ITabbedPane tabbedPane)
	{
		this.tabbedPane = tabbedPane;
		
		JComponent tabbedComponent = (JComponent) tabbedPane;
		tabbedComponent.addMouseListener(new JRibbonToggleHeightAction(this));
		
		setLayout(new BorderLayout());
		add(tabbedComponent, BorderLayout.CENTER);
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
	
	public ITabbedPane getTabbedPane()
	{
		return tabbedPane;
	}
}