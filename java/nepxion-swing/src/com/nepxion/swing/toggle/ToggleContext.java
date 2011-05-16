package com.nepxion.swing.toggle;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

public class ToggleContext
{
	private static JToggleContentPanel contentPanel;
	
	public static void registerContentPanel(JToggleContentPanel contentPanel)
	{
		ToggleContext.contentPanel = contentPanel;
	}
	
	public static JToggleContentPanel getContentPanel()
	{
		return contentPanel;
	}
}