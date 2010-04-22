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
import com.nepxion.swing.icon.IconFactory;

public class DemoTreeTogglePanel
	extends DemoTogglePanel
{
	public DemoTreeTogglePanel()
	{
	}
	
	public String getToggleName()
	{
		return "Tree";
	}
	
	public Icon getToggleIcon()
	{
		return IconFactory.getSwingIcon("component/tree_32.png");
	}
	
	public Icon getToggleBannerIcon()
	{
		return IconFactory.getSwingIcon("component/tree_32.png");
	}
	
	public String getToggleDescription()
	{
		return "Multi-style Tree";
	}
}