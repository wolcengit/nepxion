package com.nepxion.swing.listener;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;

public class VisibilityListener
	implements HierarchyListener
{
	public void hierarchyChanged(HierarchyEvent e)
	{
		long changeFlags = e.getChangeFlags();
		if ((changeFlags & HierarchyEvent.SHOWING_CHANGED) == HierarchyEvent.SHOWING_CHANGED)
		{
			visibilityChanged(e);
		}
	}
	
	public void visibilityChanged(HierarchyEvent e)
	{
		
	}
}