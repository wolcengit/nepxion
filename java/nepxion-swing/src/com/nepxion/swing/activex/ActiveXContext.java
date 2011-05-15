package com.nepxion.swing.activex;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

public class ActiveXContext
	implements ActiveXConstants
{
	/**
	 * The strategy of activeX invoking.
	 * The value is STRATEGY_APPLICATION or STRATEGY_APPLET
	 */
	private static int strategy = STRATEGY_APPLICATION;
	
	/**
	 * Registers the strategy.
	 * @param strategy the strategy value
	 */
	public static void registerStrategy(int strategy)
	{
		ActiveXContext.strategy = strategy;
	}
	
	/**
	 * Gets the strategy.
	 * @return the strategy value
	 */
	public static int getStrategy()
	{
		return strategy;
	}
}