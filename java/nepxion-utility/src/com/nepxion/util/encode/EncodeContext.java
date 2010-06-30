package com.nepxion.util.encode;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

public class EncodeContext
{
    private static String ioCharset = "ISO-8859-1";
    private static String httpCharset = "ISO-8859-1";
    
    public static void registerIOCharset(String customIOCharset)
    {
    	ioCharset = customIOCharset;
    } 
    
    public static String getIOCharset()
    {
    	return ioCharset;
    }
    
    public static void registerHttpCharset(String customHttpCharset)
    {
    	httpCharset = customHttpCharset;
    } 
    
    public static String getHttpCharset()
    {
    	return httpCharset;
    }      
}