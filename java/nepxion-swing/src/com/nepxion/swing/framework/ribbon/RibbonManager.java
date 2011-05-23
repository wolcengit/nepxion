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
	public static JRibbonAction createRibbonAction(String text, Icon icon, String toolTipText, String ribbonTitle, Icon ribbonIcon, String ribbonToolTipText, String ribbonComponentClass, JRibbonContainer ribbonContainer)
	{
		return createRibbonAction(null, text, icon, toolTipText, null, ribbonTitle, ribbonIcon, ribbonToolTipText, ribbonComponentClass, ribbonContainer);
	}
	
	public static JRibbonAction createRibbonAction(String name, String text, Icon icon, String toolTipText, String ribbonName, String ribbonTitle, Icon ribbonIcon, String ribbonToolTipText, String ribbonComponentClass, JRibbonContainer ribbonContainer)
	{
		return createRibbonAction(name, text, null, null, icon, null, null, toolTipText, ribbonName, ribbonTitle, ribbonIcon, ribbonToolTipText, ribbonComponentClass, ribbonContainer);
	}
	
	public static JRibbonAction createRibbonAction(String name, String text, String smallText, String largeText, Icon icon, Icon smallIcon, Icon largeIcon, String toolTipText, String ribbonName, String ribbonTitle, Icon ribbonIcon, String ribbonToolTipText, String ribbonComponentClass, JRibbonContainer ribbonContainer)
	{
		JRibbonAction action = new JRibbonAction(name, text, icon, toolTipText);
		action.setSmallText(smallText);
		action.setLargeText(largeText);
		action.setSmallIcon(smallIcon);
		action.setLargeIcon(largeIcon);
		action.setRibbonName(ribbonName);
		action.setRibbonTitle(ribbonTitle);
		action.setRibbonIcon(ribbonIcon);
		action.setRibbonToolTipText(ribbonToolTipText);
		action.setRibbonComponentClass(ribbonComponentClass);
		action.setRibbonContainer(ribbonContainer);
		
		return action;
	}
}