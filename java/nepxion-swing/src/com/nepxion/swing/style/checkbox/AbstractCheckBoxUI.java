package com.nepxion.swing.style.checkbox;

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
import javax.swing.plaf.basic.BasicCheckBoxUI;

import com.nepxion.swing.checkbox.ILiteCheckBoxModel;
import com.nepxion.swing.checkbox.JLiteCheckBox;

public abstract class AbstractCheckBoxUI
	extends BasicCheckBoxUI
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
	
	public AbstractCheckBoxUI()
	{
		super();
	}
	
	public void paint(Graphics g, JComponent c)
	{
		JLiteCheckBox checkBox = (JLiteCheckBox) c;
		ILiteCheckBoxModel checkBoxModel = (ILiteCheckBoxModel) checkBox.getModel();
		if (checkBoxModel.isEnabled())
		{
			if (checkBoxModel.isArmed())
			{
				if (checkBoxModel.isSelected())
				{
					checkBox.setIcon(selectionArmedIcon);
				}
				else
				{
					checkBox.setIcon(armedIcon);
				}
			}
			else if (checkBoxModel.isPressed())
			{
				if (checkBoxModel.isSelected())
				{
					checkBox.setIcon(selectionPressedIcon);
				}
				else
				{
					checkBox.setIcon(pressedIcon);
				}
			}
			else if (checkBoxModel.isRollover())
			{
				if (checkBoxModel.isSelected())
				{
					checkBox.setIcon(selectionRolloverIcon);
				}
				else
				{
					checkBox.setIcon(rolloverIcon);
				}
			}
			else
			{
				if (checkBoxModel.isSelected())
				{
					checkBox.setIcon(selectionNormalIcon);
				}
				else
				{
					checkBox.setIcon(normalIcon);
				}
			}
		}
		else
		{
			if (checkBoxModel.isSelected())
			{
				checkBox.setDisabledIcon(selectionDisableIcon);
				checkBox.setIcon(selectionDisableIcon);
			}
			else
			{
				checkBox.setDisabledIcon(disableIcon);
				checkBox.setIcon(disableIcon);
			}
		}
		
		super.paint(g, c);
	}
}