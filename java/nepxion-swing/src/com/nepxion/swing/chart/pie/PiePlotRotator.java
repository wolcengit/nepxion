package com.nepxion.swing.chart.pie;

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;
import javax.swing.Timer;

import org.jfree.chart.plot.PiePlot;

import com.nepxion.swing.chart.JChartPanel;

public class PiePlotRotator
	extends Timer implements ActionListener
{
	private PiePlot piePlot;
	private int angle;
	
	public PiePlotRotator(JChartPanel chartPanel, boolean isClickingStarted)
	{
		this(100, chartPanel, isClickingStarted);
	}
	
	public PiePlotRotator(int delay, JChartPanel chartPanel, boolean isClickingStarted)
	{
		super(delay, null);
		
		this.angle = 270;
		this.piePlot = (PiePlot) chartPanel.getChart().getPlot();
		
		if (isClickingStarted)
		{	
			chartPanel.addMouseListener(new MouseAdapter()
			{
				public void mouseClicked(MouseEvent e)
				{
					if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 1)
					{
						execute();
					}
				}
			}
			);
		}
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		piePlot.setStartAngle(angle);
		angle = angle + 1;
		if (angle == 360)
		{
			angle = 0;
		}
	}
	
	public void execute()
	{
		if (!isRunning())
		{
			start();
		}
		else
		{
			stop();
		}
	}
}