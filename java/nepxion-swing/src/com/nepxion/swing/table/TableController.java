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

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.TableModel;

import com.nepxion.swing.action.JAuthorityAction;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.keystroke.KeyStrokeManager;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.optionpane.JBasicOptionPane;
import com.nepxion.swing.table.sortable.SortableTableModel;
import com.nepxion.util.locale.UtilityLocale;

public class TableController
{
	public static void add(JTable table, ITableAdapter tableAdapter)
	{
		if (!tableAdapter.addRowPermitted())
		{
			JBasicOptionPane.showMessageDialog(HandleManager.getFrame(table), SwingLocale.getString("table") + SwingLocale.getString("add_record_no_permission"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
			return;
		}	
		Object rowData = tableAdapter.addRow();
		if (rowData == null)
		{
			return;
		}
		
		TableModel tableModel = table.getModel();
		if (tableModel instanceof ITableModel)
		{
			ITableModel model = (ITableModel) tableModel;
			model.addRow(rowData);
		}
		else if (tableModel instanceof SortableTableModel)
		{
			SortableTableModel sortableTableModel = (SortableTableModel) tableModel;
			TableModel dataModel = sortableTableModel.getDataModel();
			if (dataModel instanceof ITableModel)
			{
				ITableModel model = (ITableModel) dataModel;
				model.addRow(rowData);
			}
		}
	}
	
	public static void modify(JTable table, ITableAdapter tableAdapter)
	{
		boolean isSingleSelection = isSingleSelection(table, SwingLocale.getString("modify") + SwingLocale.getString("record"));
		if (!isSingleSelection)
		{
			return;
		}
		
		int selectedRow = table.getSelectedRow();
		if (!tableAdapter.modifyRowPermitted(selectedRow))
		{
			JBasicOptionPane.showMessageDialog(HandleManager.getFrame(table), SwingLocale.getString("table_row_selection") + SwingLocale.getString("modify_no_permission"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
			return;
		}	
		Object rowData = tableAdapter.modifyRow(selectedRow);
		if (rowData == null)
		{
			return;
		}
		
		TableModel tableModel = table.getModel();
		if (tableModel instanceof ITableModel)
		{
			ITableModel model = (ITableModel) tableModel;
			model.updateRow(selectedRow, rowData);
		}
		else if (tableModel instanceof SortableTableModel)
		{
			SortableTableModel sortableTableModel = (SortableTableModel) tableModel;
			TableModel dataModel = sortableTableModel.getDataModel();
			if (dataModel instanceof ITableModel)
			{
				ITableModel model = (ITableModel) dataModel;
				model.updateRow(selectedRow, rowData);
			}
		}
	}
	
	public static void delete(JTable table, ITableAdapter tableAdapter)
	{
		boolean isMultiSelection = isMultiSelection(table, SwingLocale.getString("delete") + SwingLocale.getString("record"));
		if (!isMultiSelection)
		{
			return;
		}
		
		int[] selectedRows = table.getSelectedRows();
		if (selectedRows.length == 1)
		{
			int selectedRow = selectedRows[0];
			if (!tableAdapter.deleteRowPermitted(selectedRow))
			{
				JBasicOptionPane.showMessageDialog(HandleManager.getFrame(table), SwingLocale.getString("table_row_selection") + SwingLocale.getString("delete_no_permission"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
				return;
			}
			
			int selectedValue = JBasicOptionPane.showConfirmDialog(HandleManager.getFrame(table), SwingLocale.getString("confirm_to_delete_selected_records"), SwingLocale.getString("confirm"), JBasicOptionPane.YES_NO_OPTION);
			if (selectedValue != JBasicOptionPane.YES_OPTION)
			{
				return;
			}
			
			boolean flag = tableAdapter.deleteRow(selectedRow);
			if (!flag)
			{
				return;
			}
			
			TableModel tableModel = table.getModel();
			if (tableModel instanceof ITableModel)
			{
				ITableModel model = (ITableModel) tableModel;
				model.deleteRow(selectedRow);
			}
			else if (tableModel instanceof SortableTableModel)
			{
				SortableTableModel sortableTableModel = (SortableTableModel) tableModel;
				TableModel dataModel = sortableTableModel.getDataModel();
				if (dataModel instanceof ITableModel)
				{
					int row = sortableTableModel.getIndexes()[selectedRow];
					ITableModel model = (ITableModel) dataModel;
					model.deleteRow(row);
				}
			}
		}
		else
		{
			if (!tableAdapter.deleteRowsPermitted(selectedRows))
			{
				JBasicOptionPane.showMessageDialog(HandleManager.getFrame(table), SwingLocale.getString("table_row_selection") + SwingLocale.getString("delete_no_permission"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
				return;
			}
			
			int selectedValue = JBasicOptionPane.showConfirmDialog(HandleManager.getFrame(table), SwingLocale.getString("confirm_to_delete_selected_records"), SwingLocale.getString("confirm"), JBasicOptionPane.YES_NO_OPTION);
			if (selectedValue != JBasicOptionPane.YES_OPTION)
			{
				return;
			}
			
			boolean flag = tableAdapter.deleteRows(selectedRows);
			if (!flag)
			{
				return;
			}
			
			TableModel tableModel = table.getModel();
			if (tableModel instanceof ITableModel)
			{
				ITableModel model = (ITableModel) tableModel;
				model.deleteRows(selectedRows);
			}
			else if (tableModel instanceof SortableTableModel)
			{
				SortableTableModel sortableTableModel = (SortableTableModel) tableModel;
				TableModel dataModel = sortableTableModel.getDataModel();
				if (dataModel instanceof ITableModel)
				{
					int[] rows = new int[selectedRows.length];
					for (int i = 0; i < selectedRows.length; i++)
					{
						int row = sortableTableModel.getIndexes()[selectedRows[i]];
						rows[i] = row;
					}
					ITableModel model = (ITableModel) dataModel;
					model.deleteRows(rows);
				}
			}
		}
	}
	
	public static void setRowDatas(JTable table, List rowDatas)
	{
		TableModel tableModel = table.getModel();
		if (tableModel instanceof ITableModel)
		{
			ITableModel model = (ITableModel) tableModel;
			model.setRowDatas(rowDatas);
		}
		else if (tableModel instanceof SortableTableModel)
		{
			SortableTableModel sortableTableModel = (SortableTableModel) tableModel;
			TableModel dataModel = sortableTableModel.getDataModel();
			if (dataModel instanceof ITableModel)
			{
				ITableModel model = (ITableModel) dataModel;
				model.setRowDatas(rowDatas);
			}
		}
	}
	
	public static void clear(JTable table, ITableAdapter tableAdapter)
	{
		if (!tableAdapter.clearPermitted())
		{
			JBasicOptionPane.showMessageDialog(HandleManager.getFrame(table), SwingLocale.getString("table") + SwingLocale.getString("clear_no_permission"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
			return;
		}
		
		if (table.getRowCount() == 0)
		{
			JBasicOptionPane.showMessageDialog(HandleManager.getFrame(table), SwingLocale.getString("not_clear_record"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
			return;
		}
		int selectedValue = JBasicOptionPane.showConfirmDialog(HandleManager.getFrame(table), SwingLocale.getString("confirm_to_clear"), SwingLocale.getString("confirm"), JBasicOptionPane.YES_NO_OPTION);
		if (selectedValue != JBasicOptionPane.YES_OPTION)
		{
			return;
		}
		
		boolean flag = tableAdapter.clear();
		if (!flag)
		{
			return;
		}
		
		TableModel tableModel = table.getModel();
		if (tableModel instanceof ITableModel)
		{
			ITableModel model = (ITableModel) tableModel;
			model.clearRows();
		}
		else if (tableModel instanceof SortableTableModel)
		{
			SortableTableModel sortableTableModel = (SortableTableModel) tableModel;
			TableModel dataModel = sortableTableModel.getDataModel();
			if (dataModel instanceof ITableModel)
			{
				ITableModel model = (ITableModel) dataModel;
				model.clearRows();
			}
		}
	}
	
	public static boolean isSingleSelection(JTable table, String operationName)
	{
		int[] selectedRows = table.getSelectedRows();
		if (selectedRows == null || selectedRows.length == 0)
		{
			JBasicOptionPane.showMessageDialog(HandleManager.getFrame(table), SwingLocale.getString("select_records_to") + " " + UtilityLocale.getString("quotation_left") + operationName + UtilityLocale.getString("quotation_right"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
			return false;
		}
		if (selectedRows.length != 1)
		{
			JBasicOptionPane.showMessageDialog(HandleManager.getFrame(table), SwingLocale.getString("select_one_node_to") + " " + UtilityLocale.getString("quotation_left") + operationName + UtilityLocale.getString("quotation_right"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}
	
	public static boolean isMultiSelection(JTable table, String operationName)
	{
		int[] selectedRows = table.getSelectedRows();
		if (selectedRows == null || selectedRows.length == 0)
		{
			JBasicOptionPane.showMessageDialog(HandleManager.getFrame(table), SwingLocale.getString("select_records_to") + " " + UtilityLocale.getString("quotation_left") + operationName + UtilityLocale.getString("quotation_right"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}
	
	public static JAuthorityAction getAddAction(final JTable table, final ITableAdapter tableAdapter)
	{
		JAuthorityAction action = new JAuthorityAction(SwingLocale.getString("add"), IconFactory.getSwingIcon("solid/add_16.png"), SwingLocale.getString("add") + SwingLocale.getString("record"))
		{
			public void execute(ActionEvent e)
			{
				add(table, tableAdapter);
			}
		};
		KeyStrokeManager.registerComponent(table, action, KeyEvent.VK_N, KeyEvent.CTRL_MASK);
		return action;
	}
	
	public static JAuthorityAction getModifyAction(final JTable table, final ITableAdapter tableAdapter)
	{
		JAuthorityAction action = new JAuthorityAction(SwingLocale.getString("modify"), IconFactory.getSwingIcon("solid/confirm_16.png"), SwingLocale.getString("modify") + SwingLocale.getString("record"))
		{
			public void execute(ActionEvent e)
			{
				modify(table, tableAdapter);
			}
		};
		KeyStrokeManager.registerComponent(table, action, KeyEvent.VK_I, KeyEvent.CTRL_MASK);
		return action;
	}
	
	public static JAuthorityAction getDeleteAction(final JTable table, final ITableAdapter tableAdapter)
	{
		JAuthorityAction action = new JAuthorityAction(SwingLocale.getString("delete"), IconFactory.getSwingIcon("solid/delete_16.png"), SwingLocale.getString("delete") + SwingLocale.getString("record"))
		{
			public void execute(ActionEvent e)
			{
				delete(table, tableAdapter);
			}
		};
		KeyStrokeManager.registerComponent(table, action, KeyEvent.VK_DELETE);
		return action;
	}
	
	public static JAuthorityAction getClearAction(final JTable table, final ITableAdapter tableAdapter)
	{
		JAuthorityAction action = new JAuthorityAction(SwingLocale.getString("clear"), IconFactory.getSwingIcon("solid/delete_16.png"), SwingLocale.getString("clear") + SwingLocale.getString("record"))
		{
			public void execute(ActionEvent e)
			{
				clear(table, tableAdapter);
			}
		};
		return action;
	}
}