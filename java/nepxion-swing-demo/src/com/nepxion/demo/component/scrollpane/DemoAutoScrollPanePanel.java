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

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.table.AbstractTableModel;

import com.nepxion.swing.border.ComplexEtchedBorder;
import com.nepxion.swing.border.ComplexSide;
import com.nepxion.swing.border.ComplexTitleBorder;
import com.nepxion.swing.scrollpane.JAutoRollScrollPane;
import com.nepxion.swing.table.JBasicTable;

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
			setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "Auto ScrollPane"));
			
			JBasicTable table = new JBasicTable(new AbstractTableModel()
			{
				public int getRowCount()
				{
					return 50;
				}
				
				public int getColumnCount()
				{
					return 50;
				}
				
				public boolean isCellEditable(int rowIndex, int columnIndex)
				{
					return false;
				}
				
				public Object getValueAt(int rowIndex, int columnIndex)
				{
					return "" + rowIndex + "," + columnIndex;
				}
			}
			);
			table.setAutoResizeMode(JBasicTable.AUTO_RESIZE_OFF);
			
			JAutoRollScrollPane autoRollScrollPane = new JAutoRollScrollPane();
			autoRollScrollPane.getViewport().add(table);
			
			add(autoRollScrollPane, BorderLayout.CENTER);
		}
	}
}