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
	public static String getText(Exception e)
	{
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		e.printStackTrace(new PrintStream(out));
		try
		{
			out.flush();
			out.close();
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}		
		return new String(out.toByteArray()).trim();
	}
}