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

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.nepxion.swing.framework.JFrameWorkHierarchy;
import com.nepxion.swing.framework.JFrameWorkStatusBar;

public class JRibbonHierarchy
	extends JFrameWorkHierarchy
{
	private JPanel navigatorContainer;
	
	private JRibbonContainer container;
	
	private JFrameWorkStatusBar statusBar;
	private JPanel statusBarContainer;
		
	public JRibbonHierarchy()
	{
		navigatorContainer = new JPanel();
		navigatorContainer.setLayout(new BoxLayout(navigatorContainer, BoxLayout.Y_AXIS));
		
		container = new JRibbonContainer();
		
		setLayout(new BorderLayout());
		add(navigatorContainer, BorderLayout.NORTH);
		add(container, BorderLayout.CENTER);
	}
	
	public void showStatusBar()
	{
		statusBar = new JRibbonStatusBar(this);
		statusBarContainer = new JPanel();
		statusBarContainer.setLayout(new BorderLayout());
		statusBarContainer.add(statusBar, BorderLayout.NORTH);
		
		add(statusBarContainer, BorderLayout.SOUTH);
	}
	
	public JPanel getNavigatorContainer()
	{
		return navigatorContainer;
	}
	
	public JRibbonContainer getRibbonContainer()
	{
		return container;
	}
	
	public JFrameWorkStatusBar getStatusBar()
	{
		return statusBar;
	}
	
	public JPanel getStatusBarContainer()
	{
		return statusBarContainer;
	}
}