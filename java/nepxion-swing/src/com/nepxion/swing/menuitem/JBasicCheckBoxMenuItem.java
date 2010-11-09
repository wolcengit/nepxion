package com.nepxion.swing.menuitem;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JCheckBoxMenuItem;

public class JBasicCheckBoxMenuItem
	extends JCheckBoxMenuItem
{
	public JBasicCheckBoxMenuItem()
	{
		super();
	}
	
	public JBasicCheckBoxMenuItem(Icon icon)
	{
		super(icon);
	}
	
	public JBasicCheckBoxMenuItem(Icon icon, String toolTipText)
	{
		super(icon);
		
		setToolTipText(toolTipText);
	}
	
	public JBasicCheckBoxMenuItem(String text)
	{
		super(text);
	}
	
	public JBasicCheckBoxMenuItem(String text, String toolTipText)
	{
		super(text);
		
		setToolTipText(toolTipText);
	}
	
	public JBasicCheckBoxMenuItem(Action action)
	{
		super(action);
	}
	
	public JBasicCheckBoxMenuItem(String text, Icon icon)
	{
		super(text, icon);
	}
	
	public JBasicCheckBoxMenuItem(String text, Icon icon, String toolTipText)
	{
		super(text, icon);
		
		setToolTipText(toolTipText);
	}
	
	public JBasicCheckBoxMenuItem(String text, boolean selected)
	{
		super(text, selected);
	}
	
	public JBasicCheckBoxMenuItem(String text, String toolTipText, boolean selected)
	{
		super(text, selected);
		
		setToolTipText(toolTipText);
	}
	
	public JBasicCheckBoxMenuItem(String text, Icon icon, boolean selected)
	{
		super(text, icon, selected);
	}
	
	public JBasicCheckBoxMenuItem(Icon icon, boolean selected)
	{
		super(null, icon, selected);
	}
	
	public JBasicCheckBoxMenuItem(Icon icon, String toolTipText, boolean selected)
	{
		super(null, icon, selected);
		
		setToolTipText(toolTipText);
	}
	
	public JBasicCheckBoxMenuItem(String text, String toolTipText, Icon icon, boolean selected)
	{
		super(text, icon, selected);
		
		setToolTipText(toolTipText);
	}
}