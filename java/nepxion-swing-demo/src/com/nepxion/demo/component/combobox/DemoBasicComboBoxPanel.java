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

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.nepxion.demo.common.DemoDataFactory;
import com.nepxion.swing.border.ComplexEtchedBorder;
import com.nepxion.swing.border.ComplexSide;
import com.nepxion.swing.border.ComplexTitleBorder;
import com.nepxion.swing.checkbox.JBasicCheckBox;
import com.nepxion.swing.combobox.JBasicComboBox;
import com.nepxion.swing.common.InstallData;
import com.nepxion.swing.item.BasicItemListener;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.renderer.combobox.ComboBoxIconCellRenderer;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;
import com.nepxion.util.data.CollectionUtil;

public class DemoBasicComboBoxPanel
	extends JPanel
{
	private JEclipseTabbedPane eclipseTabbedPane;
	
	public DemoBasicComboBoxPanel()
	{
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new EclipseTabbedPanePanel(), BorderLayout.CENTER);
		add(new PublicConfigPanel(), BorderLayout.SOUTH);
	}
	
	public class EclipseTabbedPanePanel
		extends JPanel
	{
		public EclipseTabbedPanePanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "Eclipse TabbedPane"));
			
		}
	}
	
	public class PublicConfigPanel
		extends JPanel
	{
		public PublicConfigPanel()
		{
			setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
			setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "Public Configuration"));
			
			List tabShapeInstallDatas = DemoDataFactory.getEclipseTabShapeInstallDatas();
			
			final JBasicComboBox tabShapeComboBox = new JBasicComboBox(CollectionUtil.parseVector(tabShapeInstallDatas));
			tabShapeComboBox.setRenderer(new ComboBoxIconCellRenderer());
			tabShapeComboBox.addItemListener(new BasicItemListener()
			{
				public void itemSelectionStateChanged(ItemEvent e)
				{
					InstallData installdata = (InstallData) tabShapeComboBox.getSelectedItem();
					eclipseTabbedPane.setTabShape(installdata.getIndex());
				}
			}
			);
			add(tabShapeComboBox);
			
			final JBasicCheckBox showTabAreaCheckBox = new JBasicCheckBox("Show Tab Area", true);
			showTabAreaCheckBox.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					eclipseTabbedPane.setShowTabArea(showTabAreaCheckBox.isSelected());
				}
			}
			);
			add(showTabAreaCheckBox);			
		}
	}
}