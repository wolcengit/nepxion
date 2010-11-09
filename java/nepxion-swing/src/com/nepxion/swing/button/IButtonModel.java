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

public abstract interface IButtonModel
{
	public boolean isRollover();
	
	public void setRollover(boolean isRollover);
	
	public boolean isArmed();
	
	public void setArmed(boolean isArmed);
	
	public boolean isPressed();
	
	public void setPressed(boolean isPressed);
	
	public boolean isSelected();
	
	public void setSelected(boolean isSelected);
	
	public boolean isEnabled();
	
	public void setEnabled(boolean isEnabled);
	
	public boolean isMenuDropDown();
	
	public void setMenuDropDown(boolean isMenuDropDown);
	
	public boolean isActionButtonPressed();
	
	public void setActionButtonPressed(boolean isActionButtonPressed);
}