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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.JPanel;

import com.nepxion.swing.framework.ribbon.action.JRibbonAction;
import com.nepxion.swing.framework.ribbon.action.JRibbonToggleFacadeAction;
import com.nepxion.swing.framework.ribbon.action.JRibbonToggleHeightAction;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.menu.JBasicMenu;
import com.nepxion.swing.menuitem.JBasicMenuItem;
import com.nepxion.swing.popupmenu.JDecorationPopupMenu;
import com.nepxion.swing.tabbedpane.ITabbedPane;

public abstract class JRibbonNavigatorBar
	extends JPanel
{
	private int tabHeight = -1;
	private int navigatorBarHeight = -1;

	private JRibbonContainer ribbonContainer;
	private ITabbedPane tabbedPane;
	
	private JDecorationPopupMenu popupMenu;
	
	public JRibbonNavigatorBar(JRibbonContainer ribbonContainer, ITabbedPane tabbedPane)
	{
		this.ribbonContainer = ribbonContainer;
		this.tabbedPane = tabbedPane;
		
		JComponent tabbedComponent = (JComponent) tabbedPane;
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
	
	public int getTabHeight()
	{
		return tabHeight;
	}
	
	public void setTabHeight(int tabHeight)
	{
		this.tabHeight = tabHeight;
	}
	
	public int getNavigatorBarHeight()
	{
		return navigatorBarHeight;
	}
	
	public void setNavigatorBarHeight(int navigatorBarHeight)
	{
		this.navigatorBarHeight = navigatorBarHeight;
	}
	
	public JRibbonContainer getRibbonContainer()
	{
		return ribbonContainer;
	}
	
	public ITabbedPane getTabbedPane()
	{
		return tabbedPane;
	}
}