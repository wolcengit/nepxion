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
	/**
	 * The instance of Border for scrollPane border.
	 */
	private static Border scrollPaneBorder;
	
	/**
	 * Creates the scrollPane border.
	 * @return the instance of Border
	 */
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
	
	/**
	 * Creates the titled border.
	 * @param title the title string
	 * @return the instance of Border
	 */
	public static Border createTitledBorder(String title)
	{
		return BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), title);
	}
	
	/**
	 * Creates the titled border with the empty border inside.
	 * @param title the title string
	 * @param top the top value
	 * @param left the left value
	 * @param bottom the bottom value
	 * @param right the right value
	 * @return the instance of Border
	 */
	public static Border createTitledBorder(String title, int top, int left, int bottom, int right)
	{
		return BorderFactory.createCompoundBorder(createTitledBorder(title), BorderFactory.createEmptyBorder(top, left, bottom, right));
	}
	
	/**
	 * Creates the complex titled border.
	 * @param title the title string
	 * @return the instance of Border
	 */
	public static Border createComplexTitledBorder(String title)
	{
		return new ComplexTitledBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), title);
	}
	
	/**
	 * Creates the complex titled border with the empty border outside.
	 * @param title the title string
	 * @param top the top value
	 * @param left the left value
	 * @param bottom the bottom value
	 * @param right the right value
	 * @return the instance of Border
	 */
	public static Border createComplexTitledBorder(String title, int top, int left, int bottom, int right)
	{
		return BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(top, left, bottom, right), createComplexTitledBorder(title));
	}
	
	/**
	 * Creates the line border with the empty border outside.
	 * @param color the instance of Color
	 * @param top the top value
	 * @param left the left value
	 * @param bottom the bottom value
	 * @param right the right value
	 * @return the instance of Border
	 * @return
	 */
	public static Border createLineBorder(Color color, int top, int left, int bottom, int right)
	{
		return BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(top, left, bottom, right), BorderFactory.createLineBorder(color));
	}
}