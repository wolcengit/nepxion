package com.nepxion.demo.control.container;

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
import com.nepxion.demo.component.dialog.DemoHintDialogPanel;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;

public class DemoDialogTogglePanel
	extends DemoTogglePanel
{
	public DemoDialogTogglePanel()
	{
		JEclipseTabbedPane toggleTabbedPane = getToggleTabbedPane();
		toggleTabbedPane.addTab("Hint Dialog", IconFactory.getSwingIcon("component/dialog_16.png"), new DemoToggleTemplate(new DemoHintDialogPanel()), "Hint Dialog");
	}
	
	public String getToggleName()
	{
		return "Dialog";
	}
	
	public Icon getToggleIcon()
	{
		return IconFactory.getSwingIcon("component/dialog_32.png");
	}
	
	public Icon getToggleBannerIcon()
	{
		return IconFactory.getSwingIcon("component/dialog_32.png");
	}
	
	public String getToggleDescription()
	{
		return "Multi-style Dialog";
	}
}