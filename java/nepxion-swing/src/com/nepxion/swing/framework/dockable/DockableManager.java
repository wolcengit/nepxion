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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DockableManager
{
	public static JDockableTabbedPane getDockableTabbedPane(JDockableContainer dockableContainer, String title, String tabbedPaneName)
	{
		List tabbedPanes = getDockableTabbedPanes(dockableContainer, title);
		if (tabbedPanes == null)
		{
			return null;
		}
		for (Iterator iterator = tabbedPanes.iterator(); iterator.hasNext();)
		{
			JDockableTabbedPane tabbedPane = (JDockableTabbedPane) iterator.next();
			if (tabbedPane.getName().equals(tabbedPaneName))
			{
				return tabbedPane;
			}
		}
		return null;
	}
	
	// 获得所有DockableTabbedPane对象，该方法只用于DockableSplitPane布局在DockableTabbedPane中
	// 当DockableTabbedPane呈现全屏模式时，其直接放置于DockableView，则通过DockableView去获取DockableTabbedPane，
	// 否则通过DockableSplitPane去获取
	public static List getDockableTabbedPanes(JDockableContainer dockableContainer, String title)
	{
		JDockableView dockableView = getDockableView(dockableContainer, title);
		if (dockableView == null)
		{
			return null;
		}
		Component content = dockableView.getContentPane();
		if (content instanceof JDockableSplitPane)
		{
			JDockableSplitPane dockableSplitPane = (JDockableSplitPane) content;
			return dockableSplitPane.getTabbedPanes();
		}
		else if (content instanceof JDockableTabbedPane)
		{
			List tabbedPanes = new ArrayList();
			tabbedPanes.add(content);
			return tabbedPanes;
		}
		else
		{
			return null;
		}
	}
	
	// 根据JDockableView Title获得指定JDockableContainer中的JDockableView对象
	public static JDockableView getDockableView(JDockableContainer dockableContainer, String title)
	{
		Component component = dockableContainer.getContentPane();
		if (component instanceof JDockable) // 最大化状态下，Dockable句柄为空
		{
			JDockable dockable = (JDockable) component;
			return DockableManager.getDockableView(dockable, title);
		}
		else if (component instanceof JDockableView)
		{
			JDockableView dockableView = (JDockableView) component;
			if (dockableView.getTitle().equals(title))
			{
				return dockableView;
			}
		}
		return null;
	}
	
	// 根据JDockableView Title获得指定JDockable中的JDockableView对象
	public static JDockableView getDockableView(JDockable dockable, String title)
	{
		for (int i = 0; i < dockable.getPaneCount(); i++)
		{
			Component component = dockable.getPaneAt(i);
			if (component instanceof JDockableView)
			{
				JDockableView dockableView = (JDockableView) component;
				if (dockableView.getTitle().equals(title))
				{
					return dockableView;
				}
			}
			else if (component instanceof JDockable)
			{
				JDockable childDockable = (JDockable) component;
				JDockableView dockableView = getDockableView(childDockable, title);
				if (dockableView != null)
				{
					return dockableView;
				}
				else
				{
					continue;
				}
			}
		}
		return null;
	}
	
	public static List getDockableViews(JDockableContainer dockableContainer)
	{
		List dockableViews = new ArrayList();
		Component component = dockableContainer.getContentPane();
		if (component instanceof JDockable) // 最大化状态下，Dockable句柄为空
		{
			JDockable dockable = (JDockable) component;
			DockableManager.getDockableViews(dockable, dockableViews);
		}
		else if (component instanceof JDockableView)
		{
			JDockableView dockableView = (JDockableView) component;
			dockableViews.add(dockableView);
		}
		return dockableViews;
	}
	
	// 根据获得指定JDockable中的所有的JDockableView对象和嵌套对象
	public static List getDockableViews(JDockable dockable)
	{
		List dockableViews = new ArrayList();
		getDockableViews(dockable, dockableViews);
		return dockableViews;
	}
	
	// 根据获得指定JDockable中的所有的JDockableView对象和嵌套对象
	public static void getDockableViews(JDockable dockable, List dockableViews)
	{
		for (int i = 0; i < dockable.getPaneCount(); i++)
		{
			Component component = dockable.getPaneAt(i);
			if (component instanceof JDockableView)
			{
				JDockableView dockableView = (JDockableView) component;
				dockableViews.add(dockableView);
			}
			else if (component instanceof JDockable)
			{
				JDockable childDockable = (JDockable) component;
				getDockableViews(childDockable, dockableViews);
			}
		}
	}
	
	// 获得DockableView的附载的最近一级Dockable分割条
	public static JDockable getDockable(Component dockableView)
	{
		Container container = dockableView.getParent();
		if (container == null)
		{
			return null;
		}
		
		if (container instanceof JDockable)
		{
			return (JDockable) container;
		}
		else
		{
			return getDockable(container);
		}
	}
	
	// 获得DockableView的顶层DockableContainer容器
	public static JDockableContainer getDockableContainer(Component dockableView)
	{
		Container container = dockableView.getParent();
		if (container == null)
		{
			return null;
		}
		
		if (container instanceof JDockableContainer)
		{
			return (JDockableContainer) container;
		}
		else
		{
			return getDockableContainer(container);
		}
	}
}