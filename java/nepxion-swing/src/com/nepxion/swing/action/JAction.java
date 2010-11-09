package com.nepxion.swing.action;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;

public abstract class JAction
	extends AbstractAction
{	
	public JAction()
	{
		super();
	}
	
	public JAction(String name)
	{
		super(name);
	}
	
	public JAction(String name, Icon icon)
	{
		super(name, icon);
	}
	
	public JAction(String name, String toolTipText)
	{
		this(name);
		
		setToolTipText(toolTipText);
	}
	
	public JAction(String name, Icon icon, String toolTipText)
	{
		this(name, icon);
		
		setToolTipText(toolTipText);
	}
	
	public String getName()
	{
		return (String) getValue(Action.NAME);
	}
	
	public void setName(String name)
	{
		putValue(Action.NAME, name);
	}
	
	public String getToolTipText()
	{
		return (String) getValue(Action.SHORT_DESCRIPTION);
	}
	
	public void setToolTipText(String toolTipText)
	{
		putValue(Action.SHORT_DESCRIPTION, toolTipText);
	}
	
	public Icon getIcon()
	{
		return (Icon) getValue(Action.SMALL_ICON);
	}
	
	public void setIcon(Icon icon)
	{
		putValue(Action.SMALL_ICON, icon);
	}
	
	public String toString()
	{
		return getValue(Action.NAME).toString();
	}
}