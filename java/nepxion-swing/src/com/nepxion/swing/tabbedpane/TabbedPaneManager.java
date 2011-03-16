package com.nepxion.swing.tabbedpane;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import javax.swing.JTabbedPane;

import com.nepxion.swing.lookandfeel.LookAndFeelManager;

public class TabbedPaneManager
{
	public static void setPreferenceStyle(JTabbedPane tabbedPane)
	{
		if (!LookAndFeelManager.isNimbusLookAndFeel())
		{
			tabbedPane.setFocusable(false);
		}
	}
}