package com.nepxion.util.encoding;

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

public class EncodingUtil
{
	public static String formatGB2312(String text)
		throws UnsupportedEncodingException
	{
		return format(text, "GB2312");
	}	
	
	public static String formatGBK(String text)
		throws UnsupportedEncodingException
	{
		return format(text, "GBK");
	}		
	
	public static String formatUTF8(String text)
		throws UnsupportedEncodingException
	{	
		return format(text, "UFT-8");
	}	
	
	public static String format(String text, String transferCharset)
		throws UnsupportedEncodingException
	{		
		return format(text, "ISO-8859-1", transferCharset);
	}	
	
	public static String format(String text, String originCharset, String transferCharset)
		throws UnsupportedEncodingException
	{
		return new String(text.getBytes(originCharset), transferCharset);
	}
}