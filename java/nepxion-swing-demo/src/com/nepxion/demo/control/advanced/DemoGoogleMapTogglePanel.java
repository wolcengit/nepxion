package com.nepxion.demo.control.advanced;

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
import com.nepxion.demo.component.gis.google.DemoCoordinatePanel;
import com.nepxion.demo.component.gis.google.DemoCellPanel;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;

public class DemoGoogleMapTogglePanel
	extends DemoTogglePanel
{
	public DemoGoogleMapTogglePanel()
	{
		JEclipseTabbedPane toggleTabbedPane = getToggleTabbedPane();
		toggleTabbedPane.addTab("模糊查询地理位置", IconFactory.getSwingIcon("component/advanced_16.png"), new DemoToggleTemplate(new DemoCoordinatePanel()), "模糊查询地理位置");
		toggleTabbedPane.addTab("根据经纬度查询地理位置", IconFactory.getSwingIcon("component/advanced_16.png"), new DemoToggleTemplate(new DemoCoordinatePanel()), "根据经纬度查询地理位置");				
		toggleTabbedPane.addTab("根据移动信息查询地理位置", IconFactory.getSwingIcon("component/advanced_16.png"), new DemoToggleTemplate(new DemoCellPanel()), "根据移动信息查询地理位置");
	}
	
	public String getToggleName()
	{
		return "Google Map";
	}
	
	public Icon getToggleIcon()
	{
		return IconFactory.getSwingIcon("component/advanced_32.png");
	}
	
	public Icon getToggleBannerIcon()
	{
		return IconFactory.getSwingIcon("component/advanced_32.png");
	}
	
	public String getToggleDescription()
	{
		return "Google Map";
	}
}