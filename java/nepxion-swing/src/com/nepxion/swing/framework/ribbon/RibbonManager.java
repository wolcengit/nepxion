package com.nepxion.swing.framework.ribbon;

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

import com.nepxion.swing.framework.ribbon.action.JRibbonAction;

public class RibbonManager
{		
	public static JRibbonAction createRibbonAction(String name, String text, Icon icon, String toolTipText, String ribbonName, String ribbonTitle, Icon ribbonIcon, String ribbonToolTipText, JRibbonContainer ribbonContainer, Class componentClass)
	{
		JRibbonAction action = new JRibbonAction(name, text, icon, toolTipText);
		action.setRibbonName(ribbonName);
		action.setRibbonTitle(ribbonTitle);
		action.setRibbonIcon(ribbonIcon);
		action.setRibbonToolTipText(ribbonToolTipText);
		action.setRibbonComponentClass(componentClass);
		action.setRibbonContainer(ribbonContainer);
		
		return action;
	}
}