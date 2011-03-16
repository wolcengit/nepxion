package com.nepxion.swing.selector.calendar;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import javax.swing.JComboBox;

import com.nepxion.swing.lookandfeel.LookAndFeelManager;

public class CalendarStyleManager
{
	public static void setPreferenceStyle(JComboBox comboBox)
	{
		if (LookAndFeelManager.isNimbusLookAndFeel())
		{
			JComboBox box = new JComboBox();
			
			comboBox.setBackground(box.getBackground());
			comboBox.setBorder(box.getBorder());
			comboBox.setFocusable(true);
			comboBox.setRequestFocusEnabled(true);			
		}
	}
}