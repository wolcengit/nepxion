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
	private String name;
	
	public JAction()
	{
		super();
	}
	
	public JAction(String text)
	{
		super(text);
	}
	
	public JAction(Icon icon)
	{
		super(null, icon);
	}
	
	public JAction(Icon icon, String toolTipText)
	{
		super(null, icon);
		
		setToolTipText(toolTipText);
	}
	
	public JAction(String text, String toolTipText)
	{
		super(text);
		
		setToolTipText(toolTipText);
	}
	
	public JAction(String text, Icon icon)
	{
		super(text, icon);
	}

	public JAction(String text, Icon icon, String toolTipText)
	{
		super(text, icon);
		
		setToolTipText(toolTipText);
	}
	
	public JAction(String name, String text, String toolTipText)
	{
		super(text);
		
		setName(name);
		setToolTipText(toolTipText);
	}
	
	public JAction(String name, String text, Icon icon, String toolTipText)
	{
		super(text, icon);
		
		setName(name);
		setToolTipText(toolTipText);
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getText()
	{
		return (String) getValue(Action.NAME);
	}
	
	public void setText(String text)
	{
		putValue(Action.NAME, text);
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