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

import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JList;
import javax.swing.JPanel;

import com.nepxion.demo.common.DemoDataFactory;
import com.nepxion.swing.border.ComplexEtchedBorder;
import com.nepxion.swing.border.ComplexSide;
import com.nepxion.swing.border.ComplexTitleBorder;
import com.nepxion.swing.combobox.JBasicComboBox;
import com.nepxion.swing.common.InstallData;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.renderer.combobox.ComboBoxDecorationCellRenderer;
import com.nepxion.util.data.CollectionUtil;

public class DemoTreeComboBoxPanel
	extends JPanel
{	
	public DemoTreeComboBoxPanel()
	{
		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new TreeComboBoxPanel());
	}
	
	public class TreeComboBoxPanel
		extends JPanel
	{
		public TreeComboBoxPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "Group ComboBox"));
			
			List comboBoxInstallDatas = new ArrayList();
			
			List componentInstallDatas = DemoDataFactory.getComponentInstallDatas();
			for (Iterator iterator = componentInstallDatas.iterator(); iterator.hasNext();)
			{
				InstallData installData = (InstallData) iterator.next();
				installData.setEnabled(true);
				comboBoxInstallDatas.add(installData);
				if (installData.getChildren() != null)
				{	
					for (Iterator childIterator = installData.getChildren().iterator(); childIterator.hasNext();)
					{
						InstallData childInstallData = (InstallData) childIterator.next();
						comboBoxInstallDatas.add(childInstallData);
					}	
				}	
			}	
			
			JBasicComboBox treeComboBox = new JBasicComboBox(CollectionUtil.parseVector(comboBoxInstallDatas));
			treeComboBox.setMaximumSize(new Dimension(350, treeComboBox.getPreferredSize().height));
			treeComboBox.setRenderer(new ComboBoxTreeCellRenderer());
			add(treeComboBox);
		}
	}
	
	public class ComboBoxTreeCellRenderer
		extends ComboBoxDecorationCellRenderer
	{
		public ComboBoxTreeCellRenderer()
		{
		}
		
		public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)
		{
			super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
			InstallData installData = (InstallData) value;
			if (installData.getChildren() == null)
			{
				setBorder(BorderFactory.createEmptyBorder(0, 18, 0, 0));
			}	
			return this;
		}		
	}	
}