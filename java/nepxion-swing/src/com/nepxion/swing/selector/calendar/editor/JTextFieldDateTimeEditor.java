package com.nepxion.swing.selector.calendar.editor;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import com.toedter.calendar.JTextFieldDateEditor;

public class JTextFieldDateTimeEditor
	extends JTextFieldDateEditor
{
	public JTextFieldDateTimeEditor()
	{
		super();
	}
	
	public JTextFieldDateTimeEditor(String datePattern, String maskPattern, char placeholder)
	{
		super(datePattern, maskPattern, placeholder);
	}
	
	public JTextFieldDateTimeEditor(boolean showMask, String datePattern, String maskPattern, char placeholder)
	{
		super(showMask, datePattern, maskPattern, placeholder);
	}
}