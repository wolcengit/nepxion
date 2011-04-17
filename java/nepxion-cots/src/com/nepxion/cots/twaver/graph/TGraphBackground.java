package com.nepxion.cots.twaver.graph;

/**
 * <p>Title: Nepxion Cots For TWaver</p>
 * <p>Description: Nepxion Cots Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * <p>Announcement: It depends on the commercial software of TWaver, the repository only references the trial version.</p>
 * <p>If you want to use Nepxion Cots, please contact with Serva Corporation to buy the genuine version.</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.Color;

import twaver.network.background.ColorBackground;

public class TGraphBackground
	extends ColorBackground
{	
	public static final Color BLUE_STYLE_COLOR = new Color(172, 193, 212);
	public static final Color GREEN_STYLE_COLOR = new Color(170, 190, 160);
	
	public TGraphBackground(Color color, Color gradientColor)
	{
		setColor(color);
		setGradientColor(gradientColor);
		setGradient(true);	
	}
}