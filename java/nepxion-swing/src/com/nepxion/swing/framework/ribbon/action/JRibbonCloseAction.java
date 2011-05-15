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
	private JRibbonContainer ribbonContainer;
	private JRibbonHierarchy ribbonHierarchy;
	
	public JRibbonCloseAction(JRibbonContainer ribbonContainer)
	{
		super(SwingLocale.getString("close_panel"), IconFactory.getSwingIcon("item_close.png"), SwingLocale.getString("close_panel"));
		
		this.ribbonContainer = ribbonContainer;
	}
	
	public JRibbonCloseAction(JRibbonHierarchy ribbonHierarchy)
	{
		super(SwingLocale.getString("close_panel"), IconFactory.getSwingIcon("item_close.png"), SwingLocale.getString("close_panel"));
		
		this.ribbonHierarchy = ribbonHierarchy;
	}
	
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
		
		ribbonContainer.closeRobbinComponent();
	}
}