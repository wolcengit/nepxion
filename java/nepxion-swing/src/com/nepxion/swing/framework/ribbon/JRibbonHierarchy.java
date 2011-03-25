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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JBasicButton;
import com.nepxion.swing.button.JBasicToggleButton;
import com.nepxion.swing.framework.JFrameWorkHierarchy;
import com.nepxion.swing.framework.JFrameWorkStatusBar;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.locale.SwingLocale;
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
		
		statusBar = new JFrameWorkStatusBar();
		statusBarContainer = new JPanel();
		statusBarContainer.setLayout(new BorderLayout());
		statusBarContainer.add(statusBar, BorderLayout.NORTH);
		
		setLayout(new BorderLayout());
		add(toolBar, BorderLayout.NORTH);
		add(container, BorderLayout.CENTER);
		add(statusBarContainer, BorderLayout.SOUTH);
		
		initStatusBar();
	}
	
	private void initStatusBar()
	{
		JBasicButton closeRibbonComponentButton = new JBasicButton(IconFactory.getSwingIcon("item_close.png"), SwingLocale.getString("close_panel"));
		closeRibbonComponentButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JRibbonContainer ribbonContainer = getRibbonContainer();
				ribbonContainer.closeRobbinComponent();
			}	
		}
		);
		
		JBasicToggleButton toggleRibbonBarButton = new JBasicToggleButton(IconFactory.getSwingIcon("toggle_size.png"), SwingLocale.getString("toggle_toolbar_visibility"));	
		toggleRibbonBarButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JPanel toolBar = getToolBar();
				toolBar.setVisible(!toolBar.isVisible());
			}	
		}
		);
		
		JStatusItem statusItem = new JStatusItem();
		statusItem.add(closeRibbonComponentButton);
		statusItem.add(toggleRibbonBarButton);
		
		ButtonManager.updateUI(statusItem);
		
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