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
import com.nepxion.swing.icon.IconFactory;

public class DemoComboBoxTogglePanel
	extends DemoTogglePanel
{
	public DemoComboBoxTogglePanel()
	{
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