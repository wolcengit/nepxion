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

import com.jidesoft.swing.PartialGradientLineBorder;

public class ComplexGradientLineBorder
	extends PartialGradientLineBorder
{
	public ComplexGradientLineBorder(Color[] colors)
	{
		super(colors);
	}
	
	public ComplexGradientLineBorder(Color[] colors, int thickness)
	{
		super(colors, thickness);
	}
	
	public ComplexGradientLineBorder(Color[] colors, int thickness, int sides)
	{
		super(colors, thickness, sides);
	}
}
