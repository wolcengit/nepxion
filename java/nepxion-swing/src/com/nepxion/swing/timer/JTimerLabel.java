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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.Timer;

import com.nepxion.swing.icon.IconFactory;

public class JTimerLabel
	extends JLabel implements ITimerComponent
{
	public static final String LOOP_ICON = "thread/loop/";
	public static final String BALL_ICON = "thread/ball/";
	public static final String CIRCLE_ICON = "thread/circle/";
	public static final String COMPASS_ICON = "thread/compass/";
	public static final String MAGNIFIER_ICON = "thread/magnifier/";
	
	private UpdateTimer updateTimer;
	
	private Icon[] iconGroup;
	private int index = 0;
	private int delayTime = 30;
	
	public JTimerLabel()
	{
		this(LOOP_ICON);
	}
	
	public JTimerLabel(String icon)
	{
		updateTimer = new UpdateTimer();
		if (icon.equals(LOOP_ICON))
		{
			iconGroup = new Icon[15];
			updateTimer.setDelay(30);
		}
		else if (icon.equals(BALL_ICON))
		{
			iconGroup = new Icon[30];
			updateTimer.setDelay(80);
		}
		else if (icon.equals(CIRCLE_ICON))
		{
			iconGroup = new Icon[60];
			updateTimer.setDelay(80);
		}
		else if (icon.equals(COMPASS_ICON))
		{
			iconGroup = new Icon[15];
			updateTimer.setDelay(350);
		}
		else if (icon.equals(MAGNIFIER_ICON))
		{
			iconGroup = new Icon[22];
			updateTimer.setDelay(80);
		}
		for (int i = 0; i < iconGroup.length; i++)
		{
			iconGroup[i] = IconFactory.getSwingIcon(icon + (i + 1) + ".png");
		}
		reset();
	}
	
	public boolean isRunning()
	{
		return updateTimer.isRunning();
	}
	
	public void reset()
	{
		index = 0;
		setIcon(iconGroup[0]);
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
			index = (index + 1) % iconGroup.length;
			setIcon(iconGroup[index]);
		}
	}
}