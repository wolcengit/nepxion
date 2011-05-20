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

import javax.swing.UIManager;

public class ColorUtil
{
	/**
	 * Transforms the rgb color to 16 bit value.
	 * @param red the red value
	 * @param green the green value
	 * @param blue the blue value
	 * @return the 16 bit string
	 */
	public static String transformTo16Bit(int red, int green, int blue)
	{
		return Integer.toHexString(red) + Integer.toHexString(green) + Integer.toHexString(blue);
	}
	
	/**
	 * Gets the color by the decode string. 
	 * The decode string is the same as "#CFE2F8".
	 * @param decode the decode string
	 * @return Color the instance of Color
	 */
	public static Color getColor(String decode)
	{
		return Color.decode(decode);
	}
	
	/**
	 * Gets the color from UIManager.
	 * @param key the key string
	 * @return the instance of Color
	 */
	public static Color getUIManagerColor(String key)
	{
		Color background = UIManager.getColor(key);
		
		return new Color(background.getRed(), background.getGreen(), background.getBlue(), background.getAlpha());
	}
	
	/**
	 * Gets the random color.
	 * @return the instance of Color
	 */
	public static Color getRandomColor()
	{
		return new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
	}
}