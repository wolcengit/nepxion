package com.nepxion.swing.icon;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.net.URL;
import java.util.HashMap;

import javax.swing.ImageIcon;

public class IconFactory
	implements IconConstants
{
	private static HashMap iconPool = new HashMap();
	
	public static ImageIcon getSwingIcon(String iconName)
	{
		return getIcon(SWING_ICON_FOLDER + iconName);
	}
	
	public static ImageIcon getContextIcon(String iconName)
	{
		return getIcon(IconContext.getIconFolder() + iconName);
	}
	
	public static ImageIcon getBlankIcon()
	{
		return getIcon(SWING_BLANK_ICON);
	}
	
	public static ImageIcon getIcon(String iconFullPath)
	{
		Object iconObject = iconPool.get(iconFullPath);
		if (iconObject != null)
		{
			return (ImageIcon) iconObject;
		}
		else
		{
			ImageIcon icon = createIcon(iconFullPath);
			if (icon == null)
			{
				Object blankIconObject = iconPool.get(SWING_BLANK_ICON);
				if (blankIconObject != null)
				{
					return (ImageIcon) blankIconObject;
				}
				else
				{
					iconFullPath = SWING_BLANK_ICON;
					icon = createIcon(iconFullPath);
				}
			}
			iconPool.put(iconFullPath, icon);
			return icon;
		}
	}
	
	private static ImageIcon createIcon(String iconFullPath)
	{
		URL iconURL = IconFactory.class.getClassLoader().getResource(iconFullPath);
		if (iconURL != null)
		{
			return new ImageIcon(iconURL);
		}
		return null;
	}
}