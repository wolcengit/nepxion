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

import javax.swing.JPanel;

import com.nepxion.swing.framework.JFrameWorkHierarchy;
import com.nepxion.swing.framework.JFrameWorkStatusBar;

public class JRibbonHierarchy
	extends JFrameWorkHierarchy
{
	private JPanel toolBar;
	
	private JRibbonContainer container;
	
	private JFrameWorkStatusBar statusBar;
	private JPanel statusBarContainer;
	
	public JRibbonHierarchy()
	{
		toolBar = new JPanel();
		toolBar.setLayout(new BorderLayout());
		
		container = new JRibbonContainer();
		
		statusBar = new JFrameWorkStatusBar();
		statusBarContainer = new JPanel();
		statusBarContainer.setLayout(new BorderLayout());
		statusBarContainer.add(statusBar, BorderLayout.NORTH);
		
		setLayout(new BorderLayout());
		add(toolBar, BorderLayout.NORTH);
		add(container, BorderLayout.CENTER);
		add(statusBarContainer, BorderLayout.SOUTH);
	}
	
	public JPanel getToolBar()
	{
		return toolBar;
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