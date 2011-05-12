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

import com.nepxion.util.encoder.EncoderContext;

public class Dom4JWriter
{
	/**
	 * Creates the document.
	 * @return the instance of Document
	 */
	public static Document createDocument()
	{
		return DocumentHelper.createDocument();
	}
	
	/**
	 * Gets the xml text by a document.
	 * The charset is registered in EncoderContext.
	 * @param document the instanceof Document
	 * @return the xml text value
	 * @throws IOException
	 * @throws UnsupportedEncodingException
	 */
	public static String getText(Document document)
		throws IOException, UnsupportedEncodingException
	{
		return getText(document, EncoderContext.getIOCharset());
	}
	
	/**
	 * Gets the xml text with a document and charset.
	 * @param document the instanceof Document.
	 * @param charset the charset value
	 * @return the xml text value
	 * @throws IOException
	 * @throws UnsupportedEncodingException
	 */
	public static String getText(Document document, String charset)
		throws IOException, UnsupportedEncodingException 
	{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		OutputFormat outputFormat = new OutputFormat("  ", true, charset);
		XMLWriter writer = new XMLWriter(baos, outputFormat);
		writer.write(document);
		baos.flush();
		baos.close();
		
		return baos.toString(charset);
	}
}