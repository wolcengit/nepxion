package com.nepxion.demo.component.dialog;

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

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.nepxion.swing.border.ComplexEtchedBorder;
import com.nepxion.swing.border.ComplexSide;
import com.nepxion.swing.border.ComplexTitleBorder;
import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JBasicButton;
import com.nepxion.swing.checkbox.JBasicCheckBox;
import com.nepxion.swing.dialog.JBasicDialog;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.layout.filed.FiledLayout;

public class DemoHintDialogPanel
	extends JPanel
{
	private JBasicDialog hintDialog;
	
	public DemoHintDialogPanel()
	{
		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new HintDialogPanel());
		add(new ConfigPanel());
	}
	
	public class HintDialogPanel
		extends JPanel
	{
		public HintDialogPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "Hint Dialog"));
			
			JBasicButton hintDialogButton = new JBasicButton("Hint Dialog", IconFactory.getSwingIcon("component/dialog_16.png"), "Hint Dialog");
			hintDialogButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					if (hintDialog == null)
					{	
						hintDialog = new JBasicDialog(HandleManager.getFrame(DemoHintDialogPanel.this), "Hint Dialog", new Dimension(300, 300), true, true, true);
						hintDialog.setMinimumDimension(new Dimension(200, 200));
						hintDialog.setMaximumDimension(new Dimension(400, 400));
					}	
					hintDialog.setVisible(true);
				}
			}
			);
			add(hintDialogButton);
			
			ButtonManager.updateUI(this);
		}
	}
	
	public class ConfigPanel
		extends JPanel
	{
		public ConfigPanel()
		{
			setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
			setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "Configuration"));
			
	        final JBasicCheckBox adaptableCheckBox = new JBasicCheckBox("Adapt the size while resizing the dialog", "Adapt the size while resizing the dialog", true);	
	        adaptableCheckBox.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					hintDialog.setAdaptable(adaptableCheckBox.isSelected());
				}				
			}
			);	
	        add(adaptableCheckBox);	
	        
	        final JBasicCheckBox hintCheckBox = new JBasicCheckBox("Show hint while closing the dialog", "Show hint while closing the dialog", true);	
	        hintCheckBox.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					hintDialog.setHint(hintCheckBox.isSelected());
				}				
			}
			);	
	        add(hintCheckBox);
	        
	        final JBasicCheckBox minimumDimensionCheckBox = new JBasicCheckBox("Set minimum dimension (width=200, height=200)", "Set minimum dimension (width=200, height=200)", true);	
	        minimumDimensionCheckBox.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					if (minimumDimensionCheckBox.isSelected())
					{	
						hintDialog.setMinimumDimension(new Dimension(200, 200));
					}
					else
					{
						hintDialog.setMinimumDimension(null);
					}
				}				
			}
			);	
	        add(minimumDimensionCheckBox);
	        
	        final JBasicCheckBox maximumDimensionCheckBox = new JBasicCheckBox("Set maximum dimension (width=400, height=400)", "Set maximum dimension (width=400, height=400)", true);	
	        maximumDimensionCheckBox.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					if (maximumDimensionCheckBox.isSelected())
					{	
						hintDialog.setMaximumDimension(new Dimension(400, 400));
					}
					else
					{
						hintDialog.setMaximumDimension(null);
					}
				}				
			}
			);	
	        add(maximumDimensionCheckBox);	        
		}
	}
}