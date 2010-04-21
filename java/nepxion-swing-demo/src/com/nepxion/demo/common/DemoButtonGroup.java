package com.nepxion.demo.common;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import javax.swing.ButtonGroup;

public class DemoButtonGroup
	extends ButtonGroup
{
	private static DemoButtonGroup buttonGroup;
	
	public static DemoButtonGroup getInstance()
	{
		if (buttonGroup == null)
		{
			buttonGroup = new DemoButtonGroup(); 
		}	
		return buttonGroup;
	}
	
	private DemoButtonGroup()
	{
	}
}