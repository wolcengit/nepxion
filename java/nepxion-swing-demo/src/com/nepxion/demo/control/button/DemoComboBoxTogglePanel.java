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
import com.nepxion.demo.component.combobox.DemoBasicComboBoxPanel;
import com.nepxion.demo.component.combobox.DemoElementComboBoxPanel;
import com.nepxion.demo.component.combobox.DemoGroupComboBoxPanel;
import com.nepxion.demo.component.combobox.DemoTreeComboBoxPanel;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;

public class DemoComboBoxTogglePanel
	extends DemoTogglePanel
{
	public DemoComboBoxTogglePanel()
	{
		JEclipseTabbedPane toggleTabbedPane = getToggleTabbedPane();
		toggleTabbedPane.addTab("Basic ComboBox", IconFactory.getSwingIcon("component/combo_box_16.png"), new DemoToggleTemplate(new DemoBasicComboBoxPanel()));
		toggleTabbedPane.addTab("Element ComboBox", IconFactory.getSwingIcon("component/combo_box_16.png"), new DemoToggleTemplate(new DemoElementComboBoxPanel()));
		toggleTabbedPane.addTab("Group ComboBox", IconFactory.getSwingIcon("component/combo_box_16.png"), new DemoToggleTemplate(new DemoGroupComboBoxPanel()));				
		toggleTabbedPane.addTab("Tree ComboBox", IconFactory.getSwingIcon("component/combo_box_16.png"), new DemoToggleTemplate(new DemoTreeComboBoxPanel()));
	}
	
	public String getToggleName()
	{
		return "ComboBox";
	}
	
	public Icon getToggleIcon()
	{
		return IconFactory.getSwingIcon("component/combo_box_32.png");
	}
	
	public Icon getToggleBannerIcon()
	{
		return IconFactory.getSwingIcon("component/combo_box_32.png");
	}
	
	public String getToggleDescription()
	{
		return "Multi-style ComboBox";
	}
}