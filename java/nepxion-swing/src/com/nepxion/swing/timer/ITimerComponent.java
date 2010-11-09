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

public interface ITimerComponent
{
	public boolean isRunning();
	
	public void reset();
	
	public void start();
	
	public void start(int delayTime);
	
	public void restart();
	
	public void restart(int delayTime);
	
	public void stop();
	
	public void finish();
	
	public int getDelayTime();
	
	public void setDelayTime(int delayTime);
}