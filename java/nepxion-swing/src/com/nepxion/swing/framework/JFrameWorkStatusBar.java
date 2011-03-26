package com.nepxion.swing.framework;

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

import javax.swing.BorderFactory;
import javax.swing.Box;

import com.nepxion.swing.statusbar.JStatusBar;
import com.nepxion.swing.statusbar.JStatusItem;
import com.nepxion.swing.timer.JTimerLabel;
import com.nepxion.swing.timer.JTimerProgressBar;

public class JFrameWorkStatusBar
	extends JStatusBar
{
	private JTimerProgressBar timerProgressBar;
	private JTimerLabel timerLabel;
	
	public JFrameWorkStatusBar()
	{
		setBorderVisible(false);
	}
	
	public void showProgressStatus()
	{
		timerProgressBar = new JTimerProgressBar(0, 100);
		timerProgressBar.setPreferredSize(new Dimension(60, 16));
		timerLabel = new JTimerLabel();
		
		JStatusItem statusItem = new JStatusItem();
		statusItem.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
		statusItem.add(timerProgressBar);
		statusItem.add(Box.createHorizontalStrut(5));
		statusItem.add(timerLabel);
		statusItem.add(Box.createHorizontalStrut(5));
		
		addItem(80, statusItem, RIGHT);
	}
	
	public void start()
	{
		if (timerProgressBar != null)
		{	
			timerProgressBar.start();
		}
		
		if (timerLabel != null)
		{
			timerLabel.start();
		}	
	}
	
	public void stop()
	{
		if (timerProgressBar != null)
		{	
			timerProgressBar.stop();			
		}
		
		if (timerLabel != null)
		{
			timerLabel.stop();
		}
	}
	
	public JTimerProgressBar getTimerProgressBar()
	{
		return timerProgressBar;
	}
	
	public JTimerLabel getTimerLabel()
	{
		return timerLabel;
	}
}