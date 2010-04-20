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

import java.io.*;

import org.dom4j.*;
import org.dom4j.io.*;

public class Dom4JWriter
{
    public static String writeContentByString(Document document)
        throws Exception
    {
        try
        {
            String encoding = "GB2312";
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