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

public class IconContext
	implements IconConstants
{
	private static String iconFolder = "";
	
	public static void registerIconFolder(String iconFolder)
	{
		IconContext.iconFolder = iconFolder;
	}
	
	public static String getIconFolder()
	{
		return iconFolder;
	}
}