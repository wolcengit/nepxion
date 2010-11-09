package com.nepxion.swing.button;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.Dimension;

public interface IButton
{
	public int getWidthInset();
	
	public void setWidthInset(int widthInset);
	
	public int getHeightInset();
	
	public void setHeightInset(int heightInset);
	
	public void setDimension(Dimension dimension);
}