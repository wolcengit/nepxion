package com.nepxion.swing.ui.explorer;

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

import com.nepxion.swing.table.JBasicTable;
import com.nepxion.swing.table.resizable.RowHeightResizer;
import com.nepxion.swing.textfield.JBasicTextField;

public class UIExplorerTable
	extends JBasicTable
{
	public UIExplorerTable()
	{
		setAutoResizeMode(AUTO_RESIZE_OFF);
		setRowHeight(25);
		
		new RowHeightResizer(this, 25, 40);
	}
	
	public void setModel(TableModel model)
	{
		super.setModel(model);
		
		if (model instanceof UIExplorerTableModel)
		{
			JBasicTextField textField = new JBasicTextField();
			getColumn(0).setCellEditor(new DefaultCellEditor(textField));
			getColumn(1).setCellEditor(new DefaultCellEditor(textField));
			getColumn(2).setCellRenderer(new UIExplorerTableCellRenderer());
		}
	}
}