package com.nepxion.swing.style.menu;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicMenuItemUI;

import com.nepxion.swing.checkbox.ILiteCheckBoxModel;
import com.nepxion.swing.menuitem.JLiteCheckBoxMenuItem;

public class AbstractCheckBoxMenuItemUI
	extends BasicMenuItemUI
{
	protected Icon armedIcon;
	protected Icon pressedIcon;
	protected Icon rolloverIcon;
	protected Icon disableIcon;
	protected Icon normalIcon;
	
	protected Icon selectionArmedIcon;
	protected Icon selectionPressedIcon;
	protected Icon selectionRolloverIcon;
	protected Icon selectionDisableIcon;
	protected Icon selectionNormalIcon;
	
	public AbstractCheckBoxMenuItemUI()
	{
		super();
	}
	
	public void paint(Graphics g, JComponent c)
	{
		JLiteCheckBoxMenuItem checkBoxMenuItem = (JLiteCheckBoxMenuItem) c;
		ILiteCheckBoxModel checkBoxModel = (ILiteCheckBoxModel) checkBoxMenuItem.getModel();
		if (checkBoxModel.isEnabled())
		{
			if (checkBoxModel.isArmed())
			{
				if (checkBoxModel.isSelected())
				{
					checkBoxMenuItem.setIcon(selectionArmedIcon);
				}
				else
				{
					checkBoxMenuItem.setIcon(armedIcon);
				}
			}
			else if (checkBoxModel.isPressed())
			{
				if (checkBoxModel.isSelected())
				{
					checkBoxMenuItem.setIcon(selectionPressedIcon);
				}
				else
				{
					checkBoxMenuItem.setIcon(pressedIcon);
				}
			}
			else if (checkBoxModel.isRollover())
			{
				if (checkBoxModel.isSelected())
				{
					checkBoxMenuItem.setIcon(selectionRolloverIcon);
				}
				else
				{
					checkBoxMenuItem.setIcon(rolloverIcon);
				}
			}
			else
			{
				if (checkBoxModel.isSelected())
				{
					checkBoxMenuItem.setIcon(selectionNormalIcon);
				}
				else
				{
					checkBoxMenuItem.setIcon(normalIcon);
				}
			}
		}
		else
		{
			if (checkBoxModel.isSelected())
			{
				checkBoxMenuItem.setDisabledIcon(selectionDisableIcon);
				checkBoxMenuItem.setIcon(selectionDisableIcon);
			}
			else
			{
				checkBoxMenuItem.setDisabledIcon(disableIcon);
				checkBoxMenuItem.setIcon(disableIcon);
			}
		}
		
		super.paint(g, c);
	}
}