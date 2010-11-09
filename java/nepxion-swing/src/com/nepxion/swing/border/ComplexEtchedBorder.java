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

import com.jidesoft.swing.PartialEtchedBorder;

public class ComplexEtchedBorder
	extends PartialEtchedBorder
{
	public ComplexEtchedBorder()
	{
		super();
	}
	
	public ComplexEtchedBorder(int sides)
	{
		super(sides);
	}
	
	public ComplexEtchedBorder(int etchType, int sides)
	{
		super(etchType, sides);
	}
	
	public ComplexEtchedBorder(Color highlight, Color shadow, int sides)
	{
		super(highlight, shadow, sides);
	}
	
	public ComplexEtchedBorder(int etchType, Color highlight, Color shadow, int sides)
	{
		super(etchType, highlight, shadow, sides);
	}
}