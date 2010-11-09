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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JPopupMenu;

import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.menuitem.JBasicMenuItem;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;

public class JDockableTabbedPane
	extends JEclipseTabbedPane
{
	private int verticalTabPlacement = TOP;
	private int horizontalTabPlacement = TOP;
	
	private JBasicMenuItem toggleSizeMenuItem;
	private JBasicMenuItem toggleLayoutMenuItem;
	
	public JDockableTabbedPane()
	{
		super();
	}
	
	public JDockableTabbedPane(int tabPlacement)
	{
		super(tabPlacement);
	}
	
	public JDockableTabbedPane(int tabPlacement, int tabLayoutPolicy)
	{
		super(tabPlacement, tabLayoutPolicy);
	}
	
	public void setPopupMenu(JPopupMenu popupMenu, boolean enabledClosableItem)
	{
		super.setPopupMenu(popupMenu, enabledClosableItem);
		
		// 切换项
		if (popupMenu.getComponentCount() != 0)
		{
			popupMenu.add(new JPopupMenu.Separator());
		}
		
		toggleSizeMenuItem = new JBasicMenuItem("切换最大化或还原区域", IconFactory.getSwingIcon("toggle_size.png"), "切换最大化或还原区域");
		toggleSizeMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				init();
				splitPane.toggleView(JDockableTabbedPane.this);
			}
		}
		);
		popupMenu.add(toggleSizeMenuItem);
		
		toggleLayoutMenuItem = new JBasicMenuItem("切换横向或纵向布局", IconFactory.getSwingIcon("toggle_layout.png"), "切换横向或纵向布局");
		toggleLayoutMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				init();
				splitPane.toggleLayout();
			}
		}
		);
		popupMenu.add(toggleLayoutMenuItem);
	}
	
	public void mouseClicked(MouseEvent e)
	{
		super.mouseClicked(e);
		// 假如右键菜单屏蔽，那么同时也屏蔽双击功能
		if (getPopupMenu() != null && e.getClickCount() > 1)
		{
			init();
			splitPane.toggleView(JDockableTabbedPane.this);
		}
	}
	
	public int getVerticalTabPlacement()
	{
		return verticalTabPlacement;
	}
	
	public void setVerticalTabPlacement(int verticalTabPlacement)
	{
		this.verticalTabPlacement = verticalTabPlacement;
	}
	
	public int getHorizontalTabPlacement()
	{
		return horizontalTabPlacement;
	}
	
	public void setHorizontalTabPlacement(int horizontalTabPlacement)
	{
		this.horizontalTabPlacement = horizontalTabPlacement;
	}
	
	private JDockableSplitPane splitPane;
	
	private void init()
	{
		if (splitPane == null)
		{
			splitPane = (JDockableSplitPane) getParent();
		}
	}
}