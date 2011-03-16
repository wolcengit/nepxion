package com.nepxion.swing.checkbox;

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
import javax.swing.JCheckBox;

public class JBasicCheckBox
	extends JCheckBox
{
	public JBasicCheckBox()
	{
		super();
		
		initComponents();
	}
	
	public JBasicCheckBox(Icon icon)
	{
		super(icon);
		
		initComponents();
	}
	
	public JBasicCheckBox(Icon icon, String toolTipText)
	{
		super(icon);
		
		initComponents();
		
		setToolTipText(toolTipText);
	}
	
	public JBasicCheckBox(Icon icon, boolean selected)
	{
		super(icon, selected);
		
		initComponents();
	}
	
	public JBasicCheckBox(Icon icon, String toolTipText, boolean selected)
	{
		super(icon, selected);
		
		initComponents();
		
		setToolTipText(toolTipText);
	}
	
	public JBasicCheckBox(String text)
	{
		super(text);
		
		initComponents();
	}
	
	public JBasicCheckBox(String text, String toolTipText)
	{
		super(text);
		
		initComponents();
		
		setToolTipText(toolTipText);
	}
	
	public JBasicCheckBox(Action action)
	{
		super(action);
		
		initComponents();
	}
	
	public JBasicCheckBox(String text, boolean selected)
	{
		super(text, selected);
		
		initComponents();
	}
	
	public JBasicCheckBox(String text, String toolTipText, boolean selected)
	{
		super(text, selected);
		
		initComponents();
		
		setToolTipText(toolTipText);
	}
	
	public JBasicCheckBox(String text, Icon icon)
	{
		super(text, icon);
		
		initComponents();
	}
	
	public JBasicCheckBox(String text, String toolTipText, Icon icon)
	{
		super(text, icon);
		
		initComponents();
		
		setToolTipText(toolTipText);
	}
	
	public JBasicCheckBox(String text, Icon icon, boolean selected)
	{
		super(text, icon, selected);
		
		initComponents();
	}
	
	public JBasicCheckBox(String text, Icon icon, String toolTipText, boolean selected)
	{
		super(text, icon, selected);
		
		initComponents();
		
		setToolTipText(toolTipText);
	}
	
	private void initComponents()
	{
		CheckBoxManager.setPreferenceStyle(this);
	}
}