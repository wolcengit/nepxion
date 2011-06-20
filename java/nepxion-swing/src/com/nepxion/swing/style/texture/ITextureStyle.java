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

public interface ITextureStyle
{	
	public ImageIcon getBackgroundImageIcon();
	
	public ImageIcon getSelectionBackgroundImageIcon();
	
	public ImageIcon getBackgroundLeftImageIcon();
	
	public ImageIcon getSelectionBackgroundLeftImageIcon();
	
	public ImageIcon getBackgroundRightImageIcon();
	
	public ImageIcon getSelectionBackgroundRightImageIcon();
	
	public Color getForeground();
	
	public Color getSelectionForeground();
	
	public int getHeight();
}