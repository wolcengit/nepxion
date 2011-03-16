package com.nepxion.swing.popupmenu;

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

import javax.swing.JPopupMenu;

import com.nepxion.swing.border.LineBorder;
import com.nepxion.swing.lookandfeel.LookAndFeelManager;

public class PopupMenuManager
{
	public static void setPreferenceStyle(JPopupMenu popupMenu)
	{
		if (LookAndFeelManager.isNimbusLookAndFeel())
		{
			popupMenu.setBorder(new LineBorder(new Color(89, 89, 89), 1));
		}	
	}
	
	public static void setPreferenceStyle(JDraggablePopupMenu popupMenu)
	{
		if (LookAndFeelManager.isNimbusLookAndFeel())
		{
			popupMenu.setBorder(new LineBorder(new Color(89, 89, 89), 1));
		}	
	}
	
	public static int getMargin()
	{
		if (LookAndFeelManager.isNimbusLookAndFeel())
		{
			return 1;
		}
		else
		{
			return 2;
		}
	}
}