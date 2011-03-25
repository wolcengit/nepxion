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
import java.awt.Dimension;

import javax.swing.AbstractButton;
import javax.swing.JPanel;

import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JBasicButton;
import com.nepxion.swing.button.JClassicButton;
import com.nepxion.swing.framework.JFrameWorkHierarchy;
import com.nepxion.swing.framework.JFrameWorkStatusBar;
import com.nepxion.swing.framework.ribbon.action.JRibbonCloseAction;
import com.nepxion.swing.framework.ribbon.action.JRibbonToggleAction;
import com.nepxion.swing.lookandfeel.LookAndFeelManager;
import com.nepxion.swing.statusbar.JStatusBar;
import com.nepxion.swing.statusbar.JStatusItem;

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
		
		setLayout(new BorderLayout());
		add(toolBar, BorderLayout.NORTH);
		add(container, BorderLayout.CENTER);
	}
	
	public void showStatusBar()
	{
		statusBar = new JFrameWorkStatusBar();
		statusBarContainer = new JPanel();
		statusBarContainer.setLayout(new BorderLayout());
		statusBarContainer.add(statusBar, BorderLayout.NORTH);
		
		add(statusBarContainer, BorderLayout.SOUTH);
		
		AbstractButton closeRibbonComponentButton = null;
		if (LookAndFeelManager.isNimbusLookAndFeel())
		{
			closeRibbonComponentButton = new JClassicButton(new JRibbonCloseAction(this));
		}
		else
		{
			closeRibbonComponentButton = new JBasicButton(new JRibbonCloseAction(this));
		}
		
		AbstractButton toggleRibbonBarButton = null;
		if (LookAndFeelManager.isNimbusLookAndFeel())
		{
			toggleRibbonBarButton = new JClassicButton(new JRibbonToggleAction(this));
		}
		else
		{
			toggleRibbonBarButton = new JBasicButton(new JRibbonToggleAction(this));
		}
		
		JStatusItem statusItem = new JStatusItem();
		statusItem.add(closeRibbonComponentButton);
		statusItem.add(toggleRibbonBarButton);
		
		ButtonManager.updateUI(statusItem, new Dimension(30, 30));
		
		statusBar.setSeparatorHeight(14);
		statusBar.addItem(60, statusItem, JStatusBar.LEFT);
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