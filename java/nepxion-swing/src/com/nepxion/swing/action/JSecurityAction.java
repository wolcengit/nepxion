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

import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.Icon;
import javax.swing.JToggleButton;

import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.optionpane.JBasicOptionPane;

public abstract class JSecurityAction
	extends JAction
{
	private boolean isPermitted = true;
	
	public JSecurityAction()
	{
		super();
	}
	
	public JSecurityAction(String name)
	{
		super(name);
	}
	
	public JSecurityAction(String name, Icon icon)
	{
		super(name, icon);
	}
	
	public JSecurityAction(String name, String toolTipText)
	{
		super(name, toolTipText);
	}
	
	public JSecurityAction(String name, Icon icon, String toolTipText)
	{
		super(name, icon, toolTipText);
	}
	
	public boolean isPermitted()
	{
		return isPermitted;
	}
	
	public void setPermitted(boolean isPermitted)
	{
		this.isPermitted = isPermitted;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if (isPermitted())
		{
			execute(e);
		}
		else
		{
			Object resource = e.getSource();
			if (resource instanceof Component) // 宿主是JComponent或者AbstractButton
			{
				Component component = (Component) resource;
				JBasicOptionPane.showMessageDialog(HandleManager.getFrame(component), SwingLocale.getString("access_denied"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
				if (resource instanceof JToggleButton)
				{
					JToggleButton button = (JToggleButton) component;
					button.getModel().setSelected(!button.getModel().isSelected()); // 对ToggleButton的判断
				}
			}
		}
	}
	
	public abstract void execute(ActionEvent e);
}