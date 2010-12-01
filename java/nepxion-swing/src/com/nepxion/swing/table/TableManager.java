package com.nepxion.swing.table;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import javax.swing.JTable;
import javax.swing.table.TableModel;

import com.nepxion.swing.table.sortable.SortableTableModel;

public class TableManager
{
	public static void setPreferenceStyle(JTable table)
	{
		// JTableHeader tableHeader = table.getTableHeader();
		// tableHeader.setPreferredSize(new Dimension(tableHeader.getPreferredSize().width, 18));
		// tableHeader.setBackground(UIManager.getColor("Panel.background"));
		// tableHeader.setReorderingAllowed(false);
	}
	
	public static int getSelectionMode(JTable table)
	{
		return table.getSelectionModel().getSelectionMode();
	}
	
	public static void setSelectionMode(JTable table, int mode)
	{
		table.getSelectionModel().setSelectionMode(mode);
	}
	
	public static ITableModel getModel(JTable table)
	{
		ITableModel model = null;
		
		TableModel tableModel = table.getModel();
		if (tableModel instanceof ITableModel)
		{
			model = (ITableModel) tableModel;
		}
		else if (tableModel instanceof SortableTableModel)
		{
			SortableTableModel sortableTableModel = (SortableTableModel) tableModel;
			TableModel dataModel = sortableTableModel.getDataModel();
			if (dataModel instanceof ITableModel)
			{
				model = (ITableModel) dataModel;
			}
		}
		
		return model;
	}
	
	public static int getRowIndex(JTable table, int row)
	{		
		TableModel tableModel = table.getModel();
		if (tableModel instanceof SortableTableModel)
		{
			SortableTableModel sortableTableModel = (SortableTableModel) tableModel;
			
			int rowIndex = sortableTableModel.getIndexes()[row];
			
			return rowIndex;
		}
		
		return row;
	}
	
	public static int[] getRowIndexes(JTable table, int[] rows)
	{		
		TableModel tableModel = table.getModel();
		if (tableModel instanceof SortableTableModel)
		{
			SortableTableModel sortableTableModel = (SortableTableModel) tableModel;
			
			int[] rowIndexes = new int[rows.length];
			for (int i = 0; i < rows.length; i++)
			{
				int rowIndex = sortableTableModel.getIndexes()[rows[i]];
				rowIndexes[i] = rowIndex;
			}
			
			return rowIndexes;
		}
		
		return rows;
	}	
}