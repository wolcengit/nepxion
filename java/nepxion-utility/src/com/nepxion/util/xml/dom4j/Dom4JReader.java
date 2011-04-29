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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URL;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.io.SAXReader;
import org.xml.sax.InputSource;

import com.nepxion.util.encoder.EncoderContext;
import com.nepxion.util.encoder.EncoderUtil;

public class Dom4JReader
{
	/**
	 * Gets the document by xml text.
	 * @param text the xml text
	 * @return the instance of Document
	 * @throws DocumentException
	 */
	public static Document getDocument(String text)
		throws DocumentException
	{
		return DocumentHelper.parseText(text);
	}
		
	/**
	 * Gets the document by text with charset formatted.
	 * The charset is registered in EncoderContext.
	 * @param text the xml text
	 * @return the instance of Document
	 * @throws DocumentException
	 * @throws UnsupportedEncodingException
	 * @see #EncoderContext.getIOCharset
	 */
	public static Document getFormatDocument(String text) 
		throws DocumentException, UnsupportedEncodingException
	{
		return getFormatDocument(text, EncoderContext.getIOCharset());
	}
	
	/**
	 * Gets the document by text with charset formatted.
	 * @param text the xml text
	 * @param charset the charset value
	 * @return the instance of Document
	 * @throws DocumentException
	 * @throws UnsupportedEncodingException
	 */
	public static Document getFormatDocument(String text, String charset) 
		throws DocumentException, UnsupportedEncodingException
	{
		String formatText = EncoderUtil.format(text, charset);
		
		return getDocument(formatText);
	}
	
	/**
	 * Gets the document by file.
	 * @param file the instance of File
	 * @return the instance of Document
	 * @throws DocumentException
	 * @throws FileNotFoundException
	 */
	public static Document getDocument(File file)
		throws DocumentException, FileNotFoundException
	{
		InputStream inputStream = new FileInputStream(file);
		
		return getDocument(inputStream);
	}
	
	/**
	 * Gets the document by file with charset formatted.
	 * The charset is registered in EncoderContext.
	 * @param file the instance of File
	 * @return the instance of Document
	 * @throws DocumentException
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 * @see #EncoderContext.getIOCharset
	 */
	public static Document getFormatDocument(File file)
		throws DocumentException, FileNotFoundException, UnsupportedEncodingException
	{
		return getFormatDocument(file, EncoderContext.getIOCharset());
	}
	
	/**
	 * Gets the document by file with charset formatted.
	 * @param file the instance of File
	 * @param charset the charset value
	 * @return the instance of Document
	 * @throws DocumentException
	 * @throws FileNotFoundException 
	 * @throws UnsupportedEncodingException 
	 */
	public static Document getFormatDocument(File file, String charset)
		throws DocumentException, FileNotFoundException, UnsupportedEncodingException
	{
		InputStream inputStream = new FileInputStream(file);
		
		return getFormatDocument(inputStream, charset);
	}
	
	/**
	 * Gets the document by inputSource.
	 * @param inputSource the instance of InputSource
	 * @return the instance of Document
	 * @throws DocumentException
	 */
	public static Document getDocument(InputSource inputSource)
		throws DocumentException
	{
		SAXReader saxReader = new SAXReader();
		
		return saxReader.read(inputSource);
	}
	
	/**
	 * Gets the document by inputSource with charset formatted.
	 * The charset is registered in EncoderContext.
	 * @param inputSource the instance of InputSource
	 * @return the instance of Document
	 * @throws DocumentException
	 * @see #EncoderContext.getIOCharset
	 */
	public static Document getFormatDocument(InputSource inputSource)
		throws DocumentException
	{
		return getFormatDocument(inputSource, EncoderContext.getIOCharset());
	}
	
	/**
	 * Gets the document by inputSource with charset formatted.
	 * @param inputSource the instance of InputSource
	 * @param charset the charset value
	 * @return the instance of Document
	 * @throws DocumentException
	 */
	public static Document getFormatDocument(InputSource inputSource, String charset)
		throws DocumentException
	{
		inputSource.setEncoding(charset);
		
		return getDocument(inputSource);
	}
	
	/**
	 * Gets the document by inputStream.
	 * @param inputStream the instance of InputStream
	 * @return the instance of Document
	 * @throws DocumentException
	 */
	public static Document getDocument(InputStream inputStream)
		throws DocumentException
	{
		SAXReader saxReader = new SAXReader();
		
		return saxReader.read(inputStream);
	}
	
	/**
	 * Gets the document by inputStream with charset formatted.
	 * The charset is registered in EncoderContext.
	 * @param inputStream the instance of InputStream
	 * @return the instance of Document
	 * @throws DocumentException
	 * @throws UnsupportedEncodingException
	 * @see #EncoderContext.getIOCharset
	 */
	public static Document getFormatDocument(InputStream inputStream)
		throws DocumentException, UnsupportedEncodingException
	{
		return getFormatDocument(inputStream, EncoderContext.getIOCharset());
	}
	
	/**
	 * Gets the document by inputStream with charset formatted.
	 * @param inputStream the instance of InputStream
	 * @param charset the charset value
	 * @return the instance of Document
	 * @throws DocumentException
	 * @throws UnsupportedEncodingException 
	 */
	public static Document getFormatDocument(InputStream inputStream, String charset)
		throws DocumentException, UnsupportedEncodingException
	{
		Reader inputStreamReader = new InputStreamReader(inputStream, charset);
		
		return getDocument(inputStreamReader);
	}
	
	/**
	 * Gets the document by reader
	 * @param reader the instance of Reader
	 * @return the instance of Document
	 * @throws DocumentException
	 */
	public static Document getDocument(Reader reader)
		throws DocumentException
	{
		SAXReader saxReader = new SAXReader();
		
		return saxReader.read(reader);
	}
	
	/**
	 * Gets the document by url
	 * @param url the instance of URL
	 * @return the instance of Document
	 * @throws DocumentException
	 */
	public static Document getDocument(URL url)
		throws DocumentException
	{
		SAXReader saxReader = new SAXReader();
		
		return saxReader.read(url);
	}
}