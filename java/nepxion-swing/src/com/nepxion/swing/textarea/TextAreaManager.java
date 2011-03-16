package com.nepxion.swing.textarea;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import javax.swing.JTextArea;

import com.nepxion.swing.color.ColorUtil;

public class TextAreaManager
{
	public static void setLabelStyle(JTextArea textArea)
	{
		textArea.setBorder(null);
		textArea.setBackground(ColorUtil.getUIManagerColor("Panel.background"));
		textArea.setOpaque(false);
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setFocusable(false);
	}
}