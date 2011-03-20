package com.nepxion.swing.style.button;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.AbstractButton;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicButtonUI;

import com.nepxion.swing.button.IButtonModel;

public abstract class AbstractButtonUI
	extends BasicButtonUI implements IButtonUI
{
	private Color shadow;
	private Color darkShadow;
	
	protected boolean isArrowPainted = true;
	
	public AbstractButtonUI()
	{
		super();
		
		shadow = UIManager.getColor("controlShadow");
		darkShadow = Color.black;
	}
	
	public boolean isArrowPainted()
	{
		return isArrowPainted;
	}
	
	public void setArrowPainted(boolean isArrowPainted)
	{
		this.isArrowPainted = isArrowPainted;
	}
	
	public void installUI(JComponent c)
	{
		super.installUI(c);
		
		AbstractButton button = (AbstractButton) c;
		button.setRolloverEnabled(true);
		button.setBorder(BorderFactory.createEmptyBorder(1, 3, 1, 3));
	}
	
	public void paint(Graphics g, JComponent c)
	{
		AbstractButton button = (AbstractButton) c;
		IButtonModel buttonModel = (IButtonModel) button.getModel();
		
		Action action = button.getAction();
		if (action != null)
		{
			if (!action.isEnabled())
			{
				buttonModel.setEnabled(false);
			}
		}	
		
		Color background = g.getColor();
		if (buttonModel.isMenuDropDown())
		{
			paintMenuDropDown(buttonModel, g, c);
		}
		else if (buttonModel.isPressed())
		{
			paintPressed(buttonModel, g, c);
		}
		else if (buttonModel.isSelected())
		{
			paintSelected(buttonModel, g, c);
		}
		else if (buttonModel.isRollover())
		{
			paintRollover(buttonModel, g, c);
		}
		if (isArrowPainted)
		{
			paintArrow(buttonModel, g, c);
		}
		g.setColor(background);
		
		super.paint(g, c);
	}
	
	public abstract void paintMenuDropDown(IButtonModel buttonModel, Graphics g, JComponent c);
	
	public abstract void paintPressed(IButtonModel buttonModel, Graphics g, JComponent c);
	
	public abstract void paintSelected(IButtonModel buttonModel, Graphics g, JComponent c);
	
	public abstract void paintRollover(IButtonModel buttonModel, Graphics g, JComponent c);
	
	public void paintArrow(IButtonModel buttonModel, Graphics g, JComponent c)
	{
		if (buttonModel.isEnabled())
		{
			g.setColor(darkShadow);
		}
		else
		{
			g.setColor(shadow);
		}
		
		g.drawLine(c.getWidth() - 6 - 2, c.getHeight() / 2 - 1, c.getWidth() - 6 + 2, c.getHeight() / 2 - 1);
		g.drawLine(c.getWidth() - 6 - 1, c.getHeight() / 2, c.getWidth() - 6 + 1, c.getHeight() / 2);
		g.drawLine(c.getWidth() - 6, c.getHeight() / 2 + 1, c.getWidth() - 6, c.getHeight() / 2 + 1);
	}
}