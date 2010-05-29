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

import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.io.SAXReader;
import org.xml.sax.InputSource;

public class Dom4JReader
{
	/**
	 * Get document by string
	 * @param content  the xml content
	 * @return         the instance of Document
	 * @throws         DocumentException
	 */
	public static Document getDocument(String text)
		throws DocumentException
	{
		return DocumentHelper.parseText(text);
	}
	
	/**
	 * Get document by file
	 * @param url  the instance of File
	 * @return     the instance of Document
	 * @throws     DocumentException
	 */
	public static Document getDocument(File file)
		throws DocumentException
	{
		SAXReader saxReader = new SAXReader();
		return saxReader.read(file);
	}
	
	/**
	 * Get document by inputSource
	 * @param url  the instance of InputSource
	 * @return     the instance of Document
	 * @throws     DocumentException
	 */
	public static Document getDocument(InputSource inputSource)
		throws DocumentException
	{
		SAXReader saxReader = new SAXReader();
		return saxReader.read(inputSource);
	}
	
	/**
	 * Get document by inputStream
	 * @param url  the instance of InputStream
	 * @return     the instance of Document
	 * @throws     DocumentException
	 */
	public static Document getDocument(InputStream inputStream)
		throws DocumentException
	{
		SAXReader saxReader = new SAXReader();
		return saxReader.read(inputStream);
	}
	
	/**
	 * Get document by reader
	 * @param url  the instance of Reader
	 * @return     the instance of Document
	 * @throws     DocumentException
	 */
	public static Document getDocument(Reader reader)
		throws DocumentException
	{
		SAXReader saxReader = new SAXReader();
		return saxReader.read(reader);
	}
	
	/**
	 * Get document by url
	 * @param url  the instance of URL
	 * @return     the instance of Document
	 * @throws     DocumentException
	 */
	public static Document getDocument(URL url)
		throws DocumentException
	{
		SAXReader saxReader = new SAXReader();
		return saxReader.read(url);
	}
}