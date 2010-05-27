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

import com.nepxion.demo.common.DemoDataFactory;
import com.nepxion.swing.border.ComplexEtchedBorder;
import com.nepxion.swing.border.ComplexSide;
import com.nepxion.swing.border.ComplexTitleBorder;
import com.nepxion.swing.renderer.list.ListRadioButtonCellRenderer;
import com.nepxion.swing.scrollpane.JBasicScrollPane;
import com.nepxion.util.data.CollectionUtil;

public class DemoRadioButtonListPanel
	extends JPanel
{
	public DemoRadioButtonListPanel()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new RadioButtonListPanel());
	}
	
	public class RadioButtonListPanel
		extends JPanel
	{
		public RadioButtonListPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "RadioButton List"));
			
			List componentInstallDatas = DemoDataFactory.getComponentInstallDatas();
			
			JList radioButtonList = new JList(CollectionUtil.parseVector(componentInstallDatas));
			radioButtonList.setCellRenderer(new ListRadioButtonCellRenderer(radioButtonList));
			
			JBasicScrollPane radioButtonListScrollPane = new JBasicScrollPane();
			radioButtonListScrollPane.getViewport().add(radioButtonList);			
			add(radioButtonListScrollPane);			
		}
	}
}