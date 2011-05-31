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

import com.nepxion.swing.framework.ribbon.JRibbonHierarchy;
import com.nepxion.swing.tabbedpane.JBasicTabbedPane;

public class DemoRibbonWorkspaceBar
	extends JBasicTabbedPane
{
	public DemoRibbonWorkspaceBar(JRibbonHierarchy ribbonHierarchy)
	{		
		setDrawBorder(false);
		setDrawCenter(false);
		// setTabPlacement(BOTTOM);
		
		ribbonHierarchy.getRibbonContainer().setTabbedPane(this);
	}
}