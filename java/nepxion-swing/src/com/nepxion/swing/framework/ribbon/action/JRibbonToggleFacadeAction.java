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
	/**
	 * The instance of JRibbonNavigatorBar.
	 */
	private JRibbonNavigatorBar ribbonNavigatorBar;
	
	/**
	 * The instance of JRibbonHierarchy.
	 */
	private JRibbonHierarchy ribbonHierarchy;
	
	/**
	 * The show type.
	 */
	private String showType;
	
	/**
	 * The show value.
	 */
	private int showValue;
	
	/**
	 * Constructs with the specified initial text, icon, tooltip text, ribbon navigator bar, show type and show value.
	 * @param text the text string
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 * @param ribbonNavigatorBar the instance of JRibbonNavigatorBar
	 * @param showType the show type
	 * @param showValue the show value
	 */
	public JRibbonToggleFacadeAction(String text, Icon icon, String toolTipText, JRibbonNavigatorBar ribbonNavigatorBar, String showType, int showValue)
	{
		super(text, icon, toolTipText);
		
		this.ribbonNavigatorBar = ribbonNavigatorBar;
		this.showType = showType;
		this.showValue = showValue;
	}
	
	/**
	 * Constructs with the specified initial text, icon, tooltip text, ribbon hierarchy, show type and show value.
	 * @param text the text string
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 * @param ribbonHierarchy the instance of JRibbonHierarchy
	 * @param showType the show type
	 * @param showValue the show value
	 */
	public JRibbonToggleFacadeAction(String text, Icon icon, String toolTipText, JRibbonHierarchy ribbonHierarchy, String showType, int showValue)
	{
		super(text, icon, toolTipText);
		
		this.ribbonHierarchy = ribbonHierarchy;
		this.showType = showType;
		this.showValue = showValue;
	}
	
    /**
     * Invoked when an action occurs.
     * @param e the instance of ActionEvent
     */
	public void execute(ActionEvent e)
	{
		toggle();
	}
	
	/**
	 * Toggles the facade.
	 */
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