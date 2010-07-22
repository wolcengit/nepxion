package com.nepxion.demo.component.frame;

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
import com.nepxion.swing.frame.JBasicFrame;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.layout.filed.FiledLayout;

public class DemoHintFramePanel
	extends JPanel
{
	private JBasicFrame frame;
	
	public DemoHintFramePanel()
	{
		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new HintFramePanel());
		add(new ConfigPanel());
	}
	
	public class HintFramePanel
		extends JPanel
	{
		public HintFramePanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "Hint Frame"));
			
			JBasicButton frameButton = new JBasicButton("Hint Frame", IconFactory.getSwingIcon("component/dialog_16.png"), "Hint Frame");
			frameButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					if (frame == null)
					{	
						frame = new JBasicFrame("Hint Frame", IconFactory.getSwingIcon("tray_java.png"), new Dimension(300, 300), true, false);
					}	
					frame.setVisible(true);
				}
			}
			);
			add(frameButton);
			
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
	        
	        final JBasicCheckBox hintCheckBox = new JBasicCheckBox("Show hint while closing the dialog", "Show hint while closing the dialog", true);	
	        hintCheckBox.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					frame.setHint(hintCheckBox.isSelected());
				}				
			}
			);	
	        add(hintCheckBox);   
	        
	        final JBasicCheckBox destroyCheckBox = new JBasicCheckBox("Destroy VM while closing the dialog", "Destroy VM while closing the dialog", false);	
	        destroyCheckBox.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					frame.setDestroy(destroyCheckBox.isSelected());
				}				
			}
			);	
	        add(destroyCheckBox);	        
		}
	}
}