package com.nepxion.util.xml;

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
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class Dom4JWriter
{
	/**
	 * Get xml string by document
	 * @param document  the instanceof Document
	 * @param encoding  the encoding content, example "GB2321", "UTF-8"
	 * @return          the xml string
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	public static String getString(Document document, String encoding)
		throws UnsupportedEncodingException, IOException
	{
		try
		{
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			OutputFormat outputFormat = new OutputFormat("  ", true, encoding);
			XMLWriter writer = new XMLWriter(baos, outputFormat);
			writer.write(document);
			String content = baos.toString(encoding);
			if (content != null)
			{
				return content;
			}
		}
		catch (UnsupportedEncodingException e)
		{
			throw e;
		}
		catch (IOException e)
		{
			throw e;
		}
		return null;
	}
}