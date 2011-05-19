package com.nepxion.swing.framework.ribbon.action;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.event.ActionEvent;

import javax.swing.Icon;
import javax.swing.JPanel;

import com.nepxion.swing.action.JSecurityAction;
import com.nepxion.swing.framework.ribbon.JRibbonHierarchy;
import com.nepxion.swing.framework.ribbon.JRibbonNavigatorBar;

public class JRibbonToggleFacadeAction
	extends JSecurityAction
{
	private JRibbonNavigatorBar ribbonNavigatorBar;
	
	private JRibbonHierarchy ribbonHierarchy;
	
	private String showType;
	private int showValue;
	
	public JRibbonToggleFacadeAction(String text, Icon icon, String toolTipText, JRibbonNavigatorBar ribbonNavigatorBar, String showType, int showValue)
	{
		super(text, icon, toolTipText);
		
		this.ribbonNavigatorBar = ribbonNavigatorBar;
		this.showType = showType;
		this.showValue = showValue;
	}
	
	public JRibbonToggleFacadeAction(String text, Icon icon, String toolTipText, JRibbonHierarchy ribbonHierarchy, String showType, int showValue)
	{
		super(text, icon, toolTipText);
		
		this.ribbonHierarchy = ribbonHierarchy;
		this.showType = showType;
		this.showValue = showValue;
	}
	
	public void execute(ActionEvent e)
	{
		toggle();
	}
	
	private void toggle()
	{
		if (ribbonNavigatorBar == null)
		{
			JPanel navigatorContainer = ribbonHierarchy.getNavigatorContainer();
			
			ribbonNavigatorBar = (JRibbonNavigatorBar) navigatorContainer.getComponent(0);
		}
		
		if (ribbonNavigatorBar == null)
		{
			return;
		}
		
		ribbonNavigatorBar.toggleFacade(showType, showValue);
	}
}