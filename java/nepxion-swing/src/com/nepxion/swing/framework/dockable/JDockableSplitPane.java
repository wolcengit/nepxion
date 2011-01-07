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

import com.nepxion.swing.splitpane.JBasicSplitPane;

public class JDockableSplitPane
	extends JBasicSplitPane
{
	// 其父组件可能为JDockableView或一般的Container
	private JDockableView dockableView;
	private Container dockableContainer;
	
	private boolean isMaximize = false;
	private int index;
	
	public JDockableSplitPane()
	{
		super();
	}
	
	public JDockableSplitPane(int newOrientation)
	{
		super(newOrientation);
	}
	
	public void add(Component pane, Object constraints)
	{
		setConstraints(pane, constraints);
		
		super.add(pane, constraints);
	}
	
	public void add(Component pane, Object constraints, int index)
	{
		setConstraints(pane, constraints);
		
		super.add(pane, constraints, index);
	}
	
	public Component insertPane(Component pane, Object constraints, int index)
	{
		setConstraints(pane, constraints);
		
		return super.insertPane(pane, constraints, index);
	}
	
	public void setPaneAt(Component pane, Object constraints, int index)
	{
		setConstraints(pane, constraints);
		
		super.setPaneAt(pane, constraints, index);
	}
	
	private void setConstraints(Component pane, Object constraints)
	{
		if (pane instanceof JDockableView)
		{
			((JDockableView) pane).setConstraints(constraints);
		}
	}
	
	public void toggleView(Component component)
	{
		init();
		if (!isMaximize)
		{
			index = indexOfPane(component);
			if (dockableView != null)
			{
				dockableView.setContentPane(component);
				dockableView.updateUI();
			}
			else if (dockableContainer != null)
			{
				dockableContainer.removeAll();
				dockableContainer.add(component);
				dockableContainer.validate();
			}
		}
		else
		{
			insertPane(component, index);
			if (dockableView != null)
			{
				dockableView.setContentPane(this);
				dockableView.updateUI();
			}
			else if (dockableContainer != null)
			{
				dockableContainer.removeAll();
				dockableContainer.add(this);
				dockableContainer.validate();
			}
		}
		isMaximize = !isMaximize;
	}
	
	public void toggleLayout()
	{
		init();
		if (isMaximize)
		{
			return;
		}
		
		List tabbedPanes = getTabbedPanes();
		
		removeAll();
		setOrientation(getOrientation() == HORIZONTAL_SPLIT ? VERTICAL_SPLIT : HORIZONTAL_SPLIT);
		
		for (Iterator iterator = tabbedPanes.iterator(); iterator.hasNext();)
		{
			JDockableTabbedPane tabbedPane = (JDockableTabbedPane) iterator.next();
			tabbedPane.setTabPlacement(getOrientation() == HORIZONTAL_SPLIT ? tabbedPane.getHorizontalTabPlacement() : tabbedPane.getVerticalTabPlacement());
			add(tabbedPane);
		}
	}
	
	private void init()
	{
		Container container = getParent();
		if (container instanceof JDockableView)
		{
			if (dockableView == null)
			{
				dockableView = (JDockableView) getParent();
			}
		}
		else
		{
			if (dockableContainer == null)
			{
				dockableContainer = getParent();
			}
		}
	}
	
	public List getTabbedPanes()
	{
		List tabbedPanes = new ArrayList();
		for (int i = 0; i < getPaneCount(); i++)
		{
			Component component = getPaneAt(i);
			if (component instanceof JDockableTabbedPane)
			{
				tabbedPanes.add(component);
			}
		}
		
		return tabbedPanes;
	}
}