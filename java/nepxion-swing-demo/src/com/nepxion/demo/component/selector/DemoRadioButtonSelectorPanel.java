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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.nepxion.demo.common.DemoDataFactory;
import com.nepxion.demo.common.DemoSelectionValuePanel;
import com.nepxion.swing.border.BorderManager;
import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JBasicButton;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.selector.radiobutton.JRadioButtonSelector;

public class DemoRadioButtonSelectorPanel
	extends JPanel
{
	private DemoSelectionValuePanel selectionValuePanel;
	
	public DemoRadioButtonSelectorPanel()
	{
		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		selectionValuePanel = new DemoSelectionValuePanel();
		
		add(new RadioButtonSelectorPanel());
		add(selectionValuePanel);
	}
	
	public class RadioButtonSelectorPanel
		extends JPanel
	{
		public RadioButtonSelectorPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitleBorder("RadioButton Selector"));
			
			JBasicButton radioButtonSelectorButton = new JBasicButton("RadioButton Selector", IconFactory.getSwingIcon("component/radio_button_16.png"), "RadioButton Selector");
			radioButtonSelectorButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{					
					JRadioButtonSelector radioButtonSelector = new JRadioButtonSelector(HandleManager.getFrame(DemoRadioButtonSelectorPanel.this), "Selection", DemoDataFactory.getComponentElementNodes());
					radioButtonSelector.setVisible(true);
					
					if (radioButtonSelector.isConfirmed())
					{	
						if (radioButtonSelector.getSelection() != null)
						{	
							selectionValuePanel.setValue(radioButtonSelector.getSelection().toString());
						}
					}
				}
			}
			);
			add(radioButtonSelectorButton);
			
			ButtonManager.updateUI(this);
		}
	}
}