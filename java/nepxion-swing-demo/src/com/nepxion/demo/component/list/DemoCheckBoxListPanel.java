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

import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.nepxion.demo.common.DemoDataFactory;
import com.nepxion.swing.border.ComplexEtchedBorder;
import com.nepxion.swing.border.ComplexSide;
import com.nepxion.swing.border.ComplexTitleBorder;
import com.nepxion.swing.renderer.list.ListCheckBoxCellRenderer;
import com.nepxion.util.data.CollectionUtil;

public class DemoCheckBoxListPanel
	extends JPanel
{
	public DemoCheckBoxListPanel()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new CheckBoxListPanel());
	}
	
	public class CheckBoxListPanel
		extends JPanel
	{
		public CheckBoxListPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "CheckBox List"));
			
			List componentInstallDatas = DemoDataFactory.getComponentInstallDatas();
			
			JList checkBoxList = new JList(CollectionUtil.parseVector(componentInstallDatas));
			checkBoxList.setCellRenderer(new ListCheckBoxCellRenderer(checkBoxList));
			
			JScrollPane checkBoxListScrollPane = new JScrollPane();
			checkBoxListScrollPane.getViewport().add(checkBoxList);			
			add(checkBoxListScrollPane);			
		}
	}
}