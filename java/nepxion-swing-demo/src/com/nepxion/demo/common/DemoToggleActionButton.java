package com.nepxion.demo.common;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import com.nepxion.swing.panel.toggle.JToggleActionButton;

public class DemoToggleActionButton
	extends JToggleActionButton
{
	public DemoToggleActionButton(DemoTogglePanel togglePanel)
	{
		super(DemoToggleContentPanel.getInstance(), togglePanel);
	}
}
