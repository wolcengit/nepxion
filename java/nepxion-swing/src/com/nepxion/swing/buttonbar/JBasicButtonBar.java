package com.nepxion.swing.buttonbar;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import javax.swing.UIManager;

import com.l2fprod.common.swing.JButtonBar;
import com.l2fprod.common.swing.plaf.ButtonBarUI;
import com.nepxion.swing.style.button.AbstractButtonUI;
import com.nepxion.swing.style.button.flat.FlatButtonUI;
import com.nepxion.swing.style.buttonbar.IButtonBarUI;

public class JBasicButtonBar
	extends JButtonBar
{
	public JBasicButtonBar()
	{
		super();
	}
	
	public JBasicButtonBar(int orientation)
	{
		super(orientation);
	}
	
	public void setUI(ButtonBarUI buttonBarUI)
	{
		super.setUI(buttonBarUI);
		
		if (buttonBarUI instanceof IButtonBarUI)
		{
			AbstractButtonUI buttonUI = ((IButtonBarUI) buttonBarUI).getButtonUI();
			if (buttonUI instanceof FlatButtonUI)
			{
				setBackground(UIManager.getColor("Panel.background"));
			}
		}
	}
}