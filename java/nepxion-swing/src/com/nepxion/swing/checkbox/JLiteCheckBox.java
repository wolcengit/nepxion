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

import com.nepxion.swing.style.button.lite.JEclipseLiteButtonStyle;
import com.nepxion.swing.style.checkbox.lite.LiteCheckBoxUI;

public class JLiteCheckBox
	extends JBasicCheckBox
{
	public JLiteCheckBox()
	{
		super();
		
		initComponents();
	}
	
	public JLiteCheckBox(Icon icon)
	{
		super(icon);
		
		initComponents();
	}
	
	public JLiteCheckBox(Icon icon, String toolTipText)
	{
		super(icon);
		
		initComponents();
		
		setToolTipText(toolTipText);
	}
	
	public JLiteCheckBox(Icon icon, boolean selected)
	{
		super(icon, selected);
		
		initComponents();
	}
	
	public JLiteCheckBox(Icon icon, String toolTipText, boolean selected)
	{
		super(icon, selected);
		
		initComponents();
		
		setToolTipText(toolTipText);
	}
	
	public JLiteCheckBox(String text)
	{
		super(text);
		
		initComponents();
	}
	
	public JLiteCheckBox(String text, String toolTipText)
	{
		super(text);
		
		initComponents();
		
		setToolTipText(toolTipText);
	}
	
	public JLiteCheckBox(Action action)
	{
		super(action);
		
		initComponents();
	}
	
	public JLiteCheckBox(String text, boolean selected)
	{
		super(text, selected);
		
		initComponents();
	}
	
	public JLiteCheckBox(String text, String toolTipText, boolean selected)
	{
		super(text, selected);
		
		initComponents();
		
		setToolTipText(toolTipText);
	}
	
	public JLiteCheckBox(String text, Icon icon)
	{
		super(text, icon);
		
		initComponents();
	}
	
	public JLiteCheckBox(String text, String toolTipText, Icon icon)
	{
		super(text, icon);
		
		initComponents();
		
		setToolTipText(toolTipText);
	}
	
	public JLiteCheckBox(String text, Icon icon, boolean selected)
	{
		super(text, icon, selected);
		
		initComponents();
	}
	
	public JLiteCheckBox(String text, Icon icon, String toolTipText, boolean selected)
	{
		super(text, icon, selected);
		
		initComponents();
		
		setToolTipText(toolTipText);
	}
	
	private void initComponents()
	{
		LiteCheckBoxModel checkBoxModel = new LiteCheckBoxModel();
		checkBoxModel.setSelected(isSelected());
		setModel(checkBoxModel);
		
		LiteCheckBoxUI checkBoxUI = new LiteCheckBoxUI(new JEclipseLiteButtonStyle());
		setUI(checkBoxUI);
		
		setRolloverEnabled(true);
	}
	
	public void updateUI()
	{
		setUI(getUI());
	}
}