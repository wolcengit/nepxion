package com.nepxion.util.xml;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune �κƾ�
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.io.*;

import org.dom4j.*;
import org.dom4j.io.*;

public class Dom4JWriter
{
	/**
	 * Get xml string by document
	 * @param document  the instanceof Document
	 * @param encoding  the encoding content, eamx: GB2321, UTF-8
	 * @return          
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
        catch (UnsupportedEncodingException ex)
        {
            throw ex;
        }
        catch (IOException ex)
        {
            throw ex;
        }
        return null;
    }
}