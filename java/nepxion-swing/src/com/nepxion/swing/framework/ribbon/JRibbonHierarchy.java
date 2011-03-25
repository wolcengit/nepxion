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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JBasicButton;
import com.nepxion.swing.button.JClassicButton;
import com.nepxion.swing.container.ContainerManager;
import com.nepxion.swing.framework.JFrameWorkHierarchy;
import com.nepxion.swing.framework.JFrameWorkStatusBar;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.locale.SwingLocale;
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
	
	private int tabHeight = -1;
	private int robbinBarHeight = -1;
	
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
		AbstractButton closeRibbonComponentButton = null;
		if (LookAndFeelManager.isNimbusLookAndFeel())
		{
			closeRibbonComponentButton = new JClassicButton(IconFactory.getSwingIcon("item_close.png"), SwingLocale.getString("close_panel"));
		}
		else
		{
			closeRibbonComponentButton = new JBasicButton(IconFactory.getSwingIcon("item_close.png"), SwingLocale.getString("close_panel"));
		}
		
		closeRibbonComponentButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				closeRibbonComponent();
			}
		});
		
		AbstractButton toggleRibbonBarButton = null;
		if (LookAndFeelManager.isNimbusLookAndFeel())
		{
			toggleRibbonBarButton = new JClassicButton(IconFactory.getSwingIcon("toggle_size.png"), SwingLocale.getString("toggle_toolbar_visibility"));
		}
		else
		{
			toggleRibbonBarButton = new JBasicButton(IconFactory.getSwingIcon("toggle_size.png"), SwingLocale.getString("toggle_toolbar_visibility"));
		}
		
		toggleRibbonBarButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				toggleRibbonBar();
			}
		});
		
		JStatusItem statusItem = new JStatusItem();
		statusItem.add(closeRibbonComponentButton);
		statusItem.add(toggleRibbonBarButton);
		
		ButtonManager.updateUI(statusItem, new Dimension(30, 30));
		
		statusBar.setSeparatorHeight(14);
		statusBar.addItem(60, statusItem, JStatusBar.LEFT);
	}
	
	public void closeRibbonComponent()
	{
		JRibbonContainer ribbonContainer = getRibbonContainer();
		ribbonContainer.closeRobbinComponent();
	}
	
	public void toggleRibbonBar()
	{
		JPanel toolBar = getToolBar();
		
		JTabbedPane tabbedPane = (JTabbedPane) toolBar.getComponent(0);
		
		int tabbedPaneHeight = tabbedPane.getSize().height;
		int tabbedPaneWidth = tabbedPane.getSize().width;
		if (tabbedPaneHeight != tabHeight)
		{
			for (int i = 0; i < tabbedPane.getTabCount(); i++)
			{
				JRibbonBar ribbonBar = (JRibbonBar) tabbedPane.getComponentAt(i);
				if (ribbonBar.getSize().height > robbinBarHeight)
				{
					robbinBarHeight = ribbonBar.getSize().height;
				}
			}
			
			tabHeight = tabbedPaneHeight - robbinBarHeight;
			
			tabbedPane.setPreferredSize(new Dimension(tabbedPaneWidth, tabHeight));
		}
		else
		{
			tabbedPane.setPreferredSize(new Dimension(tabbedPaneWidth, tabHeight + robbinBarHeight));
		}
		
		ContainerManager.update(tabbedPane);
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