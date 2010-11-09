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

public class ComplexTitleBorder
	extends JideTitledBorder
{
	public ComplexTitleBorder(String title)
	{
		super(title);
	}
	
	public ComplexTitleBorder(Border border)
	{
		super(border);
	}
	
	public ComplexTitleBorder(Border border, String title)
	{
		super(border, title);
	}
	
	public ComplexTitleBorder(Border border, String title, int titleJustification, int titlePosition)
	{
		super(border, title, titleJustification, titlePosition);
	}
	
	public ComplexTitleBorder(Border border, String title, int titleJustification, int titlePosition, Font titleFont)
	{
		super(border, title, titleJustification, titlePosition, titleFont);
	}
	
	public ComplexTitleBorder(Border border, String title, int titleJustification, int titlePosition, Font titleFont, Color titleColor)
	{
		super(border, title, titleJustification, titlePosition, titleFont, titleColor);
	}
}