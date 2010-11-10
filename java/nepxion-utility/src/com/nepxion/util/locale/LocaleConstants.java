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
	public static final Locale LOCALE_ZH_CN = Locale.CHINA;
	public static final Locale LOCALE_EN_US = Locale.US;
	public static final Locale[] LOCALE_LIST = {LOCALE_ZH_CN, LOCALE_EN_US};

	public static final String ZH_CN = LOCALE_ZH_CN.toString();
	public static final String EN_US = LOCALE_EN_US.toString();
	
	public static final String BASE_BUNDLE = "Locale";
}