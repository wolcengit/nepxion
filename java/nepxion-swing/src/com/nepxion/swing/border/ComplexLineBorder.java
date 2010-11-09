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

import com.jidesoft.swing.PartialLineBorder;

public class ComplexLineBorder
	extends PartialLineBorder
{
	public ComplexLineBorder(Color color)
	{
		super(color);
	}
	
	public ComplexLineBorder(Color color, int thickness)
	{
		super(color, thickness);
	}
	
	public ComplexLineBorder(Color color, int thickness, boolean roundedCorners)
	{
		super(color, thickness, roundedCorners);
	}
	
	public ComplexLineBorder(Color color, int thickness, int side)
	{
		super(color, thickness, side);
	}
}