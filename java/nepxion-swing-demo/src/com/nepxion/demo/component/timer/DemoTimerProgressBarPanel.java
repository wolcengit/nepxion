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

import com.nepxion.swing.border.BorderManager;
import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JBasicButton;
import com.nepxion.swing.dimension.DimensionManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.textfield.number.JNumberTextField;
import com.nepxion.swing.timer.JTimerProgressBar;

public class DemoTimerProgressBarPanel
	extends JPanel
{
	public DemoTimerProgressBarPanel()
	{
		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new TimerProgressBarPanel());
	}
	
	public class TimerProgressBarPanel
		extends JPanel
	{
		public TimerProgressBarPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitleBorder("Timer Progress Bar"));
			
			final JTimerProgressBar timerProgressBar = new JTimerProgressBar();
			DimensionManager.setDimension(timerProgressBar, new Dimension(150, timerProgressBar.getPreferredSize().height));
			add(timerProgressBar);
			
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
						timerProgressBar.start();
					}
					else
					{
						int delayTime = Integer.parseInt(text);
						timerProgressBar.start(delayTime);
					}
				}
			}
			);
			add(startButton);
			
			JBasicButton restartButton = new JBasicButton("Restart", IconFactory.getSwingIcon("solid/control_go_16.png"), "Restart Timer");
			restartButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					String text = textField.getText();
					if (text.equals(""))
					{
						timerProgressBar.restart();
					}
					else
					{
						int delayTime = Integer.parseInt(text);
						timerProgressBar.restart(delayTime);
					}
				}
			}
			);
			add(restartButton);
			
			JBasicButton stopButton = new JBasicButton("Stop", IconFactory.getSwingIcon("solid/control_stop_16.png"), "Stop Timer");
			stopButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					timerProgressBar.stop();
				}
			}
			);
			add(stopButton);
			
			JBasicButton resetButton = new JBasicButton("Reset", IconFactory.getSwingIcon("solid/refresh_16.png"), "Reset Timer");
			resetButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					timerProgressBar.reset();
				}
			}
			);
			add(resetButton);
			
			ButtonManager.updateUI(this);
		}
	}
}