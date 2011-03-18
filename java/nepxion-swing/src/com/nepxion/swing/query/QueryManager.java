package com.nepxion.swing.query;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import com.nepxion.swing.framework.dockable.JDockable;
import com.nepxion.swing.lookandfeel.LookAndFeelManager;

public class QueryManager
{
	public static void setPreferenceStyle(JDockable dockable)
	{
		if (!LookAndFeelManager.isNimbusLookAndFeel())
		{
			dockable.setDividerLocation(0, 245);
		}
		else
		{
			dockable.setDividerLocation(0, 260);
		}
	}
}
