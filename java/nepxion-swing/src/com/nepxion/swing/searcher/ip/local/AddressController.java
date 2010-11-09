package com.nepxion.swing.searcher.ip.local;

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
import java.util.List;

import com.nepxion.swing.action.JAuthorityAction;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.optionpane.JBasicOptionPane;
import com.nepxion.swing.thread.dialog.JThreadDialog;
import com.nepxion.util.searcher.ip.local.IPSearcher;

public class AddressController
{
	public static JAuthorityAction getSearchAction(final JAddressPanel panel)
	{
		JAuthorityAction action = new JAuthorityAction(SwingLocale.getString("query"), IconFactory.getSwingIcon("solid_search.png"), SwingLocale.getString("ip_to_address"))
		{
			public void execute(ActionEvent e)
			{
				JThreadDialog dialog = new JThreadDialog(HandleManager.getFrame(panel), SwingLocale.getString("ip_to_address"), SwingLocale.getString("query_and_wait"))
				{
					protected void loadForeground(Object data)
						throws Exception
					{
						List entityList = (List) data;
						
						AddressTableModel tableModel = (AddressTableModel) panel.getIPTable().getDataModel();
						tableModel.setRowDatas(entityList);
						
						panel.setCount(entityList.size());
					}
					
					protected Object loadBackground()
						throws Exception
					{
						String address = panel.getAddress();
						
						IPSearcher searcher = IPSearcher.getInstance();
						List entityList = searcher.getIPEntityList(address);
						
						return entityList;
					}
				};
				dialog.execute();
			}
		};
		return action;
	}
	
	public static JAuthorityAction getClearAction(final JAddressTable table)
	{
		JAuthorityAction action = new JAuthorityAction(SwingLocale.getString("clear"), IconFactory.getSwingIcon("solid/delete_16.png"), SwingLocale.getString("clear_query_result"))
		{
			public void execute(ActionEvent e)
			{
				int selectedValue = JBasicOptionPane.showConfirmDialog(HandleManager.getFrame(table), SwingLocale.getString("confirm_to_clear_query_result"), SwingLocale.getString("confirm"), JBasicOptionPane.YES_NO_OPTION);
				if (selectedValue != JBasicOptionPane.YES_OPTION)
				{
					return;
				}
				AddressTableModel tableModel = (AddressTableModel) table.getDataModel();
				tableModel.clearRows();
			}
		};
		return action;
	}
}