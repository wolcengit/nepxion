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

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.Iterator;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JPanel;

import com.nepxion.swing.action.JAction;
import com.nepxion.swing.action.JSecurityAction;
import com.nepxion.swing.container.ContainerManager;
import com.nepxion.swing.framework.ribbon.JRibbon;
import com.nepxion.swing.framework.ribbon.JRibbonBar;
import com.nepxion.swing.framework.ribbon.JRibbonHierarchy;
import com.nepxion.swing.framework.ribbon.JRibbonNavigatorBar;
import com.nepxion.swing.tabbedpane.ITabbedPane;
import com.nepxion.swing.toolbar.JBasicToolBar;

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
		
		ITabbedPane tabbedPane = ribbonNavigatorBar.getTabbedPane();
		
		JComponent tabbedComponent = (JComponent) tabbedPane;
		
		for (int i = 0; i < tabbedPane.getTabCount(); i++)
		{
			JRibbonBar ribbonBar = (JRibbonBar) tabbedPane.getComponentAt(i);
			toggle(ribbonBar);
		}
		
		tabbedComponent.setPreferredSize(null);
		ContainerManager.update(tabbedComponent);
	}
	
	private void toggle(JRibbonBar ribbonBar)
	{
		List ribbons = ribbonBar.getRibbons();
		for (Iterator iterator = ribbons.iterator(); iterator.hasNext();)
		{
			JRibbon ribbon = (JRibbon) iterator.next();
			
			toogleIcon(ribbon);
		}
	}
	
	private void toogleIcon(JRibbon ribbon)
	{
		JBasicToolBar container = ribbon.getContainer();
		
		for (int i = 0; i < container.getComponentCount(); i++)
		{
			Component ribbonComponent = container.getComponent(i);
			if (ribbonComponent instanceof AbstractButton)
			{
				AbstractButton button = (AbstractButton) ribbonComponent;
				
				Action action = button.getAction();
				if (action instanceof JAction)
				{
					if (showType.equals(JAction.TEXT))
					{
						((JAction) action).showText(showValue);
					}
					else if (showType.equals(JAction.ICON))
					{
						((JAction) action).showIcon(showValue);
					}					
				}
			}
		}
	}
}