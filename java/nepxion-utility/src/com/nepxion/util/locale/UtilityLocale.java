package com.nepxion.util.locale;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

public class UtilityLocale
{
	public static final Class BUNDLE_CLASS = UtilityLocale.class;
	
	public static String getString(String key)
	{
		return LocaleManager.getString(BUNDLE_CLASS, key);
	}
}