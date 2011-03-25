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

import com.nepxion.swing.action.JSecurityAction;

public abstract class JTaskAction
	extends JSecurityAction
{
	public JTaskAction()
	{
		super();
	}
	
	public JTaskAction(String text)
	{
		super(text);
	}
	
	public JTaskAction(Icon icon)
	{
		super(icon);
	}
	
	public JTaskAction(Icon icon, String toolTipText)
	{
		super(icon, toolTipText);
	}
	
	public JTaskAction(String text, String toolTipText)
	{
		super(text, toolTipText);
	}
	
	public JTaskAction(String text, Icon icon)
	{
		super(text, icon);
	}

	public JTaskAction(String text, Icon icon, String toolTipText)
	{
		super(text, icon, toolTipText);
	}
	
	public JTaskAction(String name, String text, String toolTipText)
	{
		super(name, text, toolTipText);
	}
	
	public JTaskAction(String name, String text, Icon icon, String toolTipText)
	{
		super(name, text, icon, toolTipText);
	}
}