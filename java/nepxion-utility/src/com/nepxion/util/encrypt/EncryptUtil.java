package com.nepxion.util.encrypt;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.security.MessageDigest;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class EncryptUtil
	implements EncryptConstants
{
	public static String encryptMD5(String text)
		throws Exception
	{
		return encrypt(text, ALGORITHM_MD5);
	}
	
	public static String encryptMD5(String text, String charset)
		throws Exception
	{
		return encrypt(text, ALGORITHM_MD5, charset);
	}
	
	public static String encryptSHA(String text)
		throws Exception
	{
		return encrypt(text, ALGORITHM_SHA);
	}
	
	public static String encryptSHA(String text, String charset)
		throws Exception
	{
		return encrypt(text, ALGORITHM_SHA, charset);
	}
	
	public static String encryptSHA256(String text)
		throws Exception
	{
		return encrypt(text, ALGORITHM_SHA_256);
	}
	
	public static String encryptSHA256(String text, String charset)
		throws Exception
	{
		return encrypt(text, ALGORITHM_SHA_256, charset);
	}
	
	public static String encryptSHA512(String text)
		throws Exception
	{
		return encrypt(text, ALGORITHM_SHA_512);
	}
	
	public static String encryptSHA512(String text, String charset)
		throws Exception
	{
		return encrypt(text, ALGORITHM_SHA_512, charset);
	}
	
	public static String encrypt(String text, String algorithm)
		throws Exception
	{
		return encrypt(text, algorithm, "UTF-8");
	}
	
	public static String encrypt(String text, String algorithm, String charset)
		throws Exception
	{
		MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
		byte[] bytes = messageDigest.digest(text.getBytes(charset));
		
		return encryptBASE64(bytes);
	}
	
	public static String encryptBASE64(byte[] bytes)
		throws Exception
	{
		BASE64Encoder base64Encoder = new BASE64Encoder();
		
		return base64Encoder.encodeBuffer(bytes);
	}
	
	public static byte[] decryptBASE64(String text)
		throws Exception
	{
		BASE64Decoder base64Decoder = new BASE64Decoder();
		
		return base64Decoder.decodeBuffer(text);
	}
}