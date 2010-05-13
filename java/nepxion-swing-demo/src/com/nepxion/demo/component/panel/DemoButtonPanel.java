package com.nepxion.demo.component.panel;

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
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.nepxion.demo.common.DemoSelectionValuePanel;
import com.nepxion.swing.border.ComplexEtchedBorder;
import com.nepxion.swing.border.ComplexSide;
import com.nepxion.swing.border.ComplexTitleBorder;
import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JBasicButton;
import com.nepxion.swing.dialog.JBasicDialog;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.panel.JCloseButtonPanel;
import com.nepxion.swing.panel.JOptionButtonPanel;

public class DemoButtonPanel
	extends JPanel
{
	private DemoSelectionValuePanel selectionValuePanel;
	
	public DemoButtonPanel()
	{
		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		selectionValuePanel = new DemoSelectionValuePanel();
		
		add(new ButtonPanel());
		add(selectionValuePanel);
	}
	
	public class ButtonPanel
		extends JPanel
	{
		public ButtonPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "Button Panel"));
			
			JBasicButton optionButton = new JBasicButton("Option Button Panel", IconFactory.getSwingIcon("component/button_16.png"), "Option Button Panel");
			optionButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{		
	                JOptionButtonPanel optionButtonPanel = new JOptionButtonPanel()
	                {
	                    public boolean confirm()
	                    {
	                    	selectionValuePanel.setValue("Confirm");
	                    	return true;
	                    }

						public boolean cancel()
						{
							selectionValuePanel.setValue("Cancel");
							return true;
						}	                    
	                };
	                
	                JBasicDialog optionButtonDialog = new JBasicDialog(HandleManager.getFrame(DemoButtonPanel.this), "Option Button Panel", new Dimension(300, 300));
	                optionButtonDialog.getContentPane().setLayout(new BorderLayout());
	                optionButtonDialog.getContentPane().add(optionButtonPanel, BorderLayout.SOUTH);
	                optionButtonDialog.setVisible(true);
				}
			}
			);
			add(optionButton);
			
			JBasicButton closeButton = new JBasicButton("Close Button Panel", IconFactory.getSwingIcon("component/button_16.png"), "Close Button Panel");
			closeButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{		
	                JCloseButtonPanel closeButtonPanel = new JCloseButtonPanel()
	                {
						public boolean close()
						{
							selectionValuePanel.setValue("Close");
							return true;
						}	                    
	                };
	                
	                JBasicDialog optionButtonDialog = new JBasicDialog(HandleManager.getFrame(DemoButtonPanel.this), "Close Button Panel", new Dimension(300, 300));
	                optionButtonDialog.getContentPane().setLayout(new BorderLayout());
	                optionButtonDialog.getContentPane().add(closeButtonPanel, BorderLayout.SOUTH);
	                optionButtonDialog.setVisible(true);
				}
			}
			);
			add(closeButton);			
			
			ButtonManager.updateUI(this);
		}
	}
}