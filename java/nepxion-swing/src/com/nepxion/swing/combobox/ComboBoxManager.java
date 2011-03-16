package com.nepxion.swing.combobox;

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

import javax.swing.JComboBox;

import com.nepxion.swing.lookandfeel.LookAndFeelManager;

public class ComboBoxManager
{
	public static void setPreferenceStyle(JComboBox comboBox)
	{
		if (!LookAndFeelManager.isNimbusLookAndFeel())
		{
			comboBox.setBackground(Color.white);
			if (!comboBox.isEditable())
			{
				comboBox.setFocusable(false);
			}
		}	
	}
}