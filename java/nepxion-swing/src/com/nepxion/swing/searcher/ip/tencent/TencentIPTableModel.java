package com.nepxion.swing.searcher.ip.tencent;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.util.List;

import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.table.BasicTableModel;
import com.nepxion.util.searcher.ip.tencent.TencentIPEntity;

public class TencentIPTableModel
	extends BasicTableModel
{
	public static final String[] COLUMN_NAMES = {SwingLocale.getString("ip"), SwingLocale.getString("address")};
	
	public TencentIPTableModel(List rowDatas)
	{
		super(rowDatas, COLUMN_NAMES);
	}
	
	public boolean isCellEditable(int row, int column)
	{
		return true;
	}
	
	public Object getValueAt(int row, int column)
	{
		TencentIPEntity entity = (TencentIPEntity) rowDatas.get(row);
		
		switch (column)
		{
			case 0 :
				return entity.getIP();
			case 1 :
				return entity.getLocation();
		}
		
		return null;
	}
}