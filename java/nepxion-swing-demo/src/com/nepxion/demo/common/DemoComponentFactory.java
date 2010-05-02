package com.nepxion.demo.common;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.UIManager;

public class DemoComponentFactory
{
	public static JTree getTree()
	{
		JTree tree = new JTree();
		return tree;				
	}
	
	public static JTable getTable()
	{
		Object[][] rows = { 
			{"blue", "basketball", "hot dogs"}, 
			{"violet", "soccer", "pizza"}, 
			{"red", "football", "ravioli"}, {"yellow", "hockey", "bananas"}
		};
		Object[] columns = {"colors", "sports", "food"};
		
		JTable table = new JTable(rows, columns);
		table.getTableHeader().setBackground(UIManager.getColor("control"));
		return table;
	}
}