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
	/**
	 * The navigator container.
	 */
	private JPanel navigatorContainer;
	
	/**
	 * The ribbon container.
	 */
	private JRibbonContainer container;
	
	/**
	 * The status bar.
	 */
	private JFrameWorkStatusBar statusBar;
	
	/**
	 * The status bar container.
	 * It can hold more than one status bars.
	 */
	private JPanel statusBarContainer;
		
	/**
	 * Constructs with the default.
	 */
	public JRibbonHierarchy()
	{
		navigatorContainer = new JPanel();
		navigatorContainer.setLayout(new BoxLayout(navigatorContainer, BoxLayout.Y_AXIS));
		
		container = new JRibbonContainer();
		
		setLayout(new BorderLayout());
		add(navigatorContainer, BorderLayout.NORTH);
		add(container, BorderLayout.CENTER);
	}
	
	/**
	 * Shows the status bar.
	 */
	public void showStatusBar()
	{
		statusBar = new JRibbonStatusBar(this);
		statusBarContainer = new JPanel();
		statusBarContainer.setLayout(new BorderLayout());
		statusBarContainer.add(statusBar, BorderLayout.NORTH);
		
		add(statusBarContainer, BorderLayout.SOUTH);
	}
	
	/**
	 * Gets the navigator container.
	 * @return the navigator container
	 */
	public JPanel getNavigatorContainer()
	{
		return navigatorContainer;
	}
	
	/**
	 * Gets the ribbon container.
	 * @return the ribbon container
	 */
	public JRibbonContainer getRibbonContainer()
	{
		return container;
	}
	
	/**
	 * Gets the status bar.
	 * @return the status bar
	 */
	public JFrameWorkStatusBar getStatusBar()
	{
		return statusBar;
	}
	
	/**
	 * Gets the status bar container.
	 * @return the status bar container
	 */
	public JPanel getStatusBarContainer()
	{
		return statusBarContainer;
	}
}