package com.nepxion.demo.control.indicator;

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
import com.nepxion.demo.component.spinner.DemoSpinnerFieldPanel;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;

public class DemoSpinnerTogglePanel
	extends DemoTogglePanel
{
	public DemoSpinnerTogglePanel()
	{
		JEclipseTabbedPane toggleTabbedPane = getToggleTabbedPane();
		toggleTabbedPane.addTab("SpinnerField", IconFactory.getSwingIcon("component/spinner_16.png"), new DemoToggleTemplate(new DemoSpinnerFieldPanel()), "SpinnerField");		
	}
	
	public String getToggleName()
	{
		return "Spinner";
	}
	
	public Icon getToggleIcon()
	{
		return IconFactory.getSwingIcon("component/spinner_32.png");
	}
	
	public Icon getToggleBannerIcon()
	{
		return IconFactory.getSwingIcon("component/spinner_32.png");
	}
	
	public String getToggleDescription()
	{
		return "Multi-style Spinner";
	}
}