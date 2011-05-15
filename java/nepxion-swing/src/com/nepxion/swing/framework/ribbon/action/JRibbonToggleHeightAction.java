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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.JPanel;

import com.nepxion.swing.action.JSecurityAction;
import com.nepxion.swing.container.ContainerManager;
import com.nepxion.swing.framework.ribbon.JRibbonBar;
import com.nepxion.swing.framework.ribbon.JRibbonHierarchy;
import com.nepxion.swing.framework.ribbon.JRibbonNavigatorBar;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.tabbedpane.ITabbedPane;

public class JRibbonToggleHeightAction
	extends JSecurityAction	implements MouseListener
{
	private JRibbonNavigatorBar ribbonNavigatorBar;
	
	private JRibbonHierarchy ribbonHierarchy;
	
	public JRibbonToggleHeightAction(JRibbonNavigatorBar ribbonNavigatorBar)
	{
		super(IconFactory.getSwingIcon("toggle_size.png"), SwingLocale.getString("toggle_toolbar_visibility"));
		
		this.ribbonNavigatorBar = ribbonNavigatorBar;
	}
	
	public JRibbonToggleHeightAction(JRibbonHierarchy ribbonHierarchy)
	{
		super(IconFactory.getSwingIcon("toggle_size.png"), SwingLocale.getString("toggle_toolbar_visibility"));
		
		this.ribbonHierarchy = ribbonHierarchy;
	}
		
	public void execute(ActionEvent e)
	{
		toggle();
	}
	
	public void mouseClicked(MouseEvent e)
	{
		if (e.getClickCount() > 1)
		{
			toggle();
		}
	}
	
	public void mousePressed(MouseEvent e)
	{
		
	}
	
	public void mouseReleased(MouseEvent e)
	{
		
	}
	
	public void mouseEntered(MouseEvent e)
	{
		
	}
	
	public void mouseExited(MouseEvent e)
	{
		
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
		
		Dimension size = tabbedComponent.getPreferredSize();
		int tabbedPaneHeight = size.height;
		int tabbedPaneWidth = size.width;
		if (tabbedPaneHeight != ribbonNavigatorBar.getTabHeight())
		{
			ribbonNavigatorBar.setNavigatorBarHeight(-1);
			for (int i = 0; i < tabbedPane.getTabCount(); i++)
			{
				JRibbonBar ribbonBar = (JRibbonBar) tabbedPane.getComponentAt(i);
				if (ribbonBar.getPreferredSize().height > ribbonNavigatorBar.getNavigatorBarHeight())
				{
					ribbonNavigatorBar.setNavigatorBarHeight(ribbonBar.getPreferredSize().height);
				}
			}
			
			ribbonNavigatorBar.setTabHeight(tabbedPaneHeight - ribbonNavigatorBar.getNavigatorBarHeight());
			
			tabbedComponent.setPreferredSize(new Dimension(tabbedPaneWidth, ribbonNavigatorBar.getTabHeight()));
		}
		else
		{
			tabbedComponent.setPreferredSize(new Dimension(tabbedPaneWidth, ribbonNavigatorBar.getTabHeight() + ribbonNavigatorBar.getNavigatorBarHeight()));
		}
		
		ContainerManager.update(tabbedComponent);
	}
}