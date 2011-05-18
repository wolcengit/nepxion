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

import javax.swing.JToggleButton;

public class BasicToggleButtonModel
	extends JToggleButton.ToggleButtonModel	implements IButtonModel
{
	/**
	 * The boolean value of isMenuDropDown.
	 */
	private boolean isMenuDropDown;
	
	/**
	 * The boolean value of isActionButtonPressed.
	 */
	private boolean isActionButtonPressed;
	
	/**
	 * Constructs with the default.
	 */
	public BasicToggleButtonModel()
	{
		super();
	}
	
	/**
	 * Returns true if the menu drop down.
	 * The value is only used in MenuButton or SplitButton.
	 * @return true if isMenuDropDown
	 */
	public boolean isMenuDropDown()
	{
		return isMenuDropDown;
	}
	/**
	 * Sets the boolean value of isMenuDropDown.
	 * @param isMenuDropDown the boolean value of isMenuDropDown
	 */
	public void setMenuDropDown(boolean isMenuDropDown)
	{
		this.isMenuDropDown = isMenuDropDown;
	}
	
	/**
	 * Returns true if the action button pressed.
	 * @return true if the action button pressed
	 */
	public boolean isActionButtonPressed()
	{
		return isActionButtonPressed;
	}
	
	/**
	 * Sets the boolean value of isActionButtonPressed.
	 * @param the boolean value of isActionButtonPressed
	 */
	public void setActionButtonPressed(boolean isActionButtonPressed)
	{
		this.isActionButtonPressed = isActionButtonPressed;
	}
}