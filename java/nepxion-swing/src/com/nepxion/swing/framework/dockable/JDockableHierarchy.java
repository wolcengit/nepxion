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
	/**
	 * The menu bar.
	 */
	private JBasicMenuBar menuBar;
	
	/**
	 * The menu bar container.
	 */
	private JPanel menuBarContainer;
	
	/**
	 * The separator.
	 */
	private JSeparator separator;
	
	/**
	 * The tool bar.
	 */
	private JBasicToolBar toolBar;
	
	/**
	 * The tool bar container.
	 */
	private JPanel toolBarContainer;
	
	/**
	 * The bar container.
	 */
	private JPanel barContainer;
	
	/**
	 * The dockable container.
	 */
	private JDockableContainer dockableContainer;
	
	/**
	 * The status bar.
	 */
	private JFrameWorkStatusBar statusBar;
	
	/**
	 * The status bar container.
	 */
	private JPanel statusBarContainer;
	
	/**
	 * Constructs with the default.
	 */
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
	
	/**
	 * Gets the menu bar.
	 * @return the instance of JBasicMenuBar
	 */
	public JBasicMenuBar getMenuBar()
	{
		return menuBar;
	}
	
	/**
	 * Gets the menu bar container.
	 * @return the instance of JPanel
	 */
	public JPanel getMenuBarContainer()
	{
		return menuBarContainer;
	}
	
	/**
	 * Gets the separator.
	 * @return the instance of JSeparator
	 */
	public JSeparator getSeparator()
	{
		return separator;
	}
	
	/**
	 * Gets the tool bar.
	 * @return the instance of JBasicToolBar
	 */
	public JBasicToolBar getToolBar()
	{
		return toolBar;
	}
	
	/**
	 * Gets the tool bar container.
	 * @return the instance of JPanel
	 */
	public JPanel getToolBarContainer()
	{
		return toolBarContainer;
	}
	
	/**
	 * Gets the bar container.
	 * @return the instance of JPanel
	 */
	public JPanel getBarContainer()
	{
		return barContainer;
	}
	
	/**
	 * Gets the dockable container.
	 * @return the instance of JDockableContainer
	 */
	public JDockableContainer getDockableContainer()
	{
		return dockableContainer;
	}
	
	/**
	 * Gets the status bar.
	 * @return the instance of JFrameWorkStatusBar
	 */
	public JFrameWorkStatusBar getStatusBar()
	{
		return statusBar;
	}
	
	/**
	 * Gets the stautus bar container.
	 * @return the instance of JPanel
	 */
	public JPanel getStatusBarContainer()
	{
		return statusBarContainer;
	}
	
	/**
	 * Gets the dockable view int the dockable container by a title.
	 * @param title the title string
	 * @return the instance of JDockableView
	 */
	public JDockableView getDockableView(String title)
	{
		return DockableManager.getDockableView(dockableContainer, title);
	}
	
	/**
	 * Gets the dockable view list.
	 * @return the instance of List
	 */
	public List getDockableViews()
	{
		return DockableManager.getDockableViews(dockableContainer);
	}
}