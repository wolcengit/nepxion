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

import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.List;

import javax.swing.JComponent;

import com.nepxion.swing.fullscreen.FullScreenRegister;
import com.nepxion.swing.fullscreen.FullScreenSupport;
import com.nepxion.swing.keystroke.KeyStrokeManager;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.menu.JBasicMenu;
import com.nepxion.swing.menuitem.JBasicCheckBoxMenuItem;

public class FrameWorkManager
{
	public static JFrameWorkHierarchy getFrameWorkHierarchy(Component component)
	{
		if (component == null)
		{
			return null;
		}
		
		if (component instanceof JFrameWorkHierarchy)
		{
			return (JFrameWorkHierarchy) component;
		}
		
		Container parent = component.getParent();
		while (parent != null)
		{
			if (parent instanceof JFrameWorkHierarchy)
			{
				return (JFrameWorkHierarchy) parent;
			}
			parent = parent.getParent();
		}
		return null;
	}
	
	public static JFrameWorkWindow getFrameWorkWindow(Component component)
	{
		if (component == null)
		{
			return null;
		}
		
		if (component instanceof JFrameWorkWindow)
		{
			return (JFrameWorkWindow) component;
		}
		
		Container parent = component.getParent();
		while (parent != null)
		{
			if (parent instanceof JFrameWorkWindow)
			{
				return (JFrameWorkWindow) parent;
			}
			parent = parent.getParent();
		}
		return null;
	}
	
	public static JDockableView getDockableView(JFrameWorkWindow frameWorkWindow, String title)
	{
		if (frameWorkWindow == null)
		{
			return null;
		}
		JFrameWorkHierarchy frameWorkHierarchy = frameWorkWindow.getHierarchy();
		return getDockableView(frameWorkHierarchy, title);
	}
	
	public static JDockableView getDockableView(JFrameWorkHierarchy frameWorkHierarchy, String title)
	{
		if (frameWorkHierarchy == null)
		{
			return null;
		}
		JDockableContainer dockableContainer = frameWorkHierarchy.getDockableContainer();
		Component component = dockableContainer.getContentPane();
		if (component instanceof JDockable)
		{
			JDockable dockable = (JDockable) component;
			return DockableManager.getDockableView(dockable, title);
		}
		return null;
	}
	
	public static JBasicMenu getToggleMenu(final JFrameWorkHierarchy hierarchy)
	{
		JBasicMenu toggleMenu = new JBasicMenu(SwingLocale.getString("view"), SwingLocale.getString("view") + "(V)");
		toggleMenu.setMnemonic('V');
		
		final JBasicCheckBoxMenuItem toolBarToggleMenuItem = new JBasicCheckBoxMenuItem(SwingLocale.getString("toolbar"), SwingLocale.getString("toolbar"), true);
		toolBarToggleMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JComponent toolBar = hierarchy.getToolBar();
				toolBar.setVisible(!toolBar.isVisible());
			}
		}
		);
		toggleMenu.add(toolBarToggleMenuItem);
		
		final JBasicCheckBoxMenuItem statusBarToggleMenuItem = new JBasicCheckBoxMenuItem(SwingLocale.getString("statusbar"), SwingLocale.getString("statusbar"), true);
		statusBarToggleMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JComponent statusBar = hierarchy.getStatusBar();
				statusBar.setVisible(!statusBar.isVisible());
			}
		}
		);
		toggleMenu.add(statusBarToggleMenuItem);
		
		toggleMenu.addSeparator();
		
		List dockableViews = hierarchy.getDockableViews();
		for (Iterator iterator = dockableViews.iterator(); iterator.hasNext();)
		{
			final JDockableView dockableView = (JDockableView) iterator.next();
			final JBasicCheckBoxMenuItem dockableViewToggleMenuItem = new JBasicCheckBoxMenuItem(dockableView.getTitle(), dockableView.getTitle(), true);
			dockableView.registerForeignButton(dockableViewToggleMenuItem);
			dockableViewToggleMenuItem.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					dockableView.setVisible(!dockableView.isVisible());
				}
			}
			);
			toggleMenu.add(dockableViewToggleMenuItem);
		}
		
		toggleMenu.addSeparator();
		
		JBasicCheckBoxMenuItem screenToggleMenuItem = new JBasicCheckBoxMenuItem(SwingLocale.getString("fullscreen"), SwingLocale.getString("fullscreen"));
		// JBasicMenuItem screenToggleMenuItem = new JBasicMenuItem(FullScreenConstants.TEXT_MAXIMIZE, FullScreenConstants.ICON_MAXIMIZE, FullScreenConstants.TEXT_MAXIMIZE);
		KeyStrokeManager.registerButton(screenToggleMenuItem, KeyEvent.VK_F12, 'F');
		toggleMenu.add(screenToggleMenuItem);
		
		FullScreenSupport fullScreenSupport = new FullScreenSupport(hierarchy);
		FullScreenRegister fullScreenRegister = new FullScreenRegister(fullScreenSupport);
		fullScreenRegister.register(hierarchy.getMenuBar());
		fullScreenRegister.register(hierarchy.getToolBar());
		fullScreenRegister.register(screenToggleMenuItem);
		
		return toggleMenu;
	}
}