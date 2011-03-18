package com.nepxion.swing.framework;

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

import com.nepxion.swing.framework.dockable.JDockableHierarchy;

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
			return (JDockableHierarchy) component;
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
}