package com.nepxion.demo.common;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.util.Iterator;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import javax.swing.table.AbstractTableModel;
import javax.swing.tree.DefaultMutableTreeNode;

import com.nepxion.swing.element.ElementNode;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.popupmenu.JDecorationPopupMenu;
import com.nepxion.swing.renderer.list.ListElementCellRenderer;
import com.nepxion.swing.renderer.table.TableElementCellRenderer;
import com.nepxion.swing.renderer.tree.TreeElementCellRenderer;
import com.nepxion.swing.scrollpane.JBasicScrollPane;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;
import com.nepxion.swing.table.JBasicTable;
import com.nepxion.swing.textarea.JBasicTextArea;
import com.nepxion.swing.tree.JBasicTree;
import com.nepxion.util.data.CollectionUtil;

public class DemoComponentFactory
{
	public static JBasicTree getTree()
	{		
		DefaultMutableTreeNode root = new DefaultMutableTreeNode(DemoDataFactory.getRootElementNode());
		for (Iterator iterator = DemoDataFactory.getComponentElementNodes().iterator(); iterator.hasNext();)
		{
			ElementNode elementNode = (ElementNode) iterator.next();
			DefaultMutableTreeNode treeNode = new DefaultMutableTreeNode(elementNode);
			root.add(treeNode);
			if (elementNode.getChildren() != null)
			{	
				for (Iterator childIterator = elementNode.getChildren().iterator(); childIterator.hasNext();)
				{
					ElementNode childElementNode = (ElementNode) childIterator.next();
					DefaultMutableTreeNode childTreeNode = new DefaultMutableTreeNode(childElementNode);
					treeNode.add(childTreeNode);
				}	
			}
		}	
		
		JBasicTree tree = new JBasicTree(root);
		tree.setCellRenderer(new TreeElementCellRenderer(20));
		tree.expandAll();
		
		return tree;				
	}
	
	public static JBasicTable getTable()
	{		
		JBasicTable table = new JBasicTable(new ElementNodeTableModel());
		table.getTableHeader().setBackground(UIManager.getColor("Panel.background"));
		table.setAutoResizeMode(JBasicTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(2).setCellRenderer(new TableElementCellRenderer());
		return table;
	}
	
	public static class ElementNodeTableModel
		extends AbstractTableModel
	{
		private List rowDatas;
		private String[] columnNames;
		
		public ElementNodeTableModel()
		{
			this.rowDatas = DemoDataFactory.getComponentElementNodes();
			this.columnNames = DemoDataFactory.getComponentNameColumns();
		}
		
		public int getRowCount()
		{
			return rowDatas.size();
		}
		
		public int getColumnCount()
		{
			return columnNames.length;
		}
		
        public String getColumnName(int column)
        {
            return (String) columnNames[column];
        }		
        
        public Class getColumnClass(int column)
        {
        	if (column == 0)
        	{	
        		return Integer.class;
        	}
        	else if (column == 4 || column == 5)
        	{
        		return Boolean.class;
        	}	
        	return String.class;
        }
		
		public Object getValueAt(int row, int column)
		{
			ElementNode elementNode = (ElementNode) rowDatas.get(row);
			switch (column)
			{
				case 0: return new Integer(elementNode.getIndex());
				case 1: return elementNode.getText();
				case 2: return elementNode.getIcon();
				case 3: return elementNode.getToolTipText();
				case 4: return new Boolean(elementNode.isSelected());
				case 5: return new Boolean(elementNode.isEnabled());
				case 6: return elementNode.getUserObject();				
			}
			return null;
		}		
	}
	
	public static JList getList()
	{
		List componentElementNodes = DemoDataFactory.getComponentElementNodes();
		
		JList list = new JList(CollectionUtil.parseVector(componentElementNodes));
		list.setCellRenderer(new ListElementCellRenderer(list, BorderFactory.createEmptyBorder(0, 5, 0, 0), 22));
		
		return list;
	}
	
	public static JEclipseTabbedPane getTabbedPane()
	{
		JEclipseTabbedPane eclipseTabbedPane = new JEclipseTabbedPane();
		eclipseTabbedPane.addTab("Tab 1", IconFactory.getSwingIcon("component/tabbed_pane_16.png"), new JBasicScrollPane(new JBasicTextArea()), "Tab 1", true);					
		eclipseTabbedPane.addTab("Tab 2", IconFactory.getSwingIcon("component/tabbed_pane_16.png"), new JBasicScrollPane(new JBasicTextArea()), "Tab 2", false);
		eclipseTabbedPane.addTab("Tab 3", IconFactory.getSwingIcon("component/tabbed_pane_16.png"), new JBasicScrollPane(new JBasicTextArea()), "Tab 3", true);
		eclipseTabbedPane.addTab("Tab 4", IconFactory.getSwingIcon("component/tabbed_pane_16.png"), new JBasicScrollPane(new JBasicTextArea()), "Tab 4", false);
		eclipseTabbedPane.addTab("Tab 5", IconFactory.getSwingIcon("component/tabbed_pane_16.png"), new JBasicScrollPane(new JBasicTextArea()), "Tab 5", true);
		eclipseTabbedPane.addTab("Tab 6", IconFactory.getSwingIcon("component/tabbed_pane_16.png"), new JBasicScrollPane(new JBasicTextArea()), "Tab 6", false);
		eclipseTabbedPane.addTab("Tab 7", IconFactory.getSwingIcon("component/tabbed_pane_16.png"), new JBasicScrollPane(new JBasicTextArea()), "Tab 7", true);
		eclipseTabbedPane.addTab("Tab 8", IconFactory.getSwingIcon("component/tabbed_pane_16.png"), new JBasicScrollPane(new JBasicTextArea()), "Tab 8", false);		
		
		JDecorationPopupMenu popupMenu = new JDecorationPopupMenu();
		eclipseTabbedPane.setPopupMenu(popupMenu, true);
		
		return eclipseTabbedPane;
	}
	
	public static JDecorationPopupMenu createDecorationPopupMenu()
	{
		JDecorationPopupMenu decorationPopupMenu = new JDecorationPopupMenu();
		
		JMenu menu1 = new JMenu("Menu");
		menu1.setIcon(IconFactory.getSwingIcon("component/menu_16.png"));
		menu1.add(new JMenuItem("MenuItem", IconFactory.getSwingIcon("component/menu_16.png")));
		menu1.add(new JMenuItem("MenuItem", IconFactory.getSwingIcon("component/menu_16.png")));
		decorationPopupMenu.add(menu1);
		
		JMenu menu2 = new JMenu("Menu");
		menu2.setIcon(IconFactory.getSwingIcon("component/popup_menu_16.png"));
		menu2.add(new JMenuItem("MenuItem", IconFactory.getSwingIcon("component/popup_menu_16.png")));
		menu2.add(new JMenuItem("MenuItem", IconFactory.getSwingIcon("component/popup_menu_16.png")));
		decorationPopupMenu.add(menu2);
		
		decorationPopupMenu.addSeparator();
		
		JMenu menu3 = new JMenu("Menu");
		menu3.setIcon(IconFactory.getSwingIcon("component/list_16.png"));
		menu3.add(new JMenuItem("MenuItem", IconFactory.getSwingIcon("component/list_16.png")));
		menu3.add(new JMenuItem("MenuItem", IconFactory.getSwingIcon("component/list_16.png")));
		decorationPopupMenu.add(menu3);
		
		return decorationPopupMenu;
	}		
}