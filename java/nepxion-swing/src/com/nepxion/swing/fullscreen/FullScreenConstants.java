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

import javax.swing.Icon;

import com.nepxion.swing.button.JBasicButton;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.menuitem.JBasicMenuItem;

public class FullScreenConstants
{
	public static final String TEXT_MAXIMIZE = SwingLocale.getString("maximize");
	public static final String TEXT_MINIMIZE = SwingLocale.getString("minimize");
	public static final String TEXT_RESTORE = SwingLocale.getString("restore");
	public static final String TEXT_CLOSE = SwingLocale.getString("close");
	
	public static final Icon ICON_MAXIMIZE = IconFactory.getSwingIcon("maximize.png");
	public static final Icon ICON_MAXIMIZE_RESTORE = IconFactory.getSwingIcon("maximize_restore.png");
	public static final Icon ICON_MINIMIZE = IconFactory.getSwingIcon("minimize.png");
	public static final Icon ICON_MINIMIZE_RESTORE = IconFactory.getSwingIcon("minimize_restore.png");
	public static final Icon ICON_CLOSE = IconFactory.getSwingIcon("close.png");
	
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