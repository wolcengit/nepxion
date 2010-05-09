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

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.table.AbstractTableModel;
import javax.swing.tree.DefaultMutableTreeNode;

import com.nepxion.swing.common.InstallData;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.popupmenu.JDecorationPopupMenu;
import com.nepxion.swing.renderer.table.TableDecorationCellRenderer;
import com.nepxion.swing.renderer.tree.TreeDecorationCellRenderer;
import com.nepxion.swing.tree.JBasicTree;
import com.nepxion.swing.tree.TreeManager;

public class DemoComponentFactory
{
	public static JTree getTree()
	{		
		DefaultMutableTreeNode root = new DefaultMutableTreeNode(DemoDataFactory.getRootInstallData());
		for (Iterator iterator = DemoDataFactory.getComponentInstallDatas().iterator(); iterator.hasNext();)
		{
			InstallData installData = (InstallData) iterator.next();
			DefaultMutableTreeNode treeNode = new DefaultMutableTreeNode(installData);
			root.add(treeNode);
			if (installData.getChildren() != null)
			{	
				for (Iterator childIterator = installData.getChildren().iterator(); childIterator.hasNext();)
				{
					InstallData childInstallData = (InstallData) childIterator.next();
					DefaultMutableTreeNode childTreeNode = new DefaultMutableTreeNode(childInstallData);
					treeNode.add(childTreeNode);
				}	
			}
		}	
		
		JBasicTree tree = new JBasicTree(root);
		tree.setCellRenderer(new TreeDecorationCellRenderer(20));
		TreeManager.expandAll(tree);
		
		return tree;				
	}
	
	public static JTable getTable()
	{		
		JTable table = new JTable(new InstallDataTableModel());
		table.getTableHeader().setBackground(UIManager.getColor("control"));
		table.getColumnModel().getColumn(2).setCellRenderer(new TableDecorationCellRenderer(TableDecorationCellRenderer.LEFT));
		return table;
	}
	
	public static class InstallDataTableModel
		extends AbstractTableModel
	{
		private List rowDatas;
		private String[] columnTitles;
		
		public InstallDataTableModel()
		{
			this.rowDatas = DemoDataFactory.getComponentInstallDatas();
			this.columnTitles = DemoDataFactory.getComponentNameColumns();
		}
		
		public int getRowCount()
		{
			return rowDatas.size();
		}
		
		public int getColumnCount()
		{
			return columnTitles.length;
		}
		
        public String getColumnName(int column)
        {
            return (String) columnTitles[column];
        }		
		
		public Object getValueAt(int row, int column)
		{
			InstallData installData = (InstallData) rowDatas.get(row);
			switch (column)
			{
				case 0: return installData.getIndex() + "";
				case 1: return installData.getText();
				case 2: return installData.getIcon();
				case 3: return installData.getToolTipText();
				case 4: return installData.getUserObject();
				case 5: return new Boolean(installData.isSelected());
				case 6: return new Boolean(installData.isEnabled());
				case 7: return installData.getChildren();
			}
			return null;
		}		
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