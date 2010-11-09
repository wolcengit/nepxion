package com.nepxion.swing.style.outlookbar;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune хн╨ф╬Э
 * @email hj_ren@msn.com
 * @version 1.0
 */

import com.l2fprod.common.swing.plaf.windows.WindowsOutlookBarUI;

public class JFlatOutlookBarUI
	extends WindowsOutlookBarUI
{
	private JFlatOutlookBarButtonUI buttonUI;
	
	public JFlatOutlookBarUI()
	{
		super();
		
		buttonUI = new JFlatOutlookBarButtonUI();
	}
	
	protected void updateTabButtonAt(int index)
	{
		super.updateTabButtonAt(index);
		TabButton button = buttonForTab(index);
		button.setIconTextGap(5);
		button.setUI(buttonUI);
	}
	
	public JFlatOutlookBarButtonUI getButtonUI()
	{
		return buttonUI;
	}
}