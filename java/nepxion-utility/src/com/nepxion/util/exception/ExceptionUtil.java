package com.nepxion.util.exception;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class ExceptionUtil
{
	public static String subString(Exception e)
	{
		String message = e.getMessage();
		message = message.substring(message.indexOf(":") + 1).trim();
		return message;
	}
	
	public static String getText(Exception e)
	{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		e.printStackTrace(new PrintStream(baos));
		try
		{
			baos.flush();
			baos.close();
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}		
		return new String(baos.toByteArray()).trim();
	}
}