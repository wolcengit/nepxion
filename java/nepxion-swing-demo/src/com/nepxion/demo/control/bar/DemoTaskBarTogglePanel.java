package com.nepxion.demo.control.bar;

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
import com.nepxion.demo.component.taskbar.DemoTaskBarPanel;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.lookandfeel.LookAndFeelManager;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;
import com.nepxion.swing.taskbar.JTaskManager;

public class DemoTaskBarTogglePanel
	extends DemoTogglePanel
{
	public DemoTaskBarTogglePanel()
	{
	}
	
	public void initialize()
	{
		JEclipseTabbedPane toggleTabbedPane = getToggleTabbedPane();
		
		JTaskManager.installTaskPlainFont();
		
		LookAndFeelManager.addonMetalLookAndFeel();
		toggleTabbedPane.addTab("Metal L&F", IconFactory.getSwingIcon("component/tool_bar_16.png"), new DemoToggleTemplate(new DemoTaskBarPanel()), "Metal L&F");
		
		LookAndFeelManager.addonWindowsLookAndFeel();
		toggleTabbedPane.addTab("Windows L&F", IconFactory.getSwingIcon("component/tool_bar_16.png"), new DemoToggleTemplate(new DemoTaskBarPanel()), "Windows L&F");
		
		LookAndFeelManager.addonLunaLookAndFeel();
		toggleTabbedPane.addTab("Luna L&F", IconFactory.getSwingIcon("component/tool_bar_16.png"), new DemoToggleTemplate(new DemoTaskBarPanel()), "Luna L&F");
		
		LookAndFeelManager.addonHomesteadLookAndFeel();
		toggleTabbedPane.addTab("Homestead L&F", IconFactory.getSwingIcon("component/tool_bar_16.png"), new DemoToggleTemplate(new DemoTaskBarPanel()), "Homestead L&F");
		
		LookAndFeelManager.addonMetallicLookAndFeel();
		toggleTabbedPane.addTab("Metallic L&F", IconFactory.getSwingIcon("component/tool_bar_16.png"), new DemoToggleTemplate(new DemoTaskBarPanel()), "Metallic L&F");
		
		LookAndFeelManager.addonGlossyLookAndFeel();
		toggleTabbedPane.addTab("Glossy L&F", IconFactory.getSwingIcon("component/tool_bar_16.png"), new DemoToggleTemplate(new DemoTaskBarPanel()), "Glossy L&F");		
	}
	
	public String getToggleText()
	{
		return "TaskBar";
	}
	
	public Icon getToggleIcon()
	{
		return IconFactory.getSwingIcon("component/tool_bar_32.png");
	}
	
	public Icon getToggleBannerIcon()
	{
		return IconFactory.getSwingIcon("component/tool_bar_32.png");
	}
	
	public String getToggleDescription()
	{
		return "Multi-style TaskBar";
	}
}