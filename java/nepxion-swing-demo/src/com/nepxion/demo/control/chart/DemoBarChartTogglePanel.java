package com.nepxion.demo.control.chart;

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
import javax.swing.JPanel;

import com.nepxion.demo.common.DemoTogglePanel;
import com.nepxion.demo.common.DemoToggleTemplate;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;

public class DemoBarChartTogglePanel
	extends DemoTogglePanel
{
	public DemoBarChartTogglePanel()
	{
		JEclipseTabbedPane toggleTabbedPane = getToggleTabbedPane();
		toggleTabbedPane.addTab("Bar Chart", IconFactory.getSwingIcon("component/chart_bar_16.png"), new DemoToggleTemplate(new JPanel()), "Bar Chart");
	}
	
	public String getToggleName()
	{
		return "Bar Chart";
	}
	
	public Icon getToggleIcon()
	{
		return IconFactory.getSwingIcon("component/chart_bar_32.png");
	}
	
	public Icon getToggleBannerIcon()
	{
		return IconFactory.getSwingIcon("component/chart_bar_32.png");
	}
	
	public String getToggleDescription()
	{
		return "Multi-style Bar Chart";
	}
}