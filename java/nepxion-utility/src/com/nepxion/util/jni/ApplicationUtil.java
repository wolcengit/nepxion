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
	public static final String WINDOWS_OS_NAME = "Windows";
	public static final String WINDOWS_BROWSER = "rundll32";
	public static final String WINDOWS_BROWSER_PROCESS = "url.dll,FileProtocolHandler";
	public static final String UNIX_OS_NAME = "Unix";
	public static final String UNIX_BROWSER = "netscape";
	public static final String UNIX_BROWSER_PROCESS = "-remote openURL";
	
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
			Process p = Runtime.getRuntime().exec(cmd);
			int exitCode = p.waitFor();
			if (exitCode != 0)
			{
				cmd = UNIX_BROWSER + " " + url;
				p = Runtime.getRuntime().exec(cmd);
			}
		}
	}
	
	public static void callInternetExplorer(String url)
		throws Exception
	{
		String cmd = "explorer " + url;
		Runtime.getRuntime().exec(cmd);
	}
	
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