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

import java.io.UnsupportedEncodingException;

public class EncoderUtil
{
	/**
	 * Formats the text with GB2312 charset.
	 * @param text the text value
	 * @return the formatted text value
	 * @throws UnsupportedEncodingException
	 * @see #format
	 */
	public static String formatGB2312(String text)
		throws UnsupportedEncodingException
	{
		return format(text, "GB2312");
	}	
	
	/**
	 * Formats the text with GBK charset.
	 * @param text the text value
	 * @return the formatted text value
	 * @throws UnsupportedEncodingException
	 * @see #format
	 */
	public static String formatGBK(String text)
		throws UnsupportedEncodingException
	{
		return format(text, "GBK");
	}		
	
	/**
	 * Formats the text with UTF-8 charset.
	 * @param text the text value
	 * @return the formatted text value
	 * @throws UnsupportedEncodingException
	 * @see #format
	 */
	public static String formatUTF8(String text)
		throws UnsupportedEncodingException
	{	
		return format(text, "UFT-8");
	}	
	
	/**
	 * Formats the text by a charset.The the origin charset is ISO-8859-1.
	 * @param text the text value
	 * @param transferCharset the transfer charset
	 * @return the formatted text value
	 * @throws UnsupportedEncodingException
	 */
	public static String format(String text, String transferCharset)
		throws UnsupportedEncodingException
	{		
		return format(text, "ISO-8859-1", transferCharset);
	}	
	
	/**
	 * Formats the text by a charset.
	 * @param text the text value
	 * @param originCharset the origin charset
	 * @param transferCharset the transfer charset
	 * @return the formatted text value
	 * @throws UnsupportedEncodingException
	 */
	public static String format(String text, String originCharset, String transferCharset)
		throws UnsupportedEncodingException
	{
		return new String(text.getBytes(originCharset), transferCharset);
	}
}