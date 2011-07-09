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
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
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
	 * Executes the cmd.
	 * @param cmd the cmd string
	 * @param waitFor the boolean value of waitFor
	 * @return the cmd result string
	 * @throws Exception
	 */
	public static String processCmd(String cmd, boolean waitFor)
		throws Exception
	{
		return processCmd(cmd, EncoderContext.getIOCharset(), waitFor);
	}
	
	/**
	 * Executes the cmd.
	 * @param cmd the cmd string
	 * @param charset the charset string
	 * @param waitFor the boolean value of waitFor
	 * @return the cmd result string
	 * @throws Exception
	 */
	public static String processCmd(String cmd, String charset, boolean waitFor)
		throws Exception
	{		
		Process process = Runtime.getRuntime().exec("cmd /c " + cmd);
		
		InputStream inputStream = process.getInputStream();
		
		String result = IOUtil.readString(inputStream, charset, true);
		
		if (waitFor)
		{
			process.waitFor();
		}
		
		return result;
	}
		
	/**
	 * Executes the cmd.
	 * @param cmd the cmd string
	 * @param waitFor the boolean value of waitFor
	 * @return the cmd result input stream
	 * @throws Exception
	 */
	public static InputStream processCmdStream(String cmd, boolean waitFor)
		throws Exception
	{		
		Process process = Runtime.getRuntime().exec("cmd /c " + cmd);
		
		InputStream inputStream = process.getInputStream();
		
		if (waitFor)
		{
			process.waitFor();
		}
		
		return inputStream;
	}
	
	/**
	 * Executes the bat.
	 * @param cmd the cmd string
	 * @param waitFor the boolean value of waitFor
	 * @throws Exception
	 */
	public static void processBat(String cmd, boolean waitFor)
		throws Exception	
	{
		Process process = Runtime.getRuntime().exec("cmd.exe /c start " + cmd);
		
		if (waitFor)
		{
			process.waitFor();
		}
	}
	
	/**
	 * Gets the environment variable by a key.
	 * @param key the key string
	 * @return the value string
	 * @throws Exception
	 */
	public static String getEnvironmentVariable(String key)
		throws Exception
	{
		Map environmentVariables = SystemUtil.getEnvironmentVariables();
		
		for (Iterator iterator = environmentVariables.keySet().iterator(); iterator.hasNext();)
		{
			String k = (String) iterator.next();
			
			if (k.trim().toLowerCase().equals(key.trim().toLowerCase()))
			{
				return (String) environmentVariables.get(k);
			}
		}	
		
		return null;
	}
	
	/**
	 * Gets the environment variables.
	 * @return the instance of Map
	 * @throws Exception
	 */
	public static Map getEnvironmentVariables()
		throws Exception
	{
		Map map = new HashMap();
		
		InputStream inputStream = processCmdStream("set", false);
		
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		
		try
		{
			String line = null;
			while ((line = bufferedReader.readLine()) != null)
			{
				String[] stringArray = line.split("=");
				map.put(stringArray[0].trim(), stringArray[1].trim());
			}
		}
		catch (Exception e)
		{
			throw e;
		}
		finally
		{			
			if (bufferedReader != null)
			{	
				bufferedReader.close();
			}
		}
		
		return map;
	}
	
	/**
	 * Gets the reg environment variable by a key.
	 * @param key the key string
	 * @return the value string
	 * @throws Exception
	 */
	public static String getRegEnvironmentVariable(String key)
		throws Exception
	{
		Map environmentVariables = SystemUtil.getRegEnvironmentVariables();
		
		for (Iterator iterator = environmentVariables.keySet().iterator(); iterator.hasNext();)
		{
			String k = (String) iterator.next();
			
			if (k.trim().toLowerCase().equals(key.trim().toLowerCase()))
			{
				return (String) environmentVariables.get(k);
			}
		}	
		
		return null;
	}
	
	/**
	 * Gets the reg environment variables.
	 * @return the instance of Map
	 * @throws Exception
	 */
	public static Map getRegEnvironmentVariables()
		throws Exception
	{
		Map map = new HashMap();
				
		InputStream inputStream = processCmdStream("reg query \"HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\Control\\Session Manager\\Environment\\\" /v", false);
		
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		
		try
		{
			String line = null;
			while ((line = bufferedReader.readLine()) != null)
			{
				if (line.indexOf("REG_SZ") > -1)
				{
					String[] stringArray = line.split("REG_SZ");
					map.put(stringArray[0].trim(), stringArray[1].trim());
				}
				else if (line.indexOf("REG_EXPAND_SZ") > -1)
				{
					String[] stringArray = line.split("REG_EXPAND_SZ");
					map.put(stringArray[0].trim(), stringArray[1].trim());
				}
			}
		}
		catch (Exception e)
		{
			throw e;
		}
		finally
		{			
			if (bufferedReader != null)
			{	
				bufferedReader.close();
			}
		}
		
		return map;
	}
}