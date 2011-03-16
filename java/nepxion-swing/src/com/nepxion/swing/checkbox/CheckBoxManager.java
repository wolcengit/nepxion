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

import javax.swing.JCheckBox;

import com.nepxion.swing.lookandfeel.LookAndFeelManager;

public class CheckBoxManager
{
	public static void setPreferenceStyle(JCheckBox checkBox)
	{
		if (!LookAndFeelManager.isNimbusLookAndFeel())
		{
			checkBox.setFocusable(false);
			checkBox.setRequestFocusEnabled(false);
		}	
	}
}
