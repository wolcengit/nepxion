package com.nepxion.swing.timer;

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

import javax.swing.BoundedRangeModel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

public class JTimerProgressBar
	extends JProgressBar implements ITimerComponent
{
	private UpdateTimer updateTimer;
	
	private int value = 0;
	private int blockValue = 99;
	private int delayTime = 30;
	
	public JTimerProgressBar()
	{
		super();
		
		initComponents();
	}
	
	public JTimerProgressBar(int orient)
	{
		super(orient);
		
		initComponents();
	}
	
	public JTimerProgressBar(int min, int max)
	{
		super(min, max);
		
		initComponents();
	}
	
	public JTimerProgressBar(int min, int max, int delayTime, int blockValue)
	{
		this(min, max);
		
		this.delayTime = delayTime;
		this.blockValue = blockValue;
	}
	
	public JTimerProgressBar(int orient, int min, int max)
	{
		super(orient, min, max);
		
		initComponents();
	}
	
	public JTimerProgressBar(int orient, int min, int max, int delayTime, int blockValue)
	{
		this(orient, min, max);
		
		this.delayTime = delayTime;
		this.blockValue = blockValue;
	}
	
	public JTimerProgressBar(BoundedRangeModel newModel)
	{
		super(newModel);
		
		initComponents();
	}
	
	private void initComponents()
	{
		setPreferredSize(new Dimension(getPreferredSize().width, 24));
		
		updateTimer = new UpdateTimer();
		setStringPainted(true);
		reset();
	}
	
	public boolean isRunning()
	{
		return updateTimer.isRunning();
	}
	
	public void reset()
	{
		value = getMinimum();
		setValue(value);
	}
	
	public void start()
	{
		reset();
		updateTimer.start();
	}
	
	public void start(int delayTime)
	{
		setDelayTime(delayTime);
		start();
	}
	
	public void restart()
	{
		updateTimer.start();
	}
	
	public void restart(int delayTime)
	{
		setDelayTime(delayTime);
		restart();
	}
	
	public void stop()
	{
		updateTimer.stop();
	}
	
	public void finish()
	{
		setValue(getMaximum());
		try
		{
			Thread.sleep(1000);
		}
		catch (InterruptedException e)
		{
		}
	}
	
	public int getDelayTime()
	{
		return delayTime;
	}
	
	public void setDelayTime(int delayTime)
	{
		this.delayTime = delayTime;
		this.updateTimer.setDelay(delayTime);
	}
	
	public int getBlockValue()
	{
		return blockValue;
	}
	
	public void setBlockValue(int blockValue)
	{
		this.blockValue = blockValue;
	}
	
	public class UpdateTimer
		extends Timer implements ActionListener
	{
		public UpdateTimer()
		{
			super(delayTime, null);
			addActionListener(this);
		}
		
		public void actionPerformed(ActionEvent e)
		{
			if (getValue() < blockValue)
			{
				value++;
				setValue(value);
			}
			else
			{
				stop();
			}
		}
	}
}