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

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class LocaleManager
	implements LocaleConstants
{
	private static Map resourceBundleMap;
	
	public static String getString(Class bundleClazz, String key)
	{
		ResourceBundle resourceBundle = getResourceBundle(bundleClazz);
		return resourceBundle.getString(key);
	}
	
	public static String getString(String bundleName, String key)
	{
		ResourceBundle resourceBundle = getResourceBundle(bundleName);
		return resourceBundle.getString(key);
	}
	
	public static ResourceBundle getResourceBundle(Class bundleClazz)
	{
		String bundleName = getBundleName(bundleClazz);
		return getResourceBundle(bundleName);
	}
	
	public static ResourceBundle getResourceBundle(String bundleName)
	{
		if (resourceBundleMap == null)
		{
			resourceBundleMap = new HashMap();
		}
		
		ResourceBundle resourceBundle = (ResourceBundle) resourceBundleMap.get(bundleName);
		if (resourceBundle == null)
		{
			resourceBundle = ResourceBundle.getBundle(bundleName, LocaleContext.getLocale());
			resourceBundleMap.put(bundleName, resourceBundle);
		}
		return resourceBundle;
	}
	
	public static String getBundleName(Class bundleClazz)
	{
		String bundleName = bundleClazz.getName();
		int index = bundleName.lastIndexOf('.');
		if (index != -1)
		{
			bundleName = bundleName.substring(0, index) + "." + BASE_BUNDLE;
		}
		else
		{
			bundleName = BASE_BUNDLE;
		}
		return bundleName;
	}
}