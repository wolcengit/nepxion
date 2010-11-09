package com.nepxion.swing.taskbar;

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

import com.nepxion.swing.action.JAction;

public abstract class JTaskAction
	extends JAction
{
	public JTaskAction()
	{
		super();
	}
	
	public JTaskAction(String name)
	{
		super(name);
	}
	
	public JTaskAction(String name, Icon icon)
	{
		super(name, icon);
	}
	
	public JTaskAction(String name, String toolTipText)
	{
		super(name, toolTipText);
	}
	
	public JTaskAction(String name, Icon icon, String toolTipText)
	{
		super(name, icon, toolTipText);
	}
}