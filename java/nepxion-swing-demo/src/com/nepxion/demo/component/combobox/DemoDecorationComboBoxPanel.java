package com.nepxion.demo.component.combobox;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.Dimension;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.nepxion.demo.common.DemoDataFactory;
import com.nepxion.swing.border.ComplexEtchedBorder;
import com.nepxion.swing.border.ComplexSide;
import com.nepxion.swing.border.ComplexTitleBorder;
import com.nepxion.swing.combobox.JBasicComboBox;
import com.nepxion.swing.combobox.JGroupComboBox;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.renderer.combobox.ComboBoxDecorationCellRenderer;
import com.nepxion.util.data.CollectionUtil;

public class DemoDecorationComboBoxPanel
	extends JPanel
{	
	public DemoDecorationComboBoxPanel()
	{
		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new SingleIconComboBoxPanel());
		add(new MultiIconComboBoxPanel());
	}
	
	public class SingleIconComboBoxPanel
		extends JPanel
	{
		public SingleIconComboBoxPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "Single Icon ComboBox"));
			
			String[] componentNameDatas = DemoDataFactory.getComponentNameDatas();
			
			JBasicComboBox singleIconComboBox = new JBasicComboBox(componentNameDatas);
			singleIconComboBox.setMaximumSize(new Dimension(350, singleIconComboBox.getPreferredSize().height));
			singleIconComboBox.setRenderer(new ComboBoxDecorationCellRenderer(BorderFactory.createEmptyBorder(0, 5, 0, 0), IconFactory.getSwingIcon("component/combo_box_16.png")));			
			add(singleIconComboBox);
		}
	}
	
	public class MultiIconComboBoxPanel
		extends JPanel
	{
		public MultiIconComboBoxPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "Multi Icon ComboBox"));
			
			List componentInstallDatas = DemoDataFactory.getComponentInstallDatas();
			
			JBasicComboBox multiIconComboBox = new JGroupComboBox(CollectionUtil.parseVector(componentInstallDatas));
			multiIconComboBox.setMaximumSize(new Dimension(350, multiIconComboBox.getPreferredSize().height));
			multiIconComboBox.setRenderer(new ComboBoxDecorationCellRenderer(BorderFactory.createEmptyBorder(0, 5, 0, 0)));
			add(multiIconComboBox);
		}
	}	
}