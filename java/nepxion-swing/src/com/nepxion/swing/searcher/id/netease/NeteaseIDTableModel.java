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

import java.util.List;

import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.table.BasicTableModel;
import com.nepxion.util.searcher.id.netease.NeteaseIDEntity;

public class NeteaseIDTableModel
	extends BasicTableModel
{
	public static final String[] COLUMN_NAMES = {SwingLocale.getString("id_code"), SwingLocale.getString("location"), SwingLocale.getString("birthday"), SwingLocale.getString("gender")};
	
	public NeteaseIDTableModel(List rowDatas)
	{
		super(rowDatas, COLUMN_NAMES);
	}
	
	public boolean isCellEditable(int row, int column)
	{
		return true;
	}
	
	public Object getValueAt(int row, int column)
	{
		NeteaseIDEntity entity = (NeteaseIDEntity) rowDatas.get(row);
		
		switch (column)
		{
			case 0:
				return entity.getCode();
			case 1:
				return entity.getLocation();
			case 2:
				return entity.getBirthday();
			case 3:
				return entity.getGender();
		}
		
		return null;
	}
	
	public void setValueAt(Object value, int row, int column)
	{
		NeteaseIDEntity entity = (NeteaseIDEntity) rowDatas.get(row);
		
		switch (column)
		{
			case 0:
				entity.setCode(value.toString());
				break;
			case 1:
				entity.setLocation(value.toString());
				break;
			case 2:
				entity.setBirthday(value.toString());
				break;
			case 3:
				entity.setGender(value.toString());
				break;
		}
		
		fireTableDataChanged();
	}
}