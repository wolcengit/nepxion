package com.nepxion.swing.button;

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
import javax.swing.JToggleButton;

public class JClassicToggleButton
	extends JToggleButton
{
	public JClassicToggleButton()
	{
		super();
		
		initComponents();
	}
	
	public JClassicToggleButton(Action action)
	{
		super(action);
		
		initComponents();
	}
	
	public JClassicToggleButton(Icon icon)
	{
		super(icon);
		
		initComponents();
	}
	
	public JClassicToggleButton(String text)
	{
		super(text);
		
		initComponents();
	}
	
	public JClassicToggleButton(Icon icon, String toolTipText)
	{
		super(icon);
		
		initComponents();
		
		setToolTipText(toolTipText);
	}
	
	public JClassicToggleButton(Icon icon, boolean selected)
	{
		super(icon);
		
		initComponents();
		
		setSelected(selected);
	}
	
	public JClassicToggleButton(String text, String toolTipText)
	{
		super(text);
		
		initComponents();
		
		setToolTipText(toolTipText);
	}
	
	public JClassicToggleButton(String text, boolean selected)
	{
		super(text);
		
		initComponents();
		
		setSelected(selected);
	}
	
	public JClassicToggleButton(String text, Icon icon)
	{
		super(text, icon);
		
		initComponents();
	}
	
	public JClassicToggleButton(Icon icon, String toolTipText, boolean selected)
	{
		super(icon);
		
		initComponents();
		
		setSelected(selected);
		setToolTipText(toolTipText);
	}
	
	public JClassicToggleButton(String text, String toolTipText, boolean selected)
	{
		super(text);
		
		initComponents();
		
		setSelected(selected);
		setToolTipText(toolTipText);
	}
	
	public JClassicToggleButton(String text, Icon icon, String toolTipText)
	{
		super(text, icon);
		
		initComponents();
		
		setToolTipText(toolTipText);
	}
	
	public JClassicToggleButton(String text, Icon icon, boolean selected)
	{
		super(text, icon);
		
		initComponents();
		
		setSelected(selected);
	}
	
	public JClassicToggleButton(String text, Icon icon, String toolTipText, boolean selected)
	{
		super(text, icon);
		
		initComponents();
		
		setSelected(selected);
		setToolTipText(toolTipText);
	}
	
	private void initComponents()
	{
		ButtonManager.setPreferenceStyle(this);
	}
}