package com.nepxion.swing.tray;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import com.jeans.trayicon.TrayBalloonEvent;
import com.jeans.trayicon.TrayBalloonListener;

public class TrayIconBalloonListener
	implements TrayBalloonListener
{
	private JTray tray;
	
	public TrayIconBalloonListener(JTray tray)
	{
		this.tray = tray;
	}
	
	public void balloonChanged(TrayBalloonEvent e)
	{
		if ((e.getMask() & TrayBalloonEvent.SHOW) != 0)
		{
		}
		else if ((e.getMask() & TrayBalloonEvent.HIDE) != 0)
		{
		}
		else if ((e.getMask() & TrayBalloonEvent.TIMEOUT) != 0)
		{
		}
		else if ((e.getMask() & TrayBalloonEvent.CLICK) != 0)
		{
		}
	}
}