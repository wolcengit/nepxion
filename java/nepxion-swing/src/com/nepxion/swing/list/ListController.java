package com.nepxion.swing.list;

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

import com.nepxion.swing.action.JSecurityAction;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.keystroke.KeyStrokeManager;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.optionpane.JBasicOptionPane;
import com.nepxion.swing.thread.dialog.JThreadDialog;
import com.nepxion.util.data.CollectionUtil;

public class ListController
{
	public static void add(JBasicList list, IListAdapter listAdapter)
	{
		if (!listAdapter.addRowPermitted())
		{
			JBasicOptionPane.showMessageDialog(HandleManager.getFrame(list), SwingLocale.getString("list") + SwingLocale.getString("add_record_no_permission"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
			
			return;
		}
		
		Object rowData = listAdapter.addRow();
		if (rowData == null)
		{
			return;
		}
		
		BasicListModel listModel = (BasicListModel) list.getModel();
		listModel.addElement(rowData);
	}
	
	public static void modify(JBasicList list, IListAdapter listAdapter)
	{
		boolean isSingleSelection = isSingleSelection(list, SwingLocale.getString("modify") + SwingLocale.getString("record"));
		if (!isSingleSelection)
		{
			return;
		}
		
		int selectedRow = list.getSelectedIndex();
		if (!listAdapter.modifyRowPermitted(selectedRow))
		{
			JBasicOptionPane.showMessageDialog(HandleManager.getFrame(list), SwingLocale.getString("list_row_selection") + SwingLocale.getString("modify_no_permission"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
			
			return;
		}
		
		Object rowData = listAdapter.modifyRow(selectedRow);
		if (rowData == null)
		{
			return;
		}
		
		BasicListModel listModel = (BasicListModel) list.getModel();
		listModel.setElementAt(rowData, selectedRow);
	}
	
	public static void delete(JBasicList list, IListAdapter listAdapter)
	{
		boolean isMultiSelection = isMultiSelection(list, SwingLocale.getString("delete") + SwingLocale.getString("record"));
		if (!isMultiSelection)
		{
			return;
		}
		
		int[] selectedRows = list.getSelectedIndexes();
		if (selectedRows.length == 1)
		{
			int selectedRow = selectedRows[0];
			if (!listAdapter.deleteRowPermitted(selectedRow))
			{
				JBasicOptionPane.showMessageDialog(HandleManager.getFrame(list), SwingLocale.getString("list_row_selection") + SwingLocale.getString("delete_no_permission"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
				
				return;
			}
			
			int selectedValue = JBasicOptionPane.showConfirmDialog(HandleManager.getFrame(list), SwingLocale.getString("confirm_to_delete_selected_records"), SwingLocale.getString("confirm"), JBasicOptionPane.YES_NO_OPTION);
			if (selectedValue != JBasicOptionPane.YES_OPTION)
			{
				return;
			}
			
			boolean flag = listAdapter.deleteRow(selectedRow);
			if (!flag)
			{
				return;
			}
			
			BasicListModel listModel = (BasicListModel) list.getModel();
			listModel.remove(selectedRow);
		}
		else
		{
			if (!listAdapter.deleteRowsPermitted(selectedRows))
			{
				JBasicOptionPane.showMessageDialog(HandleManager.getFrame(list), SwingLocale.getString("list_row_selection") + SwingLocale.getString("delete_no_permission"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
				
				return;
			}
			
			int selectedValue = JBasicOptionPane.showConfirmDialog(HandleManager.getFrame(list), SwingLocale.getString("confirm_to_delete_selected_records"), SwingLocale.getString("confirm"), JBasicOptionPane.YES_NO_OPTION);
			if (selectedValue != JBasicOptionPane.YES_OPTION)
			{
				return;
			}
			
			boolean flag = listAdapter.deleteRows(selectedRows);
			if (!flag)
			{
				return;
			}
			
			BasicListModel listModel = (BasicListModel) list.getModel();
			listModel.removeElements(selectedRows);
		}
	}
	
	public static void refresh(final JBasicList list, final IListAdapter listAdapter)
	{
		if (!listAdapter.refreshPermitted())
		{
			JBasicOptionPane.showMessageDialog(HandleManager.getFrame(list), SwingLocale.getString("list") + SwingLocale.getString("refresh_no_permission"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
			
			return;
		}
		
		if (list.getListData().size() == 0)
		{
			JBasicOptionPane.showMessageDialog(HandleManager.getFrame(list), SwingLocale.getString("not_refresh_record"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
			
			return;
		}
		
		int selectedValue = JBasicOptionPane.showConfirmDialog(HandleManager.getFrame(list), SwingLocale.getString("confirm_to_refresh"), SwingLocale.getString("confirm"), JBasicOptionPane.YES_NO_OPTION);
		if (selectedValue != JBasicOptionPane.YES_OPTION)
		{
			return;
		}
		
		JThreadDialog dialog = new JThreadDialog(HandleManager.getFrame(list), SwingLocale.getString("refresh"), SwingLocale.getString("refresh_and_wait"))
		{
			protected void loadForeground(Object data)
				throws Exception
			{
				List rowDatas = (List) data;
				
				list.setListData(CollectionUtil.parseVector(rowDatas));
			}
			
			protected Object loadBackground()
				throws Exception
			{
				List rowDatas = listAdapter.refresh();
				
				return rowDatas;
			}
		};
		dialog.execute();
	}
	
	public static void clear(JBasicList list, IListAdapter listAdapter)
	{
		if (!listAdapter.clearPermitted())
		{
			JBasicOptionPane.showMessageDialog(HandleManager.getFrame(list), SwingLocale.getString("list") + SwingLocale.getString("clear_no_permission"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
			
			return;
		}
		
		if (list.getListData().size() == 0)
		{
			JBasicOptionPane.showMessageDialog(HandleManager.getFrame(list), SwingLocale.getString("not_clear_record"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
			
			return;
		}
		
		int selectedValue = JBasicOptionPane.showConfirmDialog(HandleManager.getFrame(list), SwingLocale.getString("confirm_to_clear"), SwingLocale.getString("confirm"), JBasicOptionPane.YES_NO_OPTION);
		if (selectedValue != JBasicOptionPane.YES_OPTION)
		{
			return;
		}
		
		boolean flag = listAdapter.clear();
		if (!flag)
		{
			return;
		}
		
		BasicListModel listModel = (BasicListModel) list.getModel();
		listModel.clear();
	}
	
	public static boolean isSingleSelection(JBasicList list, String operationName)
	{
		int[] selectedRows = list.getSelectedIndexes();
		if (selectedRows == null || selectedRows.length == 0)
		{
			JBasicOptionPane.showMessageDialog(HandleManager.getFrame(list), SwingLocale.getString("select_records_to") + " " + SwingLocale.getString("quotation_left") + operationName + SwingLocale.getString("quotation_right"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
			
			return false;
		}
		
		if (selectedRows.length != 1)
		{
			JBasicOptionPane.showMessageDialog(HandleManager.getFrame(list), SwingLocale.getString("select_one_node_to") + " " + SwingLocale.getString("quotation_left") + operationName + SwingLocale.getString("quotation_right"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
			
			return false;
		}
		
		return true;
	}
	
	public static boolean isMultiSelection(JBasicList list, String operationName)
	{
		int[] selectedRows = list.getSelectedIndexes();
		if (selectedRows == null || selectedRows.length == 0)
		{
			JBasicOptionPane.showMessageDialog(HandleManager.getFrame(list), SwingLocale.getString("select_records_to") + " " + SwingLocale.getString("quotation_left") + operationName + SwingLocale.getString("quotation_right"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
			
			return false;
		}
		
		return true;
	}
	
	public static JSecurityAction getAddAction(final JBasicList list, final IListAdapter listAdapter)
	{
		JSecurityAction action = new JSecurityAction(SwingLocale.getString("add"), IconFactory.getSwingIcon("stereo/add_16.png"), SwingLocale.getString("add") + SwingLocale.getString("record"))
		{
			public void execute(ActionEvent e)
			{
				add(list, listAdapter);
			}
		};
		KeyStrokeManager.registerComponent(list, action, KeyEvent.VK_N, KeyEvent.CTRL_MASK);
		
		return action;
	}
	
	public static JSecurityAction getModifyAction(final JBasicList list, final IListAdapter listAdapter)
	{
		JSecurityAction action = new JSecurityAction(SwingLocale.getString("modify"), IconFactory.getSwingIcon("stereo/confirm_16.png"), SwingLocale.getString("modify") + SwingLocale.getString("record"))
		{
			public void execute(ActionEvent e)
			{
				modify(list, listAdapter);
			}
		};
		KeyStrokeManager.registerComponent(list, action, KeyEvent.VK_I, KeyEvent.CTRL_MASK);
		
		return action;
	}
	
	public static JSecurityAction getDeleteAction(final JBasicList list, final IListAdapter listAdapter)
	{
		JSecurityAction action = new JSecurityAction(SwingLocale.getString("delete"), IconFactory.getSwingIcon("stereo/delete_16.png"), SwingLocale.getString("delete") + SwingLocale.getString("record"))
		{
			public void execute(ActionEvent e)
			{
				delete(list, listAdapter);
			}
		};
		KeyStrokeManager.registerComponent(list, action, KeyEvent.VK_DELETE);
		
		return action;
	}
	
	public static JSecurityAction getRefreshAction(final JBasicList list, final IListAdapter listAdapter)
	{
		JSecurityAction action = new JSecurityAction(SwingLocale.getString("refresh"), IconFactory.getSwingIcon("stereo/refresh_16.png"), SwingLocale.getString("refresh") + SwingLocale.getString("record"))
		{
			public void execute(ActionEvent e)
			{
				refresh(list, listAdapter);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getClearAction(final JBasicList list, final IListAdapter listAdapter)
	{
		JSecurityAction action = new JSecurityAction(SwingLocale.getString("clear"), IconFactory.getSwingIcon("stereo/delete_16.png"), SwingLocale.getString("clear") + SwingLocale.getString("record"))
		{
			public void execute(ActionEvent e)
			{
				clear(list, listAdapter);
			}
		};
		
		return action;
	}
}