package com.nepxion.demo.component.dockable;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class DemoDockableFrameWorkPanel
	extends JPanel
{
	public DemoDockableFrameWorkPanel()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new DockableFrameWorkPanel());
	}
	
	public class DockableFrameWorkPanel
		extends JPanel
	{
		public DockableFrameWorkPanel()
		{			
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			add(new DemoDockableHierarchy());
		}
	}
}