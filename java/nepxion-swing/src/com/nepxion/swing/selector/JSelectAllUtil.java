package com.nepxion.swing.selector;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.Component;

import com.jidesoft.swing.SelectAllUtils;

public class JSelectAllUtil
{
	public static void install(Component component)
	{
		SelectAllUtils.install(component);
	}
	
	public static void install(Component component, boolean onlyOnce)
	{
		SelectAllUtils.install(component, onlyOnce);
	}
	
	public static void uninstall(Component component)
	{
		SelectAllUtils.uninstall(component);
	}
}
