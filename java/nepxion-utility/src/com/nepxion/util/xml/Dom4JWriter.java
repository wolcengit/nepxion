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
	 * Get xml text by document
	 * @param document  the instanceof Document
	 * @param encoding  the encoding text, example "UTF-8", "GBK", "GB2321"
	 * @return          the xml text
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	public static String getText(Document document, String encoding)
		throws UnsupportedEncodingException, IOException
	{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		OutputFormat outputFormat = new OutputFormat("  ", true, encoding);
		XMLWriter writer = new XMLWriter(baos, outputFormat);
		writer.write(document);
		return baos.toString(encoding);
	}
}