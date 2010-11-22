package com.nepxion.swing.query.result;

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

import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.optionpane.JBasicOptionPane;
import com.nepxion.swing.panel.JInformationPanel;
import com.nepxion.swing.popupmenu.JDecorationPopupMenu;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;

public class JQueryTabbedPane
	extends JEclipseTabbedPane
{
	public JQueryTabbedPane()
	{
		JInformationPanel informationPanel = new JInformationPanel(SwingLocale.getString("query_description"), IconFactory.getSwingIcon("banner/query_128.png"));
		addTab(SwingLocale.getString("index_page"), IconFactory.getSwingIcon("component/view.png"), informationPanel, SwingLocale.getString("query"), true);
		
		setPopupMenu(new JDecorationPopupMenu(), true);
	}
	
	public void removeTabAt(int index)
	{
		int selectedValue = JBasicOptionPane.showConfirmDialog(HandleManager.getFrame(this), SwingLocale.getString("confirm_to_close_selected_tab"), SwingLocale.getString("confirm"), JBasicOptionPane.YES_NO_OPTION);
		if (selectedValue != JBasicOptionPane.YES_OPTION)
		{
			return;
		}
		
		super.removeTabAt(index);
	}
	
	public JQueryThreadContainer getQueryThreadContainer(int index)
	{
		int tabCount = getTabCount();
		if (tabCount == 0)
		{
			return null;			
		}	
		
		Component component = getComponentAt(index);
		if (component != null && component instanceof JQueryThreadContainer)
		{
			return (JQueryThreadContainer) component;
		}
		
		return null;
	}
	
	public JQueryThreadContainer getLastQueryThreadContainer()
	{
		int index = getTabCount() - 1;
		
		return getQueryThreadContainer(index);
	}
}