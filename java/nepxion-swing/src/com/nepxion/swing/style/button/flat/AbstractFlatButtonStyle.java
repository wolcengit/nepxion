package com.nepxion.swing.style.button.flat;

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

public abstract class AbstractFlatButtonStyle
	implements IFlatButtonStyle
{
	protected Color brightColor;
	protected Color darkColor;
	
	public Color getBrightColor()
	{
		return brightColor;
	}
	
	public Color getDarkColor()
	{
		return darkColor;
	}
}
