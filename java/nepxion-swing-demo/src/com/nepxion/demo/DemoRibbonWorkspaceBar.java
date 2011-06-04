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

import com.nepxion.swing.container.JContainer;
import com.nepxion.swing.framework.ribbon.JRibbonContainer;
import com.nepxion.swing.framework.ribbon.JRibbonHierarchy;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;

public class DemoRibbonWorkspaceBar
{
	public DemoRibbonWorkspaceBar(JRibbonHierarchy ribbonHierarchy)
	{
		JRibbonContainer ribbonContainer = ribbonHierarchy.getRibbonContainer();
		
		// The container is displayed as JEclipseTabbedPane
		JEclipseTabbedPane tabbedPane = new JEclipseTabbedPane();
		
		// The container is displayed as JBasicTabbedPane
		// JBasicTabbedPane tabbedPane = new JBasicTabbedPane();
		
		tabbedPane.setTabPlacement(JEclipseTabbedPane.BOTTOM);
		ribbonContainer.setTabbedPane(tabbedPane);
		
		// The container is displayed as JContainer
		JContainer panel = new JContainer();
		ribbonContainer.setPanel(panel);
	}
}