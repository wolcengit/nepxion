package com.nepxion.swing.framework.dockable;

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
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JSeparator;

import com.nepxion.swing.framework.JFrameWorkHierarchy;
import com.nepxion.swing.framework.JFrameWorkStatusBar;
import com.nepxion.swing.menubar.JBasicMenuBar;
import com.nepxion.swing.toolbar.JBasicToolBar;

public class JDockableHierarchy
	extends JFrameWorkHierarchy
{
	private JBasicMenuBar menuBar;
	private JPanel menuBarContainer;
	
	private JSeparator separator;
	
	private JBasicToolBar toolBar;
	private JPanel toolBarContainer;
	
	private JPanel barContainer;
	
	private JDockableContainer dockableContainer;
	
	private JFrameWorkStatusBar statusBar;
	private JPanel statusBarContainer;
	
	public JDockableHierarchy()
	{
		menuBar = new JBasicMenuBar();
		menuBarContainer = new JPanel();
		menuBarContainer.setLayout(new BorderLayout());
		menuBarContainer.add(menuBar, BorderLayout.NORTH);
		
		separator = new JSeparator();
		
		toolBar = new JBasicToolBar();
		toolBarContainer = new JPanel();
		toolBarContainer.setLayout(new BorderLayout());
		toolBarContainer.add(toolBar, BorderLayout.NORTH);
		
		barContainer = new JPanel();
		barContainer.setLayout(new BorderLayout());
		barContainer.add(menuBarContainer, BorderLayout.NORTH);
		barContainer.add(separator, BorderLayout.CENTER);
		barContainer.add(toolBarContainer, BorderLayout.SOUTH);
		
		dockableContainer = new JDockableContainer();
		
		statusBar = new JFrameWorkStatusBar();
		statusBarContainer = new JPanel();
		statusBarContainer.setLayout(new BorderLayout());
		statusBarContainer.add(statusBar, BorderLayout.NORTH);		
		
		setLayout(new BorderLayout());
		add(barContainer, BorderLayout.NORTH);
		add(dockableContainer, BorderLayout.CENTER);
		add(statusBarContainer, BorderLayout.SOUTH);
	}
	
	public JBasicMenuBar getMenuBar()
	{
		return menuBar;
	}
	
	public JPanel getMenuBarContainer()
	{
		return menuBarContainer;
	}
	
	public JSeparator getSeparator()
	{
		return separator;
	}
	
	public JBasicToolBar getToolBar()
	{
		return toolBar;
	}
	
	public JPanel getToolBarContainer()
	{
		return toolBarContainer;
	}
	
	public JPanel getBarContainer()
	{
		return barContainer;
	}
	
	public JDockableContainer getDockableContainer()
	{
		return dockableContainer;
	}
	
	public JFrameWorkStatusBar getStatusBar()
	{
		return statusBar;
	}
	
	public JPanel getStatusBarContainer()
	{
		return statusBarContainer;
	}
	
	public JDockableView getDockableView(String title)
	{
		return DockableManager.getDockableView(dockableContainer, title);
	}
	
	public List getDockableViews()
	{
		return DockableManager.getDockableViews(dockableContainer);
	}
}