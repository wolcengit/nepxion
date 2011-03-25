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

import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.nepxion.swing.action.JSecurityAction;
import com.nepxion.swing.container.ContainerManager;
import com.nepxion.swing.framework.ribbon.JRibbonBar;
import com.nepxion.swing.framework.ribbon.JRibbonHierarchy;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.locale.SwingLocale;

public class JRibbonToggleAction
	extends JSecurityAction
{
	private JTabbedPane tabbedPane;
	private JRibbonHierarchy ribbonHierarchy;
	
	public JRibbonToggleAction(JTabbedPane tabbedPane)
	{
		super(IconFactory.getSwingIcon("toggle_size.png"), SwingLocale.getString("toggle_toolbar_visibility"));
		
		this.tabbedPane = tabbedPane;
	}
	
	public JRibbonToggleAction(JRibbonHierarchy ribbonHierarchy)
	{
		super(IconFactory.getSwingIcon("toggle_size.png"), SwingLocale.getString("toggle_toolbar_visibility"));
		
		this.ribbonHierarchy = ribbonHierarchy;
	}
	
	public void execute(ActionEvent e)
	{
		if (tabbedPane == null)
		{
			JPanel toolBar = ribbonHierarchy.getToolBar();
			
			tabbedPane = (JTabbedPane) toolBar.getComponent(0);
		}
		
		if (tabbedPane == null)
		{
			return;
		}
		
		int tabbedPaneHeight = tabbedPane.getSize().height;
		int tabbedPaneWidth = tabbedPane.getSize().width;
		if (tabbedPaneHeight != RibbonToggleContext.getTabHeight())
		{
			for (int i = 0; i < tabbedPane.getTabCount(); i++)
			{
				JRibbonBar ribbonBar = (JRibbonBar) tabbedPane.getComponentAt(i);
				if (ribbonBar.getSize().height > RibbonToggleContext.getRobbinBarHeight())
				{
					RibbonToggleContext.setRobbinBarHeight(ribbonBar.getSize().height);
				}
			}
			
			RibbonToggleContext.setTabHeight(tabbedPaneHeight - RibbonToggleContext.getRobbinBarHeight());
			
			tabbedPane.setPreferredSize(new Dimension(tabbedPaneWidth, RibbonToggleContext.getTabHeight()));
		}
		else
		{
			tabbedPane.setPreferredSize(new Dimension(tabbedPaneWidth, RibbonToggleContext.getTabHeight() + RibbonToggleContext.getRobbinBarHeight()));
		}
		
		ContainerManager.update(tabbedPane);
	}
}