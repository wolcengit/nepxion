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
import java.util.Locale;
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
	
	public static String getString(Class bundleClazz, String key, Locale locale)
	{
		ResourceBundle resourceBundle = getResourceBundle(bundleClazz, locale);
		return resourceBundle.getString(key);
	}
	
	public static String getString(String bundleName, String key)
	{
		ResourceBundle resourceBundle = getResourceBundle(bundleName);
		return resourceBundle.getString(key);
	}
	
	public static String getString(String bundleName, String key, Locale locale)
	{
		ResourceBundle resourceBundle = getResourceBundle(bundleName, locale);
		return resourceBundle.getString(key);
	}
	
	public static ResourceBundle getResourceBundle(Class bundleClazz)
	{
		String bundleName = getBundleName(bundleClazz);
		return getResourceBundle(bundleName);
	}
	
	public static ResourceBundle getResourceBundle(Class bundleClazz, Locale locale)
	{
		String bundleName = getBundleName(bundleClazz);
		return getResourceBundle(bundleName, locale);
	}
	
	public static ResourceBundle getResourceBundle(String bundleName)
	{
		return getResourceBundle(bundleName, LocaleContext.getLocale());
	}
	
	public static ResourceBundle getResourceBundle(String bundleName, Locale locale)
	{
		if (resourceBundleMap == null)
		{
			resourceBundleMap = new HashMap();
		}
		
		String key = bundleName + "_" + locale;
		
		ResourceBundle resourceBundle = (ResourceBundle) resourceBundleMap.get(key);
		if (resourceBundle == null)
		{
			resourceBundle = ResourceBundle.getBundle(bundleName, locale);
			resourceBundleMap.put(key, resourceBundle);
		}

		return resourceBundle;
	}
	
	/*public static ResourceBundle getResourceBundle(String bundleName, Locale locale)
	{		
		return ResourceBundle.getBundle(bundleName, locale);
	}*/
	
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