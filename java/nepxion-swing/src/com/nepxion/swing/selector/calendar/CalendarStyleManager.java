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

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import com.nepxion.swing.dimension.DimensionManager;
import com.nepxion.swing.lookandfeel.LookAndFeelManager;

public class CalendarStyleManager
{
	public static void setPreferenceStyle(JComboBox comboBox)
	{
		if (LookAndFeelManager.isNimbusLookAndFeel())
		{
			JComboBox component = new JComboBox();
			
			comboBox.setBackground(component.getBackground());
			comboBox.setBorder(component.getBorder());
			comboBox.setFocusable(true);
			comboBox.setRequestFocusEnabled(true);
		}
	}
	
	public static void setPreferenceStyle(JButton button)
	{
		if (LookAndFeelManager.isNimbusLookAndFeel())
		{
			DimensionManager.setDimension(button, new Dimension(29, 29));
		}
	}
	
	public static void setPreferenceStyle(JSpinner spinner)
	{
		if (LookAndFeelManager.isNimbusLookAndFeel())
		{
			JTextField component = new JTextField();
			
			spinner.getEditor().setBorder(component.getBorder());
		}
	}
}