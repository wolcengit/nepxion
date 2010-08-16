package com.nepxion.demo.component.chart;

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

import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JBasicButton;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.panel.JTimePanel;
import com.nepxion.util.scheduler.quartz.basic.BasicSchedulerExecuter;

public class DemoChartSchedulerToolBar
	extends JPanel
{
	public DemoChartSchedulerToolBar(Class jobClass)
	{
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
		
		final BasicSchedulerExecuter schedulerExecuter = new BasicSchedulerExecuter();
		try
		{
			schedulerExecuter.setJobClass(jobClass);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		final JTimePanel timePanel = new JTimePanel(JTimePanel.HORIZONTAL);
		timePanel.setInterval(new int[] {0, 0, 0, 1, 0});
		
		JBasicButton startButton = new JBasicButton("启动", IconFactory.getSwingIcon("solid/control_forward_16.png"), "启动定时器");
		startButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (!schedulerExecuter.isStarted())
				{
					schedulerExecuter.start();
				}
				schedulerExecuter.setRepeatInterval(timePanel.getInterval());
				schedulerExecuter.scheduleJob();
			}
		}
		);
		timePanel.add(startButton);
		
		JBasicButton stopButton = new JBasicButton("停止", IconFactory.getSwingIcon("solid/control_pause_16.png"), "停止定时器");
		stopButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				schedulerExecuter.unscheduleJob();
			}
		}
		);
		timePanel.add(stopButton);
		
		add(new JLabel("定时间隔"));
		add(Box.createHorizontalStrut(5));
		add(timePanel);
		
		ButtonManager.updateUI(timePanel, new Dimension(60, 22));
	}
}