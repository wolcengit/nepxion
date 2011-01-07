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

import javax.swing.BorderFactory;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.plaf.metal.MetalBorders.ScrollPaneBorder;

public class BorderManager
{
	private static Border scrollPaneBorder;
	
	public static Border createScrollPaneBorder()
	{
		if (scrollPaneBorder == null)
		{
			scrollPaneBorder = UIManager.getBorder("ScrollPane.border");
			if (scrollPaneBorder == null || scrollPaneBorder instanceof ScrollPaneBorder)
			{
				scrollPaneBorder = BorderFactory.createEtchedBorder();
			}
		}
		
		return scrollPaneBorder;
	}
	
	public static Border createTitleBorder(String title)
	{
		return BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), title);
	}
	
	public static Border createTitleBorder(String title, int top, int left, int bottom, int right)
	{
		return BorderFactory.createCompoundBorder(createTitleBorder(title), BorderFactory.createEmptyBorder(top, left, bottom, right));
	}
	
	public static Border createComplexTitleBorder(String title)
	{
		return new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), title);
	}
	
	public static Border createComplexTitleBorder(String title, int top, int left, int bottom, int right)
	{
		return BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(top, left, bottom, right), createComplexTitleBorder(title));
	}
	
	public static Border createLineBorder(Color color, int top, int left, int bottom, int right)
	{
		return BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(top, left, bottom, right), BorderFactory.createLineBorder(color));
	}
}