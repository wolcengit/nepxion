package com.nepxion.util.encoder;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

public class EncoderContext
	implements EncoderConstants
{	
	/**
	 * The io charset.
	 * It is mainly used for getting the io-stream with the native file and object. 
	 */
	private static String ioCharset = DEFAULT_CHARSET;
	
	/**
	 * The http charset.
	 * It is mainly used for getting the io-stream with the remote file and object. Currently it is only support http mode.
	 */
	private static String httpCharset = DEFAULT_CHARSET;
	
	/**
	 * Registers the io charset.
	 * @param customIOCharset the io charset value
	 */
	public static void registerIOCharset(String customIOCharset)
	{
		ioCharset = customIOCharset;
	}
	
	/**
	 * Gets the io charset.
	 * @return the registered io charset value
	 */
	public static String getIOCharset()
	{
		return ioCharset;
	}
	
	/**
	 * Registers the http charset.
	 * @param customHttpCharset the http charset value
	 */
	public static void registerHttpCharset(String customHttpCharset)
	{
		httpCharset = customHttpCharset;
	}
	
	/**
	 * Gets the http charset.
	 * @return the registered http charset value
	 */
	public static String getHttpCharset()
	{
		return httpCharset;
	}
}