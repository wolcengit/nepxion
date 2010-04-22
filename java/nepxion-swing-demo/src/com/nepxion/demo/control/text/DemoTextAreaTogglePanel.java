package com.nepxion.demo.control.text;

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
import com.nepxion.demo.component.textarea.DemoAutoResizableTextAreaPanel;
import com.nepxion.demo.component.textarea.DemoCopyPasteTextAreaPanel;
import com.nepxion.demo.component.textarea.DemoHoverBorderTextAreaPanel;
import com.nepxion.demo.component.textarea.DemoLabelStyleTextAreaPanel;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;

public class DemoTextAreaTogglePanel
	extends DemoTogglePanel
{
	public DemoTextAreaTogglePanel()
	{
		JEclipseTabbedPane toggleTabbedPane = getToggleTabbedPane();
		toggleTabbedPane.addTab("Copy & Paste TextArea", IconFactory.getSwingIcon("component/text_area_16.png"), new DemoToggleTemplate(new DemoCopyPasteTextAreaPanel()));				
		toggleTabbedPane.addTab("Auto Resizable TextArea", IconFactory.getSwingIcon("component/text_area_16.png"), new DemoToggleTemplate(new DemoAutoResizableTextAreaPanel()));
		toggleTabbedPane.addTab("Label Style TextArea", IconFactory.getSwingIcon("component/text_area_16.png"), new DemoToggleTemplate(new DemoLabelStyleTextAreaPanel()));
		toggleTabbedPane.addTab("Hover Border TextArea", IconFactory.getSwingIcon("component/text_area_16.png"), new DemoToggleTemplate(new DemoHoverBorderTextAreaPanel()));		
	}
	
	public String getToggleName()
	{
		return "TextArea";
	}
	
	public Icon getToggleIcon()
	{
		return IconFactory.getSwingIcon("component/text_area_32.png");
	}
	
	public Icon getToggleBannerIcon()
	{
		return IconFactory.getSwingIcon("component/text_area_32.png");
	}
	
	public String getToggleDescription()
	{
		return "Multi-style TextArea";
	}
}