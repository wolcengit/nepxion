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

import com.nepxion.swing.action.JSecurityAction;
import com.nepxion.swing.framework.ribbon.JRibbonContainer;
import com.nepxion.swing.framework.ribbon.JRibbonHierarchy;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.locale.SwingLocale;

public class JRibbonCloseAction
	extends JSecurityAction
{
	/**
	 * The instance of JRibbonContainer.
	 */
	private JRibbonContainer ribbonContainer;
	
	/**
	 * The instance of JRibbonHierarchy.
	 */
	private JRibbonHierarchy ribbonHierarchy;
	
	/**
	 * Constructs with the specified initial ribbon container.
	 * @param ribbonContainer the instance of JRibbonContainer
	 */
	public JRibbonCloseAction(JRibbonContainer ribbonContainer)
	{
		super(SwingLocale.getString("close_panel"), IconFactory.getSwingIcon("item_close.png"), SwingLocale.getString("close_panel"));
		
		this.ribbonContainer = ribbonContainer;
	}
	
	/**
	 * Constructs with the specified initial ribbon hierarchy.
	 * @param ribbonHierarchy the instance of JRibbonHierarchy
	 */
	public JRibbonCloseAction(JRibbonHierarchy ribbonHierarchy)
	{
		super(SwingLocale.getString("close_panel"), IconFactory.getSwingIcon("item_close.png"), SwingLocale.getString("close_panel"));
		
		this.ribbonHierarchy = ribbonHierarchy;
	}
	
    /**
     * Invoked when an action occurs.
     * @param e the instance of ActionEvent
     */
	public void execute(ActionEvent e)
	{
		if (ribbonContainer == null)
		{
			ribbonContainer = ribbonHierarchy.getRibbonContainer();
		}
		
		if (ribbonContainer == null)
		{
			return;
		}
		
		ribbonContainer.closeRibbonComponent();
	}
}