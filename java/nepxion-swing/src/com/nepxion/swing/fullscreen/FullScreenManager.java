package com.nepxion.swing.fullscreen;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import com.nepxion.swing.button.JBasicButton;
import com.nepxion.swing.menuitem.JBasicMenuItem;

public class FullScreenManager
	implements FullScreenConstants
{
	public static JBasicButton createMaximizeButton(boolean isTextVisible)
	{
		JBasicButton button = null;
		if (isTextVisible)
		{
			button = new JBasicButton(TEXT_MAXIMIZE, ICON_MAXIMIZE, TEXT_MAXIMIZE);
		}
		else
		{
			button = new JBasicButton(ICON_MAXIMIZE, TEXT_MAXIMIZE);
		}
		
		return button;
	}
	
	public static JBasicButton createMinimizeButton(boolean isTextVisible)
	{
		JBasicButton button = null;
		if (isTextVisible)
		{
			button = new JBasicButton(TEXT_MINIMIZE, ICON_MINIMIZE, TEXT_MINIMIZE);
		}
		else
		{
			button = new JBasicButton(ICON_MINIMIZE, TEXT_MINIMIZE);
		}
		
		return button;
	}
	
	public static JBasicButton createCloseButton(boolean isTextVisible)
	{
		JBasicButton button = null;
		if (isTextVisible)
		{
			button = new JBasicButton(TEXT_CLOSE, ICON_CLOSE, TEXT_CLOSE);
		}
		else
		{
			button = new JBasicButton(ICON_CLOSE, TEXT_CLOSE);
		}
		
		return button;
	}
	
	public static JBasicMenuItem createMaximizeMenuItem()
	{
		JBasicMenuItem menuItem = new JBasicMenuItem(TEXT_MAXIMIZE, ICON_MAXIMIZE, TEXT_MAXIMIZE);
		
		return menuItem;
	}
	
	public static JBasicMenuItem createMinimizeMenuItem()
	{
		JBasicMenuItem menuItem = new JBasicMenuItem(TEXT_MINIMIZE, ICON_MINIMIZE, TEXT_MINIMIZE);
		
		return menuItem;
	}
	
	public static JBasicMenuItem createCloseMenuItem()
	{
		JBasicMenuItem menuItem = new JBasicMenuItem(TEXT_CLOSE, ICON_CLOSE, TEXT_CLOSE);
		
		return menuItem;
	}
}