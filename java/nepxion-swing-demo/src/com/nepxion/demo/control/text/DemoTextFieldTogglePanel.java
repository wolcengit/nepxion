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
import com.nepxion.demo.component.textfield.DemoCopyPasteTextFieldPanel;
import com.nepxion.demo.component.textfield.DemoHoverBorderTextFieldPanel;
import com.nepxion.demo.component.textfield.DemoIPAddressPanel;
import com.nepxion.demo.component.textfield.DemoLabelStyleTextFieldPanel;
import com.nepxion.demo.component.textfield.DemoNumberTextFieldPanel;
import com.nepxion.demo.component.textfield.DemoUnderlineBorderTextFieldPanel;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;

public class DemoTextFieldTogglePanel
	extends DemoTogglePanel
{
	public DemoTextFieldTogglePanel()
	{
		JEclipseTabbedPane toggleTabbedPane = getToggleTabbedPane();
		toggleTabbedPane.addTab("Copy & Paste TextField", IconFactory.getSwingIcon("component/text_field_16.png"), new DemoToggleTemplate(new DemoCopyPasteTextFieldPanel()));
		toggleTabbedPane.addTab("Number TextField", IconFactory.getSwingIcon("component/text_field_16.png"), new DemoToggleTemplate(new DemoNumberTextFieldPanel()));
		toggleTabbedPane.addTab("IP Address TextField", IconFactory.getSwingIcon("component/text_field_16.png"), new DemoToggleTemplate(new DemoIPAddressPanel()));
		toggleTabbedPane.addTab("Label Style TextField", IconFactory.getSwingIcon("component/text_field_16.png"), new DemoToggleTemplate(new DemoLabelStyleTextFieldPanel()));
		toggleTabbedPane.addTab("Hover Border TextField", IconFactory.getSwingIcon("component/text_field_16.png"), new DemoToggleTemplate(new DemoHoverBorderTextFieldPanel()));
		toggleTabbedPane.addTab("Underline Border TextField", IconFactory.getSwingIcon("component/text_field_16.png"), new DemoToggleTemplate(new DemoUnderlineBorderTextFieldPanel()));
	}
	
	public String getToggleName()
	{
		return "TextField";
	}
	
	public Icon getToggleIcon()
	{
		return IconFactory.getSwingIcon("component/text_field_32.png");
	}
	
	public Icon getToggleBannerIcon()
	{
		return IconFactory.getSwingIcon("component/text_field_32.png");
	}
	
	public String getToggleDescription()
	{
		return "Multi-style TextField";
	}
}