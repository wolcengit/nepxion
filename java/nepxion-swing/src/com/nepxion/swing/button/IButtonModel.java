package com.nepxion.swing.button;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import javax.swing.ButtonModel;

public abstract interface IButtonModel
	extends ButtonModel
{	
	public boolean isMenuDropDown();
	
	public void setMenuDropDown(boolean isMenuDropDown);
	
	public boolean isActionButtonPressed();
	
	public void setActionButtonPressed(boolean isActionButtonPressed);
}