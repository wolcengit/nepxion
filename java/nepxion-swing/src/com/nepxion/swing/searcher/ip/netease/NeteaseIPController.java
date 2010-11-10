package com.nepxion.swing.searcher.ip.netease;

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

import com.nepxion.swing.action.JAuthorityAction;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.optionpane.JBasicOptionPane;
import com.nepxion.swing.thread.dialog.JThreadDialog;
import com.nepxion.util.searcher.ip.netease.NeteaseIPEntity;
import com.nepxion.util.searcher.ip.netease.NeteaseIPSearcher;

public class NeteaseIPController
{
	public static JAuthorityAction getSearchAction(final JNeteaseIPPanel panel)
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
						NeteaseIPEntity entity = (NeteaseIPEntity) data;
						
						NeteaseIPTableModel tableModel = (NeteaseIPTableModel) panel.getIPTable().getDataModel();
						tableModel.addRow(entity);
					}
					
					protected Object loadBackground()
						throws Exception
					{
						String ip = panel.getIP();
						if (ip.equals(""))
						{
							throw new IllegalArgumentException(SwingLocale.getString("ip_not_null"));
						}
						
						NeteaseIPSearcher searcher = new NeteaseIPSearcher();
						NeteaseIPEntity entity = searcher.search(ip);
						return entity;
					}
				};
				dialog.execute();
			}
		};
		return action;
	}
	
	public static JAuthorityAction getClearAction(final JNeteaseIPTable table)
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
				NeteaseIPTableModel tableModel = (NeteaseIPTableModel) table.getDataModel();
				tableModel.clearRows();
			}
		};
		return action;
	}
}