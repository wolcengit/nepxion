package com.nepxion.swing.locale;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.util.Locale;

import com.nepxion.util.locale.LocaleManager;

public class SwingLocale
{
	public static final Class BUNDLE_CLASS = SwingLocale.class;
	
	public static String getString(String key)
	{
		return LocaleManager.getString(BUNDLE_CLASS, key);
	}
	
	public static String getString(String key, Locale locale)
	{
		return LocaleManager.getString(BUNDLE_CLASS, key, locale);
	}
}