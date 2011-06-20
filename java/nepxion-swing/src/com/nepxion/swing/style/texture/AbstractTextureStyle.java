package com.nepxion.swing.style.texture;

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

import javax.swing.ImageIcon;

public abstract class AbstractTextureStyle
	implements ITextureStyle
{
	protected ImageIcon backgroundImageIcon;
	protected ImageIcon selectionBackgroundImageIcon;
	
	protected ImageIcon backgroundLeftImageIcon;
	protected ImageIcon selectionBackgroundLeftImageIcon;
	
	protected ImageIcon backgroundRightImageIcon;
	protected ImageIcon selectionBackgroundRightImageIcon;
	
	protected Color foreground;
	protected Color selectionForeground;
	
	protected int height;
	
	public ImageIcon getBackgroundImageIcon()
	{
		return backgroundImageIcon;
	}
	
	public ImageIcon getSelectionBackgroundImageIcon()
	{
		return selectionBackgroundImageIcon;
	}
	
	public ImageIcon getBackgroundLeftImageIcon()
	{
		return backgroundLeftImageIcon;
	}
	
	public ImageIcon getSelectionBackgroundLeftImageIcon()
	{
		return selectionBackgroundLeftImageIcon;
	}
	
	public ImageIcon getBackgroundRightImageIcon()
	{
		return backgroundRightImageIcon;
	}
	
	public ImageIcon getSelectionBackgroundRightImageIcon()
	{
		return selectionBackgroundRightImageIcon;
	}
	
	public Color getForeground()
	{
		return foreground;
	}
	
	public Color getSelectionForeground()
	{
		return selectionForeground;
	}
	
	public int getHeight()
	{
		return height;
	}
}