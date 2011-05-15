package com.nepxion.swing.border;

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
import java.awt.Font;

import javax.swing.border.Border;

import com.jidesoft.swing.JideTitledBorder;

public class ComplexTitledBorder
	extends JideTitledBorder
{
	/**
	 * 
	 * @param title
	 */
	public ComplexTitledBorder(String title)
	{
		super(title);
	}
	
	/**
	 * 
	 * @param border
	 */
	public ComplexTitledBorder(Border border)
	{
		super(border);
	}
	
	/**
	 * 
	 * @param border
	 * @param title
	 */
	public ComplexTitledBorder(Border border, String title)
	{
		super(border, title);
	}
	
	/**
	 * 
	 * @param border
	 * @param title
	 * @param titleJustification
	 * @param titlePosition
	 */
	public ComplexTitledBorder(Border border, String title, int titleJustification, int titlePosition)
	{
		super(border, title, titleJustification, titlePosition);
	}
	
	/**
	 * 
	 * @param border
	 * @param title
	 * @param titleJustification
	 * @param titlePosition
	 * @param titleFont
	 */
	public ComplexTitledBorder(Border border, String title, int titleJustification, int titlePosition, Font titleFont)
	{
		super(border, title, titleJustification, titlePosition, titleFont);
	}
	
	/**
	 * 
	 * @param border
	 * @param title
	 * @param titleJustification
	 * @param titlePosition
	 * @param titleFont
	 * @param titleColor
	 */
	public ComplexTitledBorder(Border border, String title, int titleJustification, int titlePosition, Font titleFont, Color titleColor)
	{
		super(border, title, titleJustification, titlePosition, titleFont, titleColor);
	}
}