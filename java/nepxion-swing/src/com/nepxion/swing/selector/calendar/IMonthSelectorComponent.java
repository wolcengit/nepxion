package com.nepxion.swing.selector.calendar;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

public interface IMonthSelectorComponent
{
	/**
	 * Gets the month selector.
	 * @return the instance of JMonthSelector
	 */
	public JMonthSelector getMonthSelector();
	
	/**
	 * Sets the month selector.
	 * @param monthSelector the instance of JMonthSelector
	 */
	public void setMonthSelector(JMonthSelector monthSelector);
}