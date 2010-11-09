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

import javax.swing.JPanel;

public class JContainer
	extends JPanel
{
	public void addComponent(Component addedComponent)
	{
		ContainerManager.add(this, addedComponent);
	}
	
	public void addComponent(Component addedComponent, Object constraints)
	{
		ContainerManager.add(this, addedComponent, constraints);
	}
	
	public void addComponent(Component addedComponent, Component removedComponent, Object constraints)
	{
		ContainerManager.add(this, addedComponent, removedComponent, constraints);
	}	
	
	public void update()
	{
		ContainerManager.update(this);
	}	
}