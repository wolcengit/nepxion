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

public interface LocaleConstants
{
	public static final String LOCALE_ZH_CN_NAME = "zh_CN";
	public static final String LOCALE_EN_US_NAME = "en_US";
	
	public static final Locale LOCALE_ZH_CN = new Locale("zh", "CN");
	public static final Locale LOCALE_EN_US = new Locale("en", "US");
	
	public static final String BASE_BUNDLE = "Locale";
}