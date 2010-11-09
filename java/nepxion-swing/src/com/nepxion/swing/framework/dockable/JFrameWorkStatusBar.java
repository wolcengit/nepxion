package com.nepxion.swing.framework.dockable;

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
		timerProgressBar = new JTimerProgressBar(0, 100);
		timerProgressBar.setPreferredSize(new Dimension(60, 16));
		timerLabel = new JTimerLabel();
		
		JStatusItem statusItem = new JStatusItem();
		statusItem.add(timerProgressBar);
		statusItem.add(Box.createHorizontalStrut(5));
		statusItem.add(timerLabel);
		// addItem(80, statusItem, JStatusBar.RIGHT);
		
		setBorderVisible(false);
	}
	
	public void start()
	{
		timerProgressBar.start();
		timerLabel.start();
	}
	
	public void stop()
	{
		timerProgressBar.stop();
		timerLabel.stop();
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