package com.nepxion.util.xml;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune хн╨ф╬Э
 * @email hj_ren@msn.com
 * @version 1.0
 */

import org.dom4j.*;
import org.dom4j.io.*;

public class Dom4JReader
{
    public static Document readDocumentByString(String content)
        throws Exception
    {
        try
        {
            Document document = DocumentHelper.parseText(content);
            if (document != null)
            {
                return document;
            }
        }
        catch (DocumentException ex)
        {
            throw ex;
        }
        return null;
    }

    public static Document readDocumentByURL(String url)
        throws Exception
    {
        try
        {
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(url);
            if (document != null)
            {
                return document;
            }
        }
        catch (DocumentException ex)
        {
            throw ex;
        }
        return null;
    }
}