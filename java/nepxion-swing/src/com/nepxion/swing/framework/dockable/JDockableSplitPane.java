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
	/**
	 * The instance of JDockableView.
	 */
	private JDockableView dockableView;
	
	/**
	 * The instance of Container.
	 */
	private Container dockableContainer;
	
	/**
	 * The boolean value of isMaximized
	 */
	private boolean isMaximized = false;
	
	/**
	 * The index value.
	 */
	private int index;
	
	/**
	 * Constructs with the default.
	 */
	public JDockableSplitPane()
	{
		super();
	}
	
	/**
	 * Constructs with the specified initial new orientation.
	 * @param newOrientation the new orientation value
	 */
	public JDockableSplitPane(int newOrientation)
	{
		super(newOrientation);
	}
	
	/**
	 * Adds the pane with a constraints.
	 * @param pane the instance of Component
	 * @param constraints the constraints value
	 */
	public void add(Component pane, Object constraints)
	{
		setConstraints(pane, constraints);
		
		super.add(pane, constraints);
	}
	
	/**
	 * Adds the pane with a constraints and index.
	 * @param pane the instance of Component
	 * @param constraints the constraints value
	 * @param index the index value
	 */
	public void add(Component pane, Object constraints, int index)
	{
		setConstraints(pane, constraints);
		
		super.add(pane, constraints, index);
	}
	
	/**
	 * Insets the pane with a constraints and index.
	 * @param pane the instance of Component
	 * @param constraints the constraints value
	 * @param index the index value
	 */
	public Component insertPane(Component pane, Object constraints, int index)
	{
		setConstraints(pane, constraints);
		
		return super.insertPane(pane, constraints, index);
	}
	
	/**
	 * Sets the pane with a constraints and index.
	 * @param pane the instance of Component
	 * @param constraints the constraints value
	 * @param index the index value
	 */
	public void setPaneAt(Component pane, Object constraints, int index)
	{
		setConstraints(pane, constraints);
		
		super.setPaneAt(pane, constraints, index);
	}
	
	/**
	 * Sets the constraints.
	 * @param pane the instance of Component
	 * @param constraints the constraints value
	 */
	private void setConstraints(Component pane, Object constraints)
	{
		if (pane instanceof JDockableView)
		{
			((JDockableView) pane).setConstraints(constraints);
		}
	}
	
	/**
	 * Toggles the view.
	 * @param component the instance of Component
	 */
	public void toggleView(Component component)
	{
		init();
		if (!isMaximized)
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
		isMaximized = !isMaximized;
	}
	
	/**
	 * Toggles the layout.
	 */
	public void toggleLayout()
	{
		init();
		if (isMaximized)
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
	
	/**
	 * Initializes.
	 */
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
	
	/**
	 * Gets the tabbed pane list.
	 * @return the instance of List
	 */
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