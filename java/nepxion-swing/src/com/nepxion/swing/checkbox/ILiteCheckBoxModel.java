package com.nepxion.swing.checkbox;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

public interface ILiteCheckBoxModel
{
	/**
	 * Returns true if the check box is rollover.
	 * @return true if the check box is rollover
	 */
	public boolean isRollover();
	
	/**
	 * Sets the check box rollover.
	 * @param isRollover the boolean value of isRollover
	 */
	public void setRollover(boolean isRollover);
	
	/**
	 * Returns true if the check box is armed.
	 * @return true if the check box is armed.
	 */
	public boolean isArmed();
	
	/**
	 * Sets the check box armed. 
	 * @param isArmed the boolean value of isArmed
	 */
	public void setArmed(boolean isArmed);
	
	/**
	 * Returns true if the check box is pressed.
	 * @return true if the check box is pressed
	 */
	public boolean isPressed();
	
	/**
	 * Sets the check box pressed.
	 * @param isPressed the boolean value of isPressed
	 */
	public void setPressed(boolean isPressed);
	
	/**
	 * Returns true if the check box is selected.
	 * @return true if the check box is selected
	 */
	public boolean isSelected();
	
	/**
	 * Sets the check box selected.
	 * @param isSelected the boolean value of isSelected
	 */
	public void setSelected(boolean isSelected);
	
	/**
	 * Returns true if the check box is enabled.
	 * @return true if the check box is enabled
	 */
	public boolean isEnabled();
	
	/**
	 * Sets the check box enabled.
	 * @param isEnabled the boolean value of isEnabled
	 */
	public void setEnabled(boolean isEnabled);
}