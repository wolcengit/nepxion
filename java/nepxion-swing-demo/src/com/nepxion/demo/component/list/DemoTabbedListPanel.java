package com.nepxion.demo.component.list;

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
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.nepxion.demo.common.DemoDataFactory;
import com.nepxion.swing.border.ComplexEtchedBorder;
import com.nepxion.swing.border.ComplexSide;
import com.nepxion.swing.border.ComplexTitleBorder;
import com.nepxion.swing.renderer.list.ListTabbedCellRenderer;

public class DemoTabbedListPanel
	extends JPanel
{
	public DemoTabbedListPanel()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new TabbedListPanel());
	}
	
	public class TabbedListPanel
		extends JPanel
	{
		public TabbedListPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "Tabbed List"));
			
			String[] componentDescriptonDatas = DemoDataFactory.getComponentDescriptonDatas();
			
			JList checkBoxList = new JList(componentDescriptonDatas);
			checkBoxList.setCellRenderer(new ListTabbedCellRenderer(550, "\t", new int[] {100, 270}, 50));
			
			JScrollPane checkBoxListScrollPane = new JScrollPane();
			checkBoxListScrollPane.getViewport().add(checkBoxList);
			
			add(checkBoxListScrollPane);			
		}
	}
}