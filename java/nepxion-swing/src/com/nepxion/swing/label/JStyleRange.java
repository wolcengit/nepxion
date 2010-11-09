package com.nepxion.swing.label;

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
import java.awt.Stroke;

import com.jidesoft.swing.StyleRange;

public class JStyleRange
	extends StyleRange
{
	public JStyleRange(int fontStyle)
	{
		super(fontStyle);
	}
	
	public JStyleRange(Color fontColor)
	{
		super(fontColor);
	}
	
	public JStyleRange(int fontStyle, Color fontColor)
	{
		super(fontStyle, fontColor);
	}
	
	public JStyleRange(int fontStyle, int additionalStyle)
	{
		super(fontStyle, additionalStyle);
	}
	
	public JStyleRange(int fontStyle, int additionalStyle, float fontShrinkRatio)
	{
		super(fontStyle, additionalStyle, fontShrinkRatio);
	}
	
	public JStyleRange(int start, int length, int fontStyle)
	{
		super(start, length, fontStyle);
	}
	
	public JStyleRange(int start, int length, int fontStyle, Color fontColor)
	{
		super(start, length, fontStyle, fontColor);
	}
	
	public JStyleRange(int start, int length, Color fontColor)
	{
		super(start, length, fontColor);
	}
	
	public JStyleRange(int start, int length, int fontStyle, int additionalStyle)
	{
		super(start, length, fontStyle, additionalStyle);
	}
	
	public JStyleRange(int start, int length, int fontStyle, int additionalStyle, float fontShrinkRatio)
	{
		super(start, length, fontStyle, additionalStyle, fontShrinkRatio);
	}
	
	public JStyleRange(int fontStyle, Color fontColor, int additionalStyle, Color lineColor)
	{
		super(fontStyle, fontColor, additionalStyle, lineColor);
	}
	
	public JStyleRange(int fontStyle, Color fontColor, Color backgroundColor, int additionalStyle, Color lineColor)
	{
		super(fontStyle, fontColor, backgroundColor, additionalStyle, lineColor);
	}
	
	public JStyleRange(int start, int length, int fontStyle, Color fontColor, int additionalStyle)
	{
		super(start, length, fontStyle, fontColor, additionalStyle);
	}
	
	public JStyleRange(int start, int length, int fontStyle, Color fontColor, Color backgroundColor, int additionalStyle)
	{
		super(start, length, fontStyle, fontColor, backgroundColor, additionalStyle);
	}
	
	public JStyleRange(int fontStyle, Color fontColor, int additionalStyle, Color lineColor, Stroke lineStroke)
	{
		super(fontStyle, fontColor, additionalStyle, lineColor, lineStroke);
	}
	
	public JStyleRange(int start, int length, int fontStyle, Color fontColor, int additionalStyle, Color lineColor)
	{
		super(start, length, fontStyle, fontColor, additionalStyle, lineColor);
	}
	
	public JStyleRange(int start, int length, int fontStyle, Color fontColor, Color backgroundColor, int additionalStyle, Color lineColor)
	{
		super(start, length, fontStyle, fontColor, backgroundColor, additionalStyle, lineColor);
	}
	
	public JStyleRange(int start, int length, int fontStyle, Color fontColor, int additionalStyle, Color lineColor, Stroke lineStroke)
	{
		super(start, length, fontStyle, fontColor, additionalStyle, lineColor, lineStroke);
	}
	
	public JStyleRange(int start, int length, int fontStyle, Color fontColor, Color backgroundColor, int additionalStyle, Color lineColor, Stroke lineStroke)
	{
		super(start, length, fontStyle, fontColor, backgroundColor, additionalStyle, lineColor, lineStroke);
	}
	
	public JStyleRange(int start, int length, int fontStyle, Color fontColor, int additionalStyle, Color lineColor, Stroke lineStroke, float fontShrinkRatio)
	{
		super(start, length, fontStyle, fontColor, additionalStyle, lineColor, lineStroke, fontShrinkRatio);
	}
	
	public JStyleRange(int start, int length, int fontStyle, Color fontColor, Color backgroundColor, int additionalStyle, Color lineColor, Stroke lineStroke, float fontShrinkRatio)
	{
		super(start, length, fontStyle, fontColor, backgroundColor, additionalStyle, lineColor, lineStroke, fontShrinkRatio);
	}
}