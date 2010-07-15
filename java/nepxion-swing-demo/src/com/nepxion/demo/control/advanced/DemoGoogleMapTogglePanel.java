package com.nepxion.demo.control.application;

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
		toggleTabbedPane.addTab("模糊搜索地理位置", IconFactory.getSwingIcon("component/application_16.png"), new DemoToggleTemplate(new DemoCoordinatePanel()), "模糊搜索地理位置");
		toggleTabbedPane.addTab("根据经纬度搜索地理位置", IconFactory.getSwingIcon("component/application_16.png"), new DemoToggleTemplate(new DemoCoordinatePanel()), "根据经纬度搜索地理位置");				
		toggleTabbedPane.addTab("根据移动信息搜索地理位置", IconFactory.getSwingIcon("component/application_16.png"), new DemoToggleTemplate(new DemoCellPanel()), "根据移动信息搜索地理位置");
	}
	
	public String getToggleName()
	{
		return "Google Map";
	}
	
	public Icon getToggleIcon()
	{
		return IconFactory.getSwingIcon("component/application_32.png");
	}
	
	public Icon getToggleBannerIcon()
	{
		return IconFactory.getSwingIcon("component/application_32.png");
	}
	
	public String getToggleDescription()
	{
		return "Google Map";
	}
}