package com.nepxion.util.system;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import com.nepxion.util.encoder.EncoderContext;
import com.nepxion.util.io.IOUtil;

public class SystemUtil
{
	/**
	 * Verifies the os by an os name
	 * @return true if the current os name is the specified os name.
	 */
	public static boolean verifyOS(String osName)
	{
		String name = System.getProperty("os.name");
		if (name != null && name.startsWith(osName))
		{
			return true;
		}
		
		return false;
	}
	
	/**
	 * Gets the user home of JVM.
	 * @return the user home
	 */
	public static String getUserHome()
	{
		return System.getProperty("user.home");
	}
	
	/**
	 * Gets the user directory of JVM.
	 * @return the user directory
	 */
	public static String getUserDirectory()
	{
		return System.getProperty("user.dir");
	}
	
	/**
	 * Gets the temp directory of JVM.
	 * @return the temp directory
	 */
	public static String getTempDirectory()
	{
		return System.getProperty("java.io.tmpdir");
	}
	
	/**
	 * Executes the process.
	 * @param cmd the cmd string
	 * @param waitFor the boolean value of waitFor
	 * @return the cmd result string
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws UnsupportedEncodingException
	 */
	public static String processExec(String cmd, boolean waitFor)
		throws IOException, InterruptedException, UnsupportedEncodingException
	{
		return processExec(cmd, EncoderContext.getIOCharset(), waitFor);
	}
	
	/**
	 * Executes the process.
	 * @param cmd the cmd string
	 * @param charset the charset string
	 * @param waitFor the boolean value of waitFor
	 * @return the cmd result string
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws UnsupportedEncodingException
	 */
	public static String processExec(String cmd, String charset, boolean waitFor)
		throws IOException, InterruptedException, UnsupportedEncodingException
	{
		String text = null;
		
		Process process = Runtime.getRuntime().exec(cmd);
		
		text = IOUtil.getString(process.getInputStream(), charset);
		
		if (waitFor)
		{
			process.waitFor();
		}
		
		return text;
	}
	
	/**
	 * Gets the environment variables.
	 * @return the instance of Map
	 * @throws IOException
	 */
	public static Map getEnvironmentVariables()
		throws IOException
	{
		Map map = new HashMap();
		
		Process process = Runtime.getRuntime().exec("cmd /c set");
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		
		String line = null;
		while ((line = bufferedReader.readLine()) != null)
		{
			String[] stringArray = line.split("=");
			map.put(stringArray[0], stringArray[1]);
		}
		bufferedReader.close();
		
		return map;
	}
}