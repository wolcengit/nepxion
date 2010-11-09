package com.nepxion.swing.style.buttonbar;

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

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.plaf.BorderUIResource;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.UIResource;

import com.l2fprod.common.swing.plaf.basic.BasicButtonBarUI;
import com.nepxion.swing.style.button.AbstractButtonUI;

public class ButtonBarUI
	extends BasicButtonBarUI implements IButtonBarUI
{
	private AbstractButtonUI buttonUI;
	
	public ButtonBarUI(AbstractButtonUI buttonUI)
	{
		this.buttonUI = buttonUI;
	}
	
	protected void installDefaults()
	{
		Border border = bar.getBorder();
		if (border == null || border instanceof UIResource)
		{
			bar.setBorder(new BorderUIResource(new CompoundBorder(BorderFactory.createLineBorder(UIManager.getColor("controlDkShadow")), BorderFactory.createEmptyBorder(1, 1, 1, 1))));
		}
		
		Color color = bar.getBackground();
		if (color == null || color instanceof ColorUIResource)
		{
			bar.setOpaque(true);
			bar.setBackground(new ColorUIResource(Color.white));
		}
	}
	
	public void installButtonBarUI(AbstractButton button)
	{
		button.setUI(buttonUI);
		button.setHorizontalTextPosition(JButton.CENTER);
		button.setVerticalTextPosition(JButton.BOTTOM);
		button.setOpaque(false);
	}
	
	public AbstractButtonUI getButtonUI()
	{
		return buttonUI;
	}
}