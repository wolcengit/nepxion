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

import java.util.Locale;

public class LocaleContext
	implements LocaleConstants
{
	public static void registerLocale(Locale locale)
	{
		Locale.setDefault(locale);
	}
	
	public static Locale getLocale()
	{
		return Locale.getDefault();
	}
}