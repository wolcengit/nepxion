package com.nepxion.demo.component.timer;

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
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.nepxion.swing.border.ComplexEtchedBorder;
import com.nepxion.swing.border.ComplexSide;
import com.nepxion.swing.border.ComplexTitleBorder;
import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JBasicButton;
import com.nepxion.swing.dimension.DimensionManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.textfield.number.JNumberTextField;
import com.nepxion.swing.timer.JTimerLabel;

public class DemoTimerLabelPanel
	extends JPanel
{
	public DemoTimerLabelPanel()
	{
		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new TimerLabelPanel(JTimerLabel.XP_STYLE, "XP Style"));
		add(new TimerLabelPanel(JTimerLabel.LUNIX_STYLE, "Lunix Style"));
		add(new TimerLabelPanel(JTimerLabel.NIMBUS_STYLE, "Nimbus Style"));
		add(new TimerLabelPanel(JTimerLabel.VISTA_STYLE, "Vista Style"));
	}
	
	public class TimerLabelPanel
		extends JPanel
	{
		public TimerLabelPanel(String style, String label)
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), label));
			
			final JTimerLabel timerLabel = new JTimerLabel(style);
			DimensionManager.setDimension(timerLabel, new Dimension(150, timerLabel.getPreferredSize().height));
			add(timerLabel);
			
			add(Box.createHorizontalStrut(20));
			
			add(new JLabel("Delay time"));
			
			final JNumberTextField textField = new JNumberTextField(1D, Integer.MAX_VALUE);
			DimensionManager.setDimension(textField, new Dimension(100, 23));
			add(textField);
			
			JBasicButton startButton = new JBasicButton("Start", IconFactory.getSwingIcon("solid/control_play_16.png"), "Start Timer");
			startButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					String text = textField.getText();
					if (text.equals(""))
					{
						timerLabel.start();
					}
					else
					{
						int delayTime = Integer.parseInt(text);
						timerLabel.start(delayTime);
					}
				}
			});
			add(startButton);
			
			JBasicButton stopButton = new JBasicButton("Stop", IconFactory.getSwingIcon("solid/control_stop_16.png"), "Stop Timer");
			stopButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					timerLabel.stop();
				}
			});
			add(stopButton);
			
			JBasicButton resetButton = new JBasicButton("Reset", IconFactory.getSwingIcon("solid/refresh_16.png"), "Reset Timer");
			resetButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					timerLabel.reset();
				}
			});
			add(resetButton);
			
			ButtonManager.updateUI(this);
		}
	}
}