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
import javax.swing.JRadioButtonMenuItem;

public class JBasicRadioButtonMenuItem
	extends JRadioButtonMenuItem
{
	public JBasicRadioButtonMenuItem()
	{
		super();
	}
	
	public JBasicRadioButtonMenuItem(Icon icon)
	{
		super(icon);
	}
	
	public JBasicRadioButtonMenuItem(Icon icon, String toolTipText)
	{
		super(icon);
		
		setToolTipText(toolTipText);
	}
	
	public JBasicRadioButtonMenuItem(String text)
	{
		super(text);
	}
	
	public JBasicRadioButtonMenuItem(String text, String toolTipText)
	{
		super(text);
		
		setToolTipText(toolTipText);
	}
	
	public JBasicRadioButtonMenuItem(Action action)
	{
		super(action);
	}
	
	public JBasicRadioButtonMenuItem(String text, Icon icon)
	{
		super(text, icon);
	}
	
	public JBasicRadioButtonMenuItem(String text, Icon icon, String toolTipText)
	{
		super(text, icon);
		
		setToolTipText(toolTipText);
	}
	
	public JBasicRadioButtonMenuItem(String text, boolean selected)
	{
		super(text, selected);
	}
	
	public JBasicRadioButtonMenuItem(String text, String toolTipText, boolean selected)
	{
		super(text, selected);
		
		setToolTipText(toolTipText);
	}
	
	public JBasicRadioButtonMenuItem(Icon icon, boolean selected)
	{
		super(icon, selected);
	}
	
	public JBasicRadioButtonMenuItem(Icon icon, String toolTipText, boolean selected)
	{
		super(icon, selected);
		
		setToolTipText(toolTipText);
	}
	
	public JBasicRadioButtonMenuItem(String text, Icon icon, boolean selected)
	{
		super(text, icon, selected);
	}
	
	public JBasicRadioButtonMenuItem(String text, String toolTipText, Icon icon, boolean selected)
	{
		super(text, icon, selected);
		
		setToolTipText(toolTipText);
	}
}