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
	private static int strategy = STRATEGY_APPLICATION;
	
	public static void registerStrategy(int customStrategy)
	{
		strategy = customStrategy;
	}
	
	public static int getStrategy()
	{
		return strategy;
	}
}