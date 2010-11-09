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

import com.nepxion.swing.checkbox.LiteCheckBoxModel;
import com.nepxion.swing.style.button.lite.JAcidLiteButtonStyle;
import com.nepxion.swing.style.menu.AbstractCheckBoxMenuItemUI;
import com.nepxion.swing.style.menu.lite.LiteCheckBoxMenuItemUI;

public class JLiteCheckBoxMenuItem
	extends JMenuItem
{
	public JLiteCheckBoxMenuItem()
	{
		super();
		
		initComponents();
	}
	
	public JLiteCheckBoxMenuItem(Icon icon)
	{
		super(icon);
		
		initComponents();
	}
	
	public JLiteCheckBoxMenuItem(Icon icon, String toolTipText)
	{
		super(icon);
		
		initComponents();
		
		setToolTipText(toolTipText);
	}
	
	public JLiteCheckBoxMenuItem(String text)
	{
		super(text);
		
		initComponents();
	}
	
	public JLiteCheckBoxMenuItem(String text, String toolTipText)
	{
		super(text);
		
		initComponents();
		
		setToolTipText(toolTipText);
	}
	
	public JLiteCheckBoxMenuItem(Action action)
	{
		super(action);
		
		initComponents();
	}
	
	public JLiteCheckBoxMenuItem(String text, Icon icon)
	{
		super(text, icon);
		
		initComponents();
	}
	
	public JLiteCheckBoxMenuItem(String text, Icon icon, String toolTipText)
	{
		super(text, icon);
		
		initComponents();
		
		setToolTipText(toolTipText);
	}
	
	public JLiteCheckBoxMenuItem(String text, boolean selected)
	{
		super(text);
		
		initComponents();
		
		setSelected(selected);
	}
	
	public JLiteCheckBoxMenuItem(String text, String toolTipText, boolean selected)
	{
		super(text);
		
		initComponents();
		
		setSelected(selected);
		setToolTipText(toolTipText);
	}
	
	public JLiteCheckBoxMenuItem(String text, int mnemonic)
	{
		super(text, mnemonic);
		
		initComponents();
	}
	
	public JLiteCheckBoxMenuItem(String text, String toolTipText, int mnemonic)
	{
		super(text, mnemonic);
		
		initComponents();
		
		setToolTipText(toolTipText);
	}
	
	public JLiteCheckBoxMenuItem(String text, int mnemonic, boolean selected)
	{
		super(text, mnemonic);
		
		initComponents();
		
		setSelected(selected);
	}
	
	public JLiteCheckBoxMenuItem(String text, String toolTipText, int mnemonic, boolean selected)
	{
		super(text, mnemonic);
		
		initComponents();
		
		setSelected(selected);
		setToolTipText(toolTipText);
	}
	
	private void initComponents()
	{
		LiteCheckBoxModel checkBoxModel = new LiteCheckBoxModel();
		setModel(checkBoxModel);
		
		AbstractCheckBoxMenuItemUI checkBoxUI = new LiteCheckBoxMenuItemUI(new JAcidLiteButtonStyle());
		setUI(checkBoxUI);
		
		setRolloverEnabled(true);
	}
	
	public void updateUI()
	{
		setUI(getUI());
	}
}