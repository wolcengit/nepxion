package com.nepxion.swing.menu;

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
import javax.swing.JMenu;

public class JBasicMenu
	extends JMenu
{
	public JBasicMenu()
	{
		super();
	}
	
	public JBasicMenu(Icon icon)
	{
		super();
		
		setIcon(icon);
	}
	
	public JBasicMenu(Icon icon, String toolTipText)
	{
		super();
		
		setIcon(icon);
		setToolTipText(toolTipText);
	}
	
	public JBasicMenu(String text)
	{
		super(text);
	}
	
	public JBasicMenu(String text, String toolTipText)
	{
		super(text);
		
		setToolTipText(toolTipText);
	}
	
	public JBasicMenu(Action action)
	{
		super(action);
	}
	
	public JBasicMenu(String text, Icon icon)
	{
		super(text);
		
		setIcon(icon);
	}
	
	public JBasicMenu(String text, Icon icon, String toolTipText)
	{
		super(text);
		
		setIcon(icon);
		setToolTipText(toolTipText);
	}
	
	public JBasicMenu(String text, boolean selected)
	{
		super(text);
		
		setSelected(selected);
	}
	
	public JBasicMenu(String text, String toolTipText, boolean selected)
	{
		super(text);
		
		setSelected(selected);
		setToolTipText(toolTipText);
	}
}