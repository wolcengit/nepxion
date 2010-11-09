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
	private Component dockComponent;
	
	public JDockableContainer()
	{
	}
	
	public void setContentPane(Component dockComponent)
	{
		this.dockComponent = dockComponent;
		setLayout(new BorderLayout());
		setDockComponent(dockComponent);
	}
	
	public Component getContentPane()
	{
		return getComponent(0);
	}
	
	protected void setDockComponent(Component dockComponent)
	{
		addComponent(dockComponent, BorderLayout.CENTER);
	}
	
	protected void dock(Component component)
	{
		setDockComponent(component != null ? component : dockComponent);
	}
}