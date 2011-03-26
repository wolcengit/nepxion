package com.nepxion.swing.framework.ribbon;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import javax.swing.JPanel;

public class DefaultRibbonComponent
	extends JPanel implements IRibbonComponent
{
	private Object userObject;
	
	public Object getUserObject()
	{
		return userObject;
	}
	
	public void setUserObject(Object userObject)
	{
		this.userObject = userObject;
	}
}