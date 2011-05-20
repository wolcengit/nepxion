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

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.nepxion.swing.container.ContainerManager;
import com.nepxion.swing.framework.ribbon.action.JRibbonAction;
import com.nepxion.swing.framework.ribbon.action.JRibbonToggleFacadeAction;
import com.nepxion.swing.framework.ribbon.action.JRibbonToggleHeightAction;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.menu.JBasicMenu;
import com.nepxion.swing.menuitem.JBasicMenuItem;
import com.nepxion.swing.popupmenu.JDecorationPopupMenu;
import com.nepxion.swing.tabbedpane.ITabbedPane;
import com.nepxion.swing.tabbedpane.TabbedPaneManager;

public abstract class JRibbonNavigatorBar
	extends JPanel
{
	private JRibbonContainer ribbonContainer;
	private ITabbedPane tabbedPane;
	private JTabbedPane tabbedComponent;
	
	private JDecorationPopupMenu popupMenu;
	
	private boolean isBarShown = true;
	
	public JRibbonNavigatorBar(JRibbonContainer ribbonContainer, ITabbedPane tabbedPane)
	{
		this.ribbonContainer = ribbonContainer;
		this.tabbedPane = tabbedPane;
		
		tabbedComponent = (JTabbedPane) tabbedPane;
		tabbedComponent.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
		tabbedComponent.addMouseListener(new JRibbonToggleHeightAction(this));
		tabbedComponent.addMouseListener(new MouseAdapter()
		{
			public void mouseReleased(MouseEvent e)
			{
				if (!e.isPopupTrigger())
				{
					return;
				}
				
				popupMenu.show(e.getComponent(), e.getX(), e.getY());
			}
		}
		);
		tabbedComponent.addComponentListener(new ComponentAdapter()
		{
			public void componentResized(ComponentEvent e)
			{
				adaptDimension();
			}
		}
		);
		
		initPopupMenu();
		
		setLayout(new BorderLayout());
		add(tabbedComponent, BorderLayout.CENTER);
	}
	
	private void initPopupMenu()
	{
		popupMenu = new JDecorationPopupMenu();
		
		JBasicMenu navigatorBarFacadeConfigMenu = new JBasicMenu(SwingLocale.getString("config_navigatorbar_facade"), IconFactory.getSwingIcon("facade.png"), SwingLocale.getString("config_navigatorbar_facade"));
		navigatorBarFacadeConfigMenu.add(new JBasicMenuItem(new JRibbonToggleFacadeAction(SwingLocale.getString("config_navigatorbar_show_small_text"), IconFactory.getSwingIcon("label.png"), SwingLocale.getString("config_navigatorbar_show_small_text"), this, JRibbonAction.TEXT, JRibbonAction.SHOW_SMALL)));
		navigatorBarFacadeConfigMenu.add(new JBasicMenuItem(new JRibbonToggleFacadeAction(SwingLocale.getString("config_navigatorbar_show_large_text"), IconFactory.getSwingIcon("label.png"), SwingLocale.getString("config_navigatorbar_show_large_text"), this, JRibbonAction.TEXT, JRibbonAction.SHOW_LARGE)));
		navigatorBarFacadeConfigMenu.add(new JBasicMenuItem(new JRibbonToggleFacadeAction(SwingLocale.getString("config_navigatorbar_show_no_text"), IconFactory.getBlankIcon(), SwingLocale.getString("config_navigatorbar_show_no_text"), this, JRibbonAction.TEXT, JRibbonAction.SHOW_NO)));
		navigatorBarFacadeConfigMenu.addSeparator();
		navigatorBarFacadeConfigMenu.add(new JBasicMenuItem(new JRibbonToggleFacadeAction(SwingLocale.getString("config_navigatorbar_show_small_icon"), IconFactory.getSwingIcon("rectangle_single.png"), SwingLocale.getString("config_navigatorbar_show_small_icon"), this, JRibbonAction.ICON, JRibbonAction.SHOW_SMALL)));
		navigatorBarFacadeConfigMenu.add(new JBasicMenuItem(new JRibbonToggleFacadeAction(SwingLocale.getString("config_navigatorbar_show_large_icon"), IconFactory.getSwingIcon("rectangle_multi.png"), SwingLocale.getString("config_navigatorbar_show_large_icon"), this, JRibbonAction.ICON, JRibbonAction.SHOW_LARGE)));
		navigatorBarFacadeConfigMenu.add(new JBasicMenuItem(new JRibbonToggleFacadeAction(SwingLocale.getString("config_navigatorbar_show_no_icon"), IconFactory.getBlankIcon(), SwingLocale.getString("config_navigatorbar_show_no_icon"), this, JRibbonAction.ICON, JRibbonAction.SHOW_NO)));
		
		popupMenu.add(navigatorBarFacadeConfigMenu);
		popupMenu.add(new JBasicMenuItem(new JRibbonToggleHeightAction(this)));
	}
	
	public JRibbonContainer getRibbonContainer()
	{
		return ribbonContainer;
	}
	
	public ITabbedPane getTabbedPane()
	{
		return tabbedPane;
	}
	
	public void adaptDimension()
	{		
		int tabHeight = TabbedPaneManager.getTabHeight(tabbedComponent);
		int barHeight = TabbedPaneManager.getMaxPreferredContentHeight(tabbedComponent);
		
		tabbedComponent.setPreferredSize(new Dimension(tabbedComponent.getSize().width, tabHeight + barHeight));
	}
	
	public void toggleHeight()
	{				
		int tabHeight = TabbedPaneManager.getTabHeight(tabbedComponent);
		int barHeight = TabbedPaneManager.getMaxPreferredContentHeight(tabbedComponent);
		
		if (isBarShown)
		{
			tabbedComponent.setPreferredSize(new Dimension(tabbedComponent.getSize().width, tabHeight));
		}
		else
		{
			tabbedComponent.setPreferredSize(new Dimension(tabbedComponent.getSize().width, tabHeight + barHeight));
		}
		
		ContainerManager.update(tabbedComponent);
		
		isBarShown = !isBarShown;
	}
	
	public void toggleFacade(String showType, int showValue)
	{		
		for (int i = 0; i < tabbedPane.getTabCount(); i++)
		{
			JRibbonBar ribbonBar = (JRibbonBar) tabbedPane.getComponentAt(i);
			ribbonBar.toggleFacade(showType, showValue);
		}
		
		if (isBarShown)
		{	
			tabbedComponent.setPreferredSize(null);
			ContainerManager.update(tabbedComponent);
			
			adaptDimension();
		}
	}
}