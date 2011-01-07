package com.nepxion.swing.style.uidefaults;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import javax.swing.DefaultCellEditor;
import javax.swing.table.TableModel;

import com.nepxion.swing.table.resizable.RowHeightResizer;
import com.nepxion.swing.table.sortable.JSortableTable;
import com.nepxion.swing.textfield.JBasicTextField;

public class UIDefaultsTable
	extends JSortableTable
{
	public UIDefaultsTable()
	{
		setAutoResizeMode(AUTO_RESIZE_OFF);
		setRowHeight(20);
		
		new RowHeightResizer(this, 20, 30);
	}
	
	public void setDataModel(TableModel model)
	{
		super.setDataModel(model);
		
		if (model instanceof UIDefaultsTableModel)
		{
			JBasicTextField textField = new JBasicTextField();
			getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(textField));
			getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(textField));
			getColumnModel().getColumn(2).setCellRenderer(new UIDefaultsTableCellRenderer());
		}
	}
}