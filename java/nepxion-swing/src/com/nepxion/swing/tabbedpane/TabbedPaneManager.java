package com.nepxion.swing.tabbedpane;

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
import java.util.List;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.JTabbedPane;

import com.nepxion.swing.element.ElementNode;
import com.nepxion.swing.element.IElementNode;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.lookandfeel.LookAndFeelManager;
import com.nepxion.swing.optionpane.JBasicOptionPane;
import com.nepxion.swing.selector.checkbox.JCheckBoxSelector;

public class TabbedPaneManager
{
	public static void setPreferenceStyle(JTabbedPane tabbedPane)
	{
		tabbedPane.setFocusable(false);
		
		if (LookAndFeelManager.isNimbusLookAndFeel())
		{	
			if (tabbedPane instanceof JBasicTabbedPane)
			{
				JBasicTabbedPane basicTabbedPane = (JBasicTabbedPane) tabbedPane;
				basicTabbedPane.setDrawBorder(false);
				basicTabbedPane.setDrawCenter(false);
			}
		}
	}
	
	public static void showCloseDialog(ITabbedPane tabbedPane, JCheckBoxSelector checkBoxSelector)
	{
		if (tabbedPane == null)
		{
			return;
		}
		
		Vector slectionElementNodes = new Vector();
		for (int i = 0; i < tabbedPane.getTabCount(); i++)
		{
			if (tabbedPane.isTabClosableAt(i))
			{
				String title = tabbedPane.getTitleAt(i);
				String toolTipText = tabbedPane.getToolTipTextAt(i);
				Icon icon = tabbedPane.getIcon(i);
				Component component = tabbedPane.getComponentAt(i);
				IElementNode elementNode = new ElementNode(title, title, icon, toolTipText, component);
				slectionElementNodes.add(elementNode);
			}
		}
		
		if (slectionElementNodes.size() == 0)
		{
			JBasicOptionPane.showMessageDialog(HandleManager.getFrame((Component) tabbedPane), SwingLocale.getString("no_close_item"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
			
			return;
		}	
		
		if (checkBoxSelector == null)
		{
			checkBoxSelector = new JCheckBoxSelector(HandleManager.getFrame((Component) tabbedPane), SwingLocale.getString("select_close"));
		}
		checkBoxSelector.getCheckBoxList().setListData(slectionElementNodes);
		checkBoxSelector.setVisible(true);
		checkBoxSelector.dispose();
		
		if (checkBoxSelector.isConfirmed())
		{
			List selectedComponents = checkBoxSelector.getSelectedUserObjects();
			if (selectedComponents != null)
			{
				tabbedPane.removeTabs(selectedComponents);
			}
		}
	}
	
	public static int getTabHeight(JTabbedPane tabbedPane)
	{
		int maxContentHeight = getMaxContentHeight(tabbedPane);
		int tabHeight = tabbedPane.getSize().height - maxContentHeight;
		
		return tabHeight;
	}
	
	public static int getPreferredTabHeight(JTabbedPane tabbedPane)
	{
		int maxContentHeight = getMaxPreferredContentHeight(tabbedPane);
		int tabHeight = tabbedPane.getPreferredSize().height - maxContentHeight;
		
		return tabHeight;
	}
	
	public static int getMaxContentHeight(JTabbedPane tabbedPane)
	{
		int contentHeight = -1;
		
		for (int i = 0; i < tabbedPane.getTabCount(); i++)
		{
			Component component = tabbedPane.getComponentAt(i);
			if (component.getSize().height > contentHeight)
			{
				contentHeight = component.getSize().height;
			}
		}
		
		return contentHeight;
	}
	
	public static int getMaxPreferredContentHeight(JTabbedPane tabbedPane)
	{
		int contentHeight = -1;
		
		for (int i = 0; i < tabbedPane.getTabCount(); i++)
		{
			Component component = tabbedPane.getComponentAt(i);
			if (component.getPreferredSize().height > contentHeight)
			{
				contentHeight = component.getPreferredSize().height;
			}
		}
		
		return contentHeight;
	}
}