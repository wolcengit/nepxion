package com.nepxion.demo.component.pagination;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTable;

import com.nepxion.swing.border.BorderManager;
import com.nepxion.swing.pagination.PaginationBar;
import com.nepxion.swing.pagination.PaginationContext;
import com.nepxion.swing.table.JBasicTable;

public class DemoTablePaginationPanel
	extends JPanel
{
	public DemoTablePaginationPanel()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new TablePaginationPanel());
	}
	
	public class TablePaginationPanel
		extends JPanel
	{
		public TablePaginationPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitleBorder("Auto ScrollPane"));
			
		}
	}
	
	public class DemoPaginationBar
		extends PaginationBar
	{
		public DemoPaginationBar(JBasicTable table)
		{
			super(table, new PaginationContext());
		}
		
		public String[] getSortNameList()
		{
			return new String[] {"Name", "Value"};
		}
				
		public void directRowIndex(int rowIndex)
			throws Exception
		{
			JBasicTable table = (JBasicTable) getTable();
//			String sessionID = drTable.getSessionID();
//			int nodeID = drTable.getNodeID();
//			
//			direct(drTable, sessionID, nodeID);
		}
		
		public void directRowCount(int rowCount)
			throws Exception
		{
			JBasicTable table = (JBasicTable) getTable();
//			String sessionID = drTable.getSessionID();
//			int nodeID = drTable.getNodeID();
//			
//			PaginationContext paginationContext = getPaginationContext();
//			paginationContext.setRowCount(rowCount);
//			
//			direct(drTable, sessionID, nodeID);
		}
		
		private void direct(JTable table)
			throws Exception
		{
			PaginationContext paginationContext = getPaginationContext();
//			paginationContext.setTotalRowCount(drTable.getTotalRowCount());
//			
//			int rowIndex = paginationContext.getRowIndex();
//			int rowCount = paginationContext.getRowCount();
			
//			ClientHandle drQueryHandle = ClientHandleFactory.createDRQueryHandle(sessionID, nodeID, rowIndex, rowCount);
//			List drList = KPIParser.parseList(drQueryHandle);
//			
//			drTable.setRowDatas(drList);
			
			updatePagination();
		}
		
		public void sort(String sortName, String sortType)
			throws Exception
		{
			
		}
		
		public void clearRowData()
			throws Exception
		{
			JBasicTable table = (JBasicTable) getTable();
			
		}
	}
}