package com.nepxion.swing.style.button.lite;

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

public class JAcidLiteButtonStyle
	extends AbstractLiteButtonStyle
{
	public static final String ID = JAcidLiteButtonStyle.class.getName();
	
	public JAcidLiteButtonStyle()
	{
		rolloverBackground = new Color(225, 226, 163, 180);
		rolloverBorderColor = new Color(157, 159, 74, 225);
		
		selectionBackground = new Color(225, 226, 163);
		selectionBorderColor = new Color(157, 159, 74);
		
		checkColor = new Color(85, 109, 54);
		focusColor = new Color(225, 152, 88);
	}
}