package com.nepxion.swing.searcher.mobile.netease;

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
import com.nepxion.util.searcher.mobile.netease.NeteaseMobileEntity;

public class NeteaseMobileTableModel
	extends BasicTableModel
{
	public static final String[] COLUMN_NAMES = {SwingLocale.getString("mobile"), SwingLocale.getString("province"), SwingLocale.getString("city")};
	
	public NeteaseMobileTableModel(List rowDatas)
	{
		super(rowDatas, COLUMN_NAMES);
	}
	
	public boolean isCellEditable(int row, int column)
	{
		return true;
	}
	
	public Object getValueAt(int row, int column)
	{
		NeteaseMobileEntity entity = (NeteaseMobileEntity) rowDatas.get(row);
		
		switch (column)
		{
			case 0:
				return entity.getMobile();
			case 1:
				return entity.getProvince();
			case 2:
				return entity.getCity();
		}
		
		return null;
	}
	
	public void setValueAt(Object value, int row, int column)
	{
		NeteaseMobileEntity entity = (NeteaseMobileEntity) rowDatas.get(row);
		
		switch (column)
		{
			case 0:
				entity.setMobile(value.toString());
				break;
			case 1:
				entity.setProvince(value.toString());
				break;
			case 2:
				entity.setCity(value.toString());
				break;
		}
		fireTableDataChanged();
	}
}