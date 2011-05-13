package com.nepxion.util.jni;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

public class ApplicationUtil
{
	/**
	 * The Windows os name.
	 */
	public static final String WINDOWS_OS_NAME = "Windows";
	
	/**
	 * The Windows browser handler.
	 */
	public static final String WINDOWS_BROWSER = "rundll32";
	
	/**
	 * The Windows browser process handler.
	 */
	public static final String WINDOWS_BROWSER_PROCESS = "url.dll,FileProtocolHandler";
	
	/**
	 * The Unix os name.
	 */
	public static final String UNIX_OS_NAME = "Unix";
	
	/**
	 * The Unix browser handler.
	 */
	public static final String UNIX_BROWSER = "netscape";
	
	/**
	 * The Unix browser process handler.
	 */
	public static final String UNIX_BROWSER_PROCESS = "-remote openURL";
	
	/**
	 * Calls the application of Windows or Unix platform.
	 * @param url the url string
	 * @throws Exception
	 */
	public static void callApplication(String url)
		throws Exception
	{
		if (url == null || url.trim().equals(""))
		{
			return;
		}
		
		boolean isWindowsPlatform = isWindowsPlatform();
		String cmd = null;
		
		if (isWindowsPlatform)
		{
			cmd = WINDOWS_BROWSER + " " + WINDOWS_BROWSER_PROCESS + " " + url;
			Runtime.getRuntime().exec(cmd);
		}
		else
		{
			cmd = UNIX_BROWSER + " " + UNIX_BROWSER_PROCESS + "(" + url + ")";
			Process process = Runtime.getRuntime().exec(cmd);
			int exitCode = process.waitFor();
			if (exitCode != 0)
			{
				cmd = UNIX_BROWSER + " " + url;
				process = Runtime.getRuntime().exec(cmd);
			}
		}
	}
	
	/**
	 * Calls the Internet Explorer of Windows platform.
	 * @param url the url string
	 * @throws Exception
	 */
	public static void callInternetExplorer(String url)
		throws Exception
	{
		String cmd = "explorer " + url;
		Runtime.getRuntime().exec(cmd);
	}
	
	/**
	 * Returns true if windows platform.
	 * @return true if windows platform
	 */
	private static boolean isWindowsPlatform()
	{
		String osName = System.getProperty("os.name");
		if (osName != null && osName.startsWith(WINDOWS_OS_NAME))
		{
			return true;
		}
		
		return false;
	}
}