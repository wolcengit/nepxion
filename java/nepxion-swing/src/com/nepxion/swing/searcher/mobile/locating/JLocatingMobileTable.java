package com.nepxion.swing.searcher.mobile.locating;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.util.ArrayList;

import javax.swing.DefaultCellEditor;

import com.nepxion.swing.menuitem.JBasicMenuItem;
import com.nepxion.swing.popupmenu.JDecorationPopupMenu;
import com.nepxion.swing.table.sortable.JSortableTable;
import com.nepxion.swing.textfield.JBasicTextField;

public class JLocatingMobileTable
	extends JSortableTable
{
	private JDecorationPopupMenu popupMenu;
	
	public JLocatingMobileTable()
	{
		super(new LocatingMobileTableModel(new ArrayList()));
		
		setRowHeight(20);
		JBasicTextField textField = new JBasicTextField();
		for (int i = 0; i < this.getColumnCount(); i++)
		{
			getColumnModel().getColumn(i).setCellEditor(new DefaultCellEditor(textField));
		}
		
		popupMenu = new JDecorationPopupMenu();
		JBasicMenuItem clearMenuItem = new JBasicMenuItem(LocatingMobileController.getClearAction(this));
		popupMenu.add(clearMenuItem);
	}
	
	public void executePopupMenu(int selectedRow, int x, int y)
	{
		popupMenu.show(this, x, y);
	}
	
	public void executePopupMenu(int x, int y)
	{
		popupMenu.show(this, x, y);
	}
}