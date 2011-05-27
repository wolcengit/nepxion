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

import java.awt.BorderLayout;
import java.awt.Component;

import com.nepxion.swing.container.JContainer;

public class JDockableContainer
	extends JContainer
{
	/**
	 * The dock component.
	 */
	private Component dockComponent;
	
	/**
	 * Constructs with the default.
	 */
	public JDockableContainer()
	{
	}
	
	/**
	 * Sets the content pane.
	 * @param dockComponent the dock component
	 */
	public void setContentPane(Component dockComponent)
	{
		this.dockComponent = dockComponent;
		
		setLayout(new BorderLayout());
		setDockComponent(dockComponent);
	}
	
	/**
	 * Gets the content pane.
	 * @return the content pane
	 */
	public Component getContentPane()
	{
		return getComponent(0);
	}
	
	/**
	 * Sets the dock component.
	 * @param dockComponent the dock component
	 */
	protected void setDockComponent(Component dockComponent)
	{
		addComponent(dockComponent, BorderLayout.CENTER);
	}
	
	/**
	 * Docks the component.
	 * @param component the dock component
	 */
	protected void dock(Component component)
	{
		setDockComponent(component != null ? component : dockComponent);
	}
}