package com.nepxion.swing.textfield;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import javax.swing.JTextField;

public class TextFieldManager
{
	public static void setLabelStyle(JTextField textField)
	{
		textField.setBorder(null);
		textField.setBackground(null);
		textField.setOpaque(false);
		textField.setEditable(false);
		textField.setFocusable(false);
		textField.setRequestFocusEnabled(false);
	}
}