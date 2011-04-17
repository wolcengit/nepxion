package com.nepxion.cots.twaver.element;

/**
 * <p>Title: Nepxion Cots For TWaver</p>
 * <p>Description: Nepxion Cots Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * <p>Announcement: It depends on the commercial software of TWaver, the repository only references the trial version.</p>
 * <p>If you want to use Nepxion Cots, please contact with Serva Corporation to buy the genuine version.</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import javax.swing.ImageIcon;

import com.nepxion.swing.icon.IconFactory;

public class TIconFactory
	extends IconFactory
{
	public static final String ICON_FOLDER = "com/nepxion/cots/icon/image/";
	
	public static ImageIcon getContextIcon(String iconName)
	{
		return getIcon(ICON_FOLDER + iconName);
	}
}