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
import javax.swing.JMenuItem;

public class JBasicMenuItem
	extends JMenuItem
{
	public JBasicMenuItem()
	{
		super();
	}
	
	public JBasicMenuItem(Icon icon)
	{
		super(icon);
	}
	
	public JBasicMenuItem(Icon icon, String toolTipText)
	{
		super(icon);
		
		setToolTipText(toolTipText);
	}
	
	public JBasicMenuItem(String text)
	{
		super(text);
	}
	
	public JBasicMenuItem(String text, String toolTipText)
	{
		super(text);
		
		setToolTipText(toolTipText);
	}
	
	public JBasicMenuItem(Action action)
	{
		super(action);
	}
	
	public JBasicMenuItem(String text, Icon icon)
	{
		super(text, icon);
	}
	
	public JBasicMenuItem(String text, Icon icon, String toolTipText)
	{
		super(text, icon);
		
		setToolTipText(toolTipText);
	}
	
	public JBasicMenuItem(String text, boolean selected)
	{
		super(text);
		
		setSelected(selected);
	}
	
	public JBasicMenuItem(String text, String toolTipText, boolean selected)
	{
		super(text);
		
		setSelected(selected);
		setToolTipText(toolTipText);
	}
	
	public JBasicMenuItem(String text, int mnemonic)
	{
		super(text, mnemonic);
	}
	
	public JBasicMenuItem(String text, String toolTipText, int mnemonic)
	{
		super(text, mnemonic);
		
		setToolTipText(toolTipText);
	}
	
	public JBasicMenuItem(String text, int mnemonic, boolean selected)
	{
		super(text, mnemonic);
		
		setSelected(selected);
	}
	
	public JBasicMenuItem(String text, String toolTipText, int mnemonic, boolean selected)
	{
		super(text, mnemonic);
		
		setSelected(selected);
		setToolTipText(toolTipText);
	}
}