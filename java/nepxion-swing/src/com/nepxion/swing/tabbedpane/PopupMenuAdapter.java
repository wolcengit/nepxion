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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.JPopupMenu;

import com.nepxion.swing.element.ElementNode;
import com.nepxion.swing.element.IElementNode;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.menuitem.JBasicMenuItem;
import com.nepxion.swing.optionpane.JBasicOptionPane;
import com.nepxion.swing.selector.checkbox.JCheckBoxSelector;
import com.nepxion.util.locale.UtilityLocale;

public class PopupMenuAdapter
{
	private JBasicMenuItem closeMenuItem;
	private JBasicMenuItem closeAllMenuItem;
	private JBasicMenuItem closeOthersMenuItem;
	private JBasicMenuItem closeSelectedMenuItem;
	
	private JCheckBoxSelector checkBoxSelector;
	
	private ITabbedPane tabbedPane;
	
	public PopupMenuAdapter(final ITabbedPane tabbedPane, JPopupMenu popupMenu)
	{
		this.tabbedPane = tabbedPane;
		
		closeMenuItem = new JBasicMenuItem(IconFactory.getSwingIcon("item_close.png"));
		closeMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int selectedIndex = tabbedPane.getSelectedIndex();
				tabbedPane.removeTabAt(selectedIndex);
			}
		}
		);
		popupMenu.add(closeMenuItem);
		
		closeAllMenuItem = new JBasicMenuItem(SwingLocale.getString("close_all"), IconFactory.getSwingIcon("item_close_all.png"), SwingLocale.getString("close_all"));
		closeAllMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int selectedValue = JBasicOptionPane.showConfirmDialog(HandleManager.getFrame((Component) tabbedPane), SwingLocale.getString("confirm_to_close_all_tabs"), SwingLocale.getString("confirm"), JBasicOptionPane.YES_NO_OPTION);
				if (selectedValue == JBasicOptionPane.YES_OPTION)
				{
					tabbedPane.removeAllTabs();
				}
			}
		}
		);
		popupMenu.add(closeAllMenuItem);
		
		closeOthersMenuItem = new JBasicMenuItem(IconFactory.getBlankIcon());
		closeOthersMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int selectedValue = JBasicOptionPane.showConfirmDialog(HandleManager.getFrame((Component) tabbedPane), SwingLocale.getString("confirm_to_close_others_tabs"), SwingLocale.getString("confirm"), JBasicOptionPane.YES_NO_OPTION);
				if (selectedValue == JBasicOptionPane.YES_OPTION)
				{
					int selectedIndex = tabbedPane.getSelectedIndex();
					tabbedPane.removeReverseTabsAt(selectedIndex);
				}
			}
		}
		);
		popupMenu.add(closeOthersMenuItem);
		
		closeSelectedMenuItem = new JBasicMenuItem(SwingLocale.getString("close_selected"), IconFactory.getBlankIcon(), SwingLocale.getString("close_selected"));
		closeSelectedMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
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
				
				if (checkBoxSelector == null)
				{
					checkBoxSelector = new JCheckBoxSelector(HandleManager.getFrame((Component) tabbedPane), SwingLocale.getString("select_close_tabs"));
				}
				checkBoxSelector.getCheckBoxList().setListData(slectionElementNodes);
				checkBoxSelector.setVisible(true);
				
				if (checkBoxSelector.isConfirmed())
				{
					List selectedComponents = checkBoxSelector.getSelectedUserObjects();
					if (selectedComponents != null)
					{
						tabbedPane.removeTabs(selectedComponents);
					}
				}
			}
		}
		);
		popupMenu.add(closeSelectedMenuItem);
	}
	
	public void adaptClosableItem(int selectedIndex)
	{
		String text = tabbedPane.getTitleAt(selectedIndex);
		boolean isTabClosable = tabbedPane.isTabClosableAt(selectedIndex);
		closeMenuItem.setEnabled(isTabClosable);
		
		closeMenuItem.setText(SwingLocale.getString("close") + " " + UtilityLocale.getString("quotation_left") + text + UtilityLocale.getString("quotation_right"));
		closeMenuItem.setToolTipText(SwingLocale.getString("close") + " " + UtilityLocale.getString("quotation_left") + text + UtilityLocale.getString("quotation_right"));
		closeOthersMenuItem.setText(SwingLocale.getString("close_all_except") + " " + UtilityLocale.getString("quotation_left") + text + UtilityLocale.getString("quotation_right"));
		closeOthersMenuItem.setToolTipText(SwingLocale.getString("close_all_except") + " " + UtilityLocale.getString("quotation_left") + text + UtilityLocale.getString("quotation_right"));
	}
}