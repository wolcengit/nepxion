package com.nepxion.demo.control.data;

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
import com.nepxion.demo.component.list.DemoCheckBoxListPanel;
import com.nepxion.demo.component.list.DemoDecorationListPanel;
import com.nepxion.demo.component.list.DemoRadioButtonListPanel;
import com.nepxion.demo.component.list.DemoTabbedListPanel;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;

public class DemoListTogglePanel
	extends DemoTogglePanel
{
	public DemoListTogglePanel()
	{
		JEclipseTabbedPane toggleTabbedPane = getToggleTabbedPane();
		toggleTabbedPane.addTab("Decoration List", IconFactory.getSwingIcon("component/list_16.png"), new DemoToggleTemplate(new DemoDecorationListPanel()));		
		toggleTabbedPane.addTab("CheckBox List", IconFactory.getSwingIcon("component/list_16.png"), new DemoToggleTemplate(new DemoCheckBoxListPanel()));
		toggleTabbedPane.addTab("RadioButton List", IconFactory.getSwingIcon("component/list_16.png"), new DemoToggleTemplate(new DemoRadioButtonListPanel()));		
		toggleTabbedPane.addTab("Tab List", IconFactory.getSwingIcon("component/list_16.png"), new DemoToggleTemplate(new DemoTabbedListPanel()));
	}
	
	public String getToggleName()
	{
		return "List";
	}
	
	public Icon getToggleIcon()
	{
		return IconFactory.getSwingIcon("component/list_32.png");
	}
	
	public Icon getToggleBannerIcon()
	{
		return IconFactory.getSwingIcon("component/list_32.png");
	}
	
	public String getToggleDescription()
	{
		return "Multi-style List";
	}
}