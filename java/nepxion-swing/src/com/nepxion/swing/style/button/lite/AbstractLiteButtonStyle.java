package com.nepxion.swing.style.button.lite;

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

public abstract class AbstractLiteButtonStyle
	implements ILiteButtonStyle
{
	protected Color rolloverBackground;
	protected Color rolloverBorderColor;
	
	protected Color selectionBackground;
	protected Color selectionBorderColor;
	
	protected Color checkColor;
	protected Color focusColor;
	
	public Color getRolloverBackground()
	{
		return rolloverBackground;
	}
	
	public Color getRolloverBorderColor()
	{
		return rolloverBorderColor;
	}
	
	public Color getSelectionBackground()
	{
		return selectionBackground;
	}
	
	public Color getSelectionBorderColor()
	{
		return selectionBorderColor;
	}
	
	public Color getCheckColor()
	{
		return checkColor;
	}
	
	public Color getFocusColor()
	{
		return focusColor;
	}
}