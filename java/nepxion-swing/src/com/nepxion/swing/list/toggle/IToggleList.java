package com.nepxion.swing.list.toggle;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import com.nepxion.swing.list.IList;
import com.nepxion.swing.toggle.JToggleContentPanel;

public interface IToggleList
	extends IList
{
	public static final int INVOKE_MODE_SELECTED = 0;
	public static final int INVOKE_MODE_CLICKED = 1;
	public static final int INVOKE_MODE_DOUBLE_CLICKED = 2;
	
	public int getInvokeMode();
	
	public void setInvokeMode(int invokeMode);
	
	public JToggleContentPanel getToggleContentPanel();
	
	public void setToggleContentPanel(JToggleContentPanel toggleContentPanel);
	
	public IToggleAdapter getToggleAdapter();
	
	public void setToggleAdapter(IToggleAdapter toggleAdapter);
}