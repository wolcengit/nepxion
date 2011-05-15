package com.nepxion.demo.component.scrollpane;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.table.AbstractTableModel;

import com.nepxion.swing.border.BorderManager;
import com.nepxion.swing.scrollpane.JAutoRollScrollPane;
import com.nepxion.swing.table.sortable.JSortableTable;

public class DemoAutoScrollPanePanel
	extends JPanel
{
	public DemoAutoScrollPanePanel()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new AutoScrollPanePanel());
	}
	
	public class AutoScrollPanePanel
		extends JPanel
	{
		public AutoScrollPanePanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitledBorder("Auto ScrollPane"));
			
			JSortableTable table = new JSortableTable(new AbstractTableModel()
			{
				public int getRowCount()
				{
					return 100;
				}
				
				public int getColumnCount()
				{
					return 100;
				}
				
				public boolean isCellEditable(int rowIndex, int columnIndex)
				{
					return false;
				}
				
				public String getColumnName(int column)
				{
					return column + "";
				}
				
				public Class getColumnClass(int column)
				{
					return String.class;
				}
				
				public Object getValueAt(int rowIndex, int columnIndex)
				{
					return "" + rowIndex + "," + columnIndex;
				}
			}
			);
			table.setAutoResizeMode(JSortableTable.AUTO_RESIZE_OFF);
			
			JAutoRollScrollPane autoRollScrollPane = new JAutoRollScrollPane();
			autoRollScrollPane.setViewportBorder(BorderManager.createLineBorder(Color.gray, 0, 0, 0, 0));
			autoRollScrollPane.getViewport().add(table);
			
			add(autoRollScrollPane);
		}
	}
}