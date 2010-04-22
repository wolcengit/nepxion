package com.nepxion.demo.control.button;

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
import com.nepxion.demo.component.checkbox.DemoCheckBoxPanel;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;

public class DemoCheckBoxTogglePanel
	extends DemoTogglePanel
{
	public DemoCheckBoxTogglePanel()
	{
		JEclipseTabbedPane toggleTabbedPane = getToggleTabbedPane();
		toggleTabbedPane.addTab("CheckBox", IconFactory.getSwingIcon("component/button_16.png"), new DemoToggleTemplate(new DemoCheckBoxPanel()));
	}
	
	public String getToggleName()
	{
		return "CheckBox";
	}
	
	public Icon getToggleIcon()
	{
		return IconFactory.getSwingIcon("component/check_box_32.png");
	}
	
	public Icon getToggleBannerIcon()
	{
		return IconFactory.getSwingIcon("component/check_box_32.png");
	}
	
	public String getToggleDescription()
	{
		return "Multi-style CheckBox";
	}
}