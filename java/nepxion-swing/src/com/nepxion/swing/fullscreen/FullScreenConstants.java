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

import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.locale.SwingLocale;

public interface FullScreenConstants
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
	
	public static final String WINDOW_TITLE = "Application";
	public static final String WINDOW_ICON = "view.png";
}