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
    private static String charset = "ISO-8859-1";
    
    public static void registerCharset(String value)
    {
    	charset = value;
    } 
    
    public static String getCharset()
    {
    	return charset;
    }   
}