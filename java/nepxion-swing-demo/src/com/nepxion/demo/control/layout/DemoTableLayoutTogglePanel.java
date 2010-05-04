package com.nepxion.demo.control.layout;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import javax.swing.Icon;

import com.nepxion.demo.common.DemoTogglePanel;
import com.nepxion.demo.common.DemoToggleTemplate;
import com.nepxion.demo.component.layout.table.DemoAbsoluteTableLayoutPanel;
import com.nepxion.demo.component.layout.table.DemoFillTableLayoutPanel;
import com.nepxion.demo.component.layout.table.DemoMinimumTableLayoutPanel;
import com.nepxion.demo.component.layout.table.DemoMixedTableLayoutPanel;
import com.nepxion.demo.component.layout.table.DemoPreferredTableLayoutPanel;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;

public class DemoTableLayoutTogglePanel
	extends DemoTogglePanel
{
	public DemoTableLayoutTogglePanel()
	{
		JEclipseTabbedPane toggleTabbedPane = getToggleTabbedPane();
		toggleTabbedPane.addTab("Absolute Mode", IconFactory.getSwingIcon("component/layout_16.png"), new DemoToggleTemplate(new DemoAbsoluteTableLayoutPanel()));
		toggleTabbedPane.addTab("Preferred Mode", IconFactory.getSwingIcon("component/layout_16.png"), new DemoToggleTemplate(new DemoPreferredTableLayoutPanel()));			
		toggleTabbedPane.addTab("Minimum Mode", IconFactory.getSwingIcon("component/layout_16.png"), new DemoToggleTemplate(new DemoMinimumTableLayoutPanel()));
		toggleTabbedPane.addTab("Fill Mode", IconFactory.getSwingIcon("component/layout_16.png"), new DemoToggleTemplate(new DemoFillTableLayoutPanel()));	
		toggleTabbedPane.addTab("Mixed Mode", IconFactory.getSwingIcon("component/layout_16.png"), new DemoToggleTemplate(new DemoMixedTableLayoutPanel()));		
	}
	
	public String getToggleName()
	{
		return "Table Layout";
	}
	
	public Icon getToggleIcon()
	{
		return IconFactory.getSwingIcon("component/layout_32.png");
	}
	
	public Icon getToggleBannerIcon()
	{
		return IconFactory.getSwingIcon("component/layout_32.png");
	}
	
	public String getToggleDescription()
	{
		return "Multi-style Table Layout";
	}
}