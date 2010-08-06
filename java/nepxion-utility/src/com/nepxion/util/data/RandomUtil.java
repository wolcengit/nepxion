package com.nepxion.util.data;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.util.Random;

public class RandomUtil
{
	public static final String CHART_LIST = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	
	public static char getRandomChart()
	{
		char[] chars = CHART_LIST.toCharArray();
		Random random = new Random();
		int randomIndex = random.nextInt(chars.length);
		return chars[randomIndex];
	}
}