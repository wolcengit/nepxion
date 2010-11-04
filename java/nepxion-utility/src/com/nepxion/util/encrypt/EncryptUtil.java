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

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class EncryptUtil
	implements EncryptConstants
{
	public static String encryptMD5(String content)
	{
		return encrypt(content, ALGORITHM_MD5);
	}
	
	public static String encryptSHA(String content, String charset)
	{
		return encrypt(content, ALGORITHM_MD5, charset);
	}
	
	public static String encryptSHA(String content)
	{
		return encrypt(content, ALGORITHM_SHA);
	}
	
	public static String encryptMD5(String content, String charset)
	{
		return encrypt(content, ALGORITHM_SHA, charset);
	}
	
	public static String encryptSHA256(String content)
	{
		return encrypt(content, ALGORITHM_SHA_256);
	}
	
	public static String encryptSHA256(String content, String charset)
	{
		return encrypt(content, ALGORITHM_SHA_256, charset);
	}
	
	public static String encryptSHA512(String content)
	{
		return encrypt(content, ALGORITHM_SHA_512);
	}
	
	public static String encryptSHA512(String content, String charset)
	{
		return encrypt(content, ALGORITHM_SHA_512, charset);
	}
	
	public static String encrypt(String content, String algorithm)
	{
		return encrypt(content, algorithm, "UTF-8");
	}
	
	public static String encrypt(String content, String algorithm, String charset)
	{
		try
		{
			MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
			byte[] bytes = messageDigest.digest(content.getBytes(charset));
			
			BASE64Encoder base64Encoder = new BASE64Encoder();
			content = base64Encoder.encode(bytes);
		}
		catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		
		return content;
	}
}