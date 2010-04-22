package com.nepxion.demo.component.selector;

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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.nepxion.swing.border.ComplexEtchedBorder;
import com.nepxion.swing.border.ComplexSide;
import com.nepxion.swing.border.ComplexTitleBorder;
import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JFlatButton;
import com.nepxion.swing.common.InstallData;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.selector.checkbox.JCheckBoxSelector;
import com.nepxion.swing.textfield.JBasicTextField;

public class DemoCheckBoxSelectorPanel
	extends JPanel
{
	private SelectorValuePanel selectorValuePanel;
	
	public DemoCheckBoxSelectorPanel()
	{
		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		selectorValuePanel = new SelectorValuePanel();
		
		add(new CheckBoxSelectorPanel());
		add(selectorValuePanel);
	}
	
	public class CheckBoxSelectorPanel
		extends JPanel
	{
		public CheckBoxSelectorPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "CheckBox Selector"));
			
			JFlatButton checkBoxSelectorButton = new JFlatButton("CheckBox Selector", IconFactory.getSwingIcon("component/check_box_16.png"));
			checkBoxSelectorButton.setDimension(new Dimension(132, 30));
			checkBoxSelectorButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{					
					JCheckBoxSelector checkBoxSelector = new JCheckBoxSelector(HandleManager.getFrame(DemoCheckBoxSelectorPanel.this), "Selection", getInstallDatas());
					checkBoxSelector.setVisible(true);
					
					if (checkBoxSelector.isConfirmed())
					{	
						String value = "";
						for (Iterator iterator = checkBoxSelector.getSelections().iterator(); iterator.hasNext();)
						{
							value += iterator.next() + ";";
						}
						selectorValuePanel.setValue(value);
					}
				}
			}
			);
			add(checkBoxSelectorButton);
			
			ButtonManager.updateUI(this);
		}
	}
	
	public List getInstallDatas()
	{
		InstallData buttonControlInstallData = new InstallData("Button Control", IconFactory.getSwingIcon("component/button_16.png"), false);
		InstallData textControlInstallData = new InstallData("Text Control", IconFactory.getSwingIcon("component/text_pane_16.png"), false);
		InstallData menuControlInstallData = new InstallData("Menu Control", IconFactory.getSwingIcon("component/menu_16.png"), false);
		InstallData borderControlInstallData = new InstallData("Border Control", IconFactory.getSwingIcon("component/split_pane_16.png"), false);
		InstallData containerControlInstallData = new InstallData("Container Control", IconFactory.getSwingIcon("component/internal_frame_16.png"), false);
		InstallData barControlInstallData = new InstallData("Bar Control", IconFactory.getSwingIcon("component/tool_bar_16.png"), false);
		InstallData dataControlInstallData = new InstallData("Data Control", IconFactory.getSwingIcon("component/table_16.png"), false);
		InstallData selectorControlInstallData = new InstallData("Selector Control", IconFactory.getSwingIcon("component/file_chooser_16.png"), false);
		InstallData layoutControlInstallData = new InstallData("Layout Control", IconFactory.getSwingIcon("component/align_bottom.png"), false);
		InstallData frameWorkControlInstallData = new InstallData("FrameWork Control", IconFactory.getSwingIcon("component/desktop_pane_16.png"), false);
		InstallData advancedControlInstallData = new InstallData("Advanced Control", IconFactory.getSwingIcon("component/bean_16.png"), false);
		
		List installDatas = new ArrayList();
		installDatas.add(buttonControlInstallData);
		installDatas.add(textControlInstallData);
		installDatas.add(menuControlInstallData);
		installDatas.add(borderControlInstallData);
		installDatas.add(containerControlInstallData);
		installDatas.add(barControlInstallData);
		installDatas.add(dataControlInstallData);
		installDatas.add(selectorControlInstallData);
		installDatas.add(layoutControlInstallData);
		installDatas.add(frameWorkControlInstallData);
		installDatas.add(advancedControlInstallData);
        
        return installDatas;
	}	
	
	public class SelectorValuePanel
		extends JPanel
	{
		private JBasicTextField textField;
		
		public SelectorValuePanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "Selection Value"));
			
			textField = new JBasicTextField();
			textField.setOpaque(false);
			textField.setPreferredSize(new Dimension(225, textField.getPreferredSize().height));
			textField.setMaximumSize(new Dimension(225, textField.getPreferredSize().height));
			textField.setMinimumSize(new Dimension(225, textField.getPreferredSize().height));
			textField.setSize(new Dimension(225, textField.getPreferredSize().height));
			
			add(new JLabel("Your Selection Value"));
			add(textField);
		}
		
		public void setValue(String value)
		{
			textField.setText(value);
		}
	}
}