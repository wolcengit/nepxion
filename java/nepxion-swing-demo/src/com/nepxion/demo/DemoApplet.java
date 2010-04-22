package com.nepxion.demo;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import com.nepxion.swing.framework.dockable.JFrameWorkApplet;

public class DemoApplet
	extends JFrameWorkApplet
{
	public void init()
	{
		super.init();
		
		DemoHierarchy hierarchy = new DemoHierarchy();
		setHierarchy(hierarchy);
	}
	
	public void initContext()
	{
		DemoContext context = new DemoContext();
		context.initialize();
	}
}