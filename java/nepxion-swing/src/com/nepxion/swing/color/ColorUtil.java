package com.nepxion.swing.color;

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

public class ColorUtil
{
	public static String transformTo16Bit(int red, int green, int blue)
	{
		return Integer.toHexString(red) + Integer.toHexString(green) + Integer.toHexString(blue);
	}
	
	/**
	 * decode 为 “#CFE2F8” 这种格式
	 * @param decode String
	 * @return Color
	 */
	public static Color getColor(String decode)
	{
		return Color.decode(decode);
	}
	
	public static Color getRandomColor()
	{
		return new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
	}
}