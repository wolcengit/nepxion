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
import com.nepxion.swing.button.JBasicMenuButton;
import com.nepxion.swing.button.JClassicButton;
import com.nepxion.swing.button.JClassicMenuButton;
import com.nepxion.swing.framework.JFrameWorkHierarchy;
import com.nepxion.swing.framework.JFrameWorkStatusBar;
import com.nepxion.swing.framework.ribbon.action.JRibbonAction;
import com.nepxion.swing.framework.ribbon.action.JRibbonCloseAction;
import com.nepxion.swing.framework.ribbon.action.JRibbonToggleFacadeAction;
import com.nepxion.swing.framework.ribbon.action.JRibbonToggleHeightAction;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.lookandfeel.LookAndFeelManager;
import com.nepxion.swing.menuitem.JBasicMenuItem;
import com.nepxion.swing.popupmenu.JDecorationPopupMenu;
import com.nepxion.swing.statusbar.JStatusBar;
import com.nepxion.swing.statusbar.JStatusItem;

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
		navigatorContainer.setLayout(new BorderLayout());
		
		container = new JRibbonContainer();
		
		setLayout(new BorderLayout());
		add(navigatorContainer, BorderLayout.NORTH);
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
		
		AbstractButton toggleHeightButton = null;
		if (LookAndFeelManager.isNimbusLookAndFeel())
		{
			toggleHeightButton = new JClassicButton(new JRibbonToggleHeightAction(this));
		}
		else
		{
			toggleHeightButton = new JBasicButton(new JRibbonToggleHeightAction(this));
		}
		
		JDecorationPopupMenu popupMenu = new JDecorationPopupMenu();
		popupMenu.add(new JBasicMenuItem(new JRibbonToggleFacadeAction("显示单行文字", IconFactory.getSwingIcon("label.png"), "显示单行文字", this, JRibbonAction.TEXT, JRibbonAction.SHOW_SMALL)));
		popupMenu.add(new JBasicMenuItem(new JRibbonToggleFacadeAction("显示多行文字", IconFactory.getSwingIcon("label.png"), "显示多行文字", this, JRibbonAction.TEXT, JRibbonAction.SHOW_LARGE)));
		popupMenu.add(new JBasicMenuItem(new JRibbonToggleFacadeAction("不显示文字", null, "不显示文字", this, JRibbonAction.TEXT, JRibbonAction.SHOW_NO)));
		popupMenu.addSeparator();
		popupMenu.add(new JBasicMenuItem(new JRibbonToggleFacadeAction("显示大图标", IconFactory.getSwingIcon("icon.png"), "显示大图标", this, JRibbonAction.ICON, JRibbonAction.SHOW_LARGE)));
		popupMenu.add(new JBasicMenuItem(new JRibbonToggleFacadeAction("显示小图标", IconFactory.getSwingIcon("icon_1.png"), "显示小图标", this, JRibbonAction.ICON, JRibbonAction.SHOW_SMALL)));
		popupMenu.add(new JBasicMenuItem(new JRibbonToggleFacadeAction("不显示图标", null, "不显示图标", this, JRibbonAction.ICON, JRibbonAction.SHOW_NO)));
		
		AbstractButton toggleFacadeButton = null;
		if (LookAndFeelManager.isNimbusLookAndFeel())
		{
			toggleFacadeButton = new JClassicMenuButton(IconFactory.getSwingIcon("facade.png"), "外观设置");
			((JClassicMenuButton) toggleFacadeButton).setPopupMenu(popupMenu);
		}
		else
		{
			toggleFacadeButton = new JBasicMenuButton(IconFactory.getSwingIcon("facade.png"), "外观设置");
			((JBasicMenuButton) toggleFacadeButton).setPopupMenu(popupMenu);
		}
		
		JStatusItem statusItem = new JStatusItem();
		statusItem.add(closeRibbonComponentButton);
		statusItem.add(toggleHeightButton);
		statusItem.add(toggleFacadeButton);
		
		ButtonManager.updateUI(statusItem, new Dimension(35, 35));
		
		statusBar.setSeparatorHeight(14);
		statusBar.addItem(105, statusItem, JStatusBar.LEFT);
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