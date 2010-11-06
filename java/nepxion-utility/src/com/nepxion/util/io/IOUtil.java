package com.nepxion.util.io;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import com.nepxion.util.encoder.EncoderContext;

public class IOUtil
{
	/**
	 * Write Object by OutputStream
	 * @param outputStream  the instance of OutputStream
	 * @param object        the instance of Object
	 */
	public static void write(OutputStream outputStream, Object object)
	{
		try
		{
			ObjectOutputStream oos = new ObjectOutputStream(outputStream);
			oos.writeObject(object);
			oos.flush();
			oos.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Read Object by InputStream
	 * @param inputStream  the instance of InputStream
	 * @return             the instance of Object
	 */
	public static Object read(InputStream inputStream)
	{
		Object object = null;
		try
		{
			ObjectInputStream ois = new ObjectInputStream(inputStream);
			object = ois.readObject();
			ois.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		return object;
	}
	
	/**
	 * Write Object by ByteArrayOutputStream
	 * @param object  the instance of Object
	 * @return        the instance of ByteArrayOutputStream
	 */
	public static ByteArrayOutputStream write(Object object)
	{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		write(baos, object);
		try
		{
			baos.flush();
			baos.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return baos;
	}
	
	/**
	 * Read Object by ByteArrayOutputStream
	 * @param outputStream  the instance of ByteArrayOutputStream
	 * @return              the instance of Object
	 */
	public static Object read(ByteArrayOutputStream outputStream)
	{
		ByteArrayInputStream bais = new ByteArrayInputStream(outputStream.toByteArray());
		Object object = read(bais);
		try
		{
			bais.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return object;
	}
	
	/**
	 * Get ByteArrayInputStream by Object
	 * @param object  the instance of Object
	 * @return        the instance of ByteArrayInputStream
	 */
	public static ByteArrayInputStream getInputStream(Object object)
	{
		ByteArrayOutputStream baos = write(object);
		
		ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
		return bais;
	}
	
	/**
	 * Get Object by InputStream
	 * @param inputStream  the instance of InputStream
	 * @return             the instance of Object
	 */
	public static Object getObject(InputStream inputStream)
	{
		return read(inputStream);
	}
	
	/**
	 * Get InputStream by String
	 * @param text  the instance of String
	 * @return      the instance of ByteArrayInputStream
	 */
	public static ByteArrayInputStream getInputStream(String text)
	{
		ByteArrayInputStream bais = new ByteArrayInputStream(text.getBytes());
		return bais;
	}
	
	/**
	 * Get String by InputStream
	 * @param inputStream  the instance of InputStream
	 * @return             the instance of String
	 */
	public static String getString(InputStream inputStream)
	{
		return getString(inputStream, EncoderContext.getIOCharset());
	}
	
	/**
	 * Get String by InputStream
	 * @param inputStream  the instance of InputStream
	 * @param charset      the charset text, example "ISO-8859-1", "UTF-8", "GBK", "GB2312"
	 * @return             the instance of String
	 */
	public static String getString(InputStream inputStream, String charset)
	{
		StringBuffer stringBuffer = new StringBuffer();
		try
		{
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charset);
			
			char[] bytes = new char[4096];
			int index = -1;
			while ((index = inputStreamReader.read(bytes)) != -1)
			{
				stringBuffer.append(new String(bytes, 0, index));
			}
			inputStreamReader.close();
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return stringBuffer.toString().trim();
	}
	
	/**
	 * Read String by InputStream
	 * @param inputStream  the instance of InputStream
	 * @return             the instance of String
	 */
	public static String readString(InputStream inputStream)	
	{
		return readString(inputStream, EncoderContext.getIOCharset());
	}
	
	/**
	 * Read String by InputStream
	 * @param inputStream  the instance of InputStream
	 * @param charset      the charset text, example "ISO-8859-1", "UTF-8", "GBK", "GB2312"
	 * @return             the instance of String
	 */
	public static String readString(InputStream inputStream, String charset)
	{
		StringBuffer stringBuffer = new StringBuffer();
		try
		{
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, charset));
			
			String line = null;
			while ((line = bufferedReader.readLine()) != null)
			{
				stringBuffer.append(line + "\n");
			}
			bufferedReader.close();
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return stringBuffer.toString().trim();
	}
	
	/**
	 * Get deep clone object
	 * @param object  the origin
	 * @return        the clone object
	 */
	public static Object deepClone(Object object)
	{		
		/*ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(object);
		oos.flush();
		baos.flush();
		oos.close();
		baos.close();
		
		ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bais);
		Object cloneObject = ois.readObject();
		ois.close();
		bais.close();*/
		
		ByteArrayOutputStream baos = write(object);
		Object cloneObject = read(baos);
		return cloneObject;
	}
	
	public static void main(String[] args)
	{
		String[] array = {"Value1", "Value2", "Value3"};
		InputStream arrayInputStream = getInputStream(array);
		System.out.println("getInputStream() : " + arrayInputStream);
		
		String[] object = (String[]) getObject(arrayInputStream);
		System.out.println("getObject() : [" + object[0] + ", " + object[1] + ", " + object[2] + "]");
		
		String text = "Value1, Value2, Value3";
		InputStream stringInputStream = getInputStream(text);
		System.out.println("getInputStream() : " + stringInputStream);
		
		String string = getString(stringInputStream, "UTF-8");

		System.out.println("getString() : " + string);
	}
}