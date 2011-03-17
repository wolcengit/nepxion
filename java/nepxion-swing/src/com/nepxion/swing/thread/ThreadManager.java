package com.nepxion.swing.thread;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.Color;

import com.nepxion.swing.border.LineBorder;
import com.nepxion.swing.lookandfeel.LookAndFeelManager;
import com.nepxion.swing.thread.dialog.AbstractThreadDialog;

public class ThreadManager
{
	public static void setPreferenceStyle(AbstractThreadDialog threadDialog)
	{
		if (LookAndFeelManager.isNimbusLookAndFeel())
		{
			threadDialog.getLayoutPanel().setBorder(new LineBorder(new Color(167, 172, 180), 1));
		}
	}
	
	public static int getDecoratedMargin(AbstractThreadDialog threadDialog)
	{
		if (!LookAndFeelManager.isNimbusLookAndFeel())
		{
			return threadDialog.getDecoratedMargin();
		}
		else
		{
			return 0;
		}
	}
}