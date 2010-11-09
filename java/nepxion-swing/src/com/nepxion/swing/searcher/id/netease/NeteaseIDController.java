package com.nepxion.swing.searcher.id.netease;

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
import com.nepxion.util.searcher.id.netease.NeteaseIDEntity;
import com.nepxion.util.searcher.id.netease.NeteaseIDSearcher;

public class NeteaseIDController
{
	public static JAuthorityAction getSearchAction(final JNeteaseIDPanel panel)
	{
		JAuthorityAction action = new JAuthorityAction(SwingLocale.getString("query"), IconFactory.getSwingIcon("solid_search.png"), SwingLocale.getString("id_code_to_info"))
		{
			public void execute(ActionEvent e)
			{
				JThreadDialog dialog = new JThreadDialog(HandleManager.getFrame(panel), SwingLocale.getString("id_code_to_info"), SwingLocale.getString("query_and_wait"))
				{
					protected void loadForeground(Object data)
						throws Exception
					{
						NeteaseIDEntity entity = (NeteaseIDEntity) data;
						
						NeteaseIDTableModel tableModel = (NeteaseIDTableModel) panel.getIDTable().getDataModel();
						tableModel.addRow(entity);
					}
					
					protected Object loadBackground()
						throws Exception
					{
						String id = panel.getID();
						if (id.equals(""))
						{
							throw new IllegalArgumentException(SwingLocale.getString("id_code_not_null"));
						}
						
						if (id.length() != 15 && id.length() != 18)
						{
							throw new IllegalArgumentException(SwingLocale.getString("id_code_length_15_or_18"));
						}
						
						NeteaseIDSearcher searcher = new NeteaseIDSearcher();
						NeteaseIDEntity entity = searcher.search(id);
						return entity;
					}
				};
				dialog.execute();
			}
		};
		return action;
	}
	
	public static JAuthorityAction getClearAction(final JNeteaseIDTable table)
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
				NeteaseIDTableModel tableModel = (NeteaseIDTableModel) table.getDataModel();
				tableModel.clearRows();
			}
		};
		return action;
	}
}