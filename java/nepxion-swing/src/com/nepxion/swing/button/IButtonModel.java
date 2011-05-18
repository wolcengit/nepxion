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
	/**
	 * Returns true if the menu drop down.
	 * The value is only used in MenuButton or SplitButton.
	 * @return true if isMenuDropDown
	 */
	public boolean isMenuDropDown();
	
	/**
	 * Sets the boolean value of isMenuDropDown.
	 * @param isMenuDropDown the boolean value of isMenuDropDown
	 */
	public void setMenuDropDown(boolean isMenuDropDown);
	
	/**
	 * Returns true if the action button pressed.
	 * @return true if the action button pressed
	 */
	public boolean isActionButtonPressed();
	
	/**
	 * Sets the boolean value of isActionButtonPressed.
	 * @param the boolean value of isActionButtonPressed
	 */
	public void setActionButtonPressed(boolean isActionButtonPressed);
}