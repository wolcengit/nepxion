package com.nepxion.util.xml.dom4j;

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
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import com.nepxion.util.encode.EncodeContext;

public class Dom4JWriter
{
	/**
	 * Create the instanceof Document
	 * @return  the instanceof Document
	 */
	public static Document createDocument()
	{
		return DocumentHelper.createDocument();
	}
	
	/**
	 * Get xml text by document
	 * @param document  the instanceof Document
	 * @return          the xml text
	 * @throws          UnsupportedEncodingException
	 * @throws          IOException
	 */
	public static String getText(Document document)
		throws UnsupportedEncodingException, IOException
	{
		return getText(document, EncodeContext.getCharset());
	}
	
	/**
	 * Get xml text by document
	 * @param document  the instanceof Document
	 * @param Charset   the Charset text, example "ISO-8859-1", "UTF-8", "GBK", "GB2312"
	 * @return          the xml text
	 * @throws          UnsupportedEncodingException
	 * @throws          IOException
	 */
	public static String getText(Document document, String charset)
		throws UnsupportedEncodingException, IOException
	{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		OutputFormat outputFormat = new OutputFormat("  ", true, charset);
		XMLWriter writer = new XMLWriter(baos, outputFormat);
		writer.write(document);
		return baos.toString(charset);
	}
}