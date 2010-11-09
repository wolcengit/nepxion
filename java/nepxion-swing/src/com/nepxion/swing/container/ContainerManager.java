package com.nepxion.swing.container;

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

import javax.swing.JComponent;

public class ContainerManager
{
	public static void add(JComponent component, Component addedComponent)
	{
		add(component, addedComponent, null);
	}
	
	public static void add(JComponent component, Component addedComponent, Object constraints)
	{
		add(component, addedComponent, null, constraints);
	}
	
	public static void add(JComponent component, Component addedComponent, Component removedComponent, Object constraints)
	{
		if (removedComponent != null)
		{
			component.remove(removedComponent);			
		}	
		else
		{
			component.removeAll();
		}
		if (constraints != null)
		{	
			component.add(addedComponent, constraints);
		}
		else
		{
			component.add(addedComponent);
		}
		update(component);			
	}	
	
	public static void update(JComponent component)
	{
		component.revalidate();
		component.repaint();		
	}
}