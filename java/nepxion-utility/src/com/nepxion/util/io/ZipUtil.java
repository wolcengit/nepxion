package com.nepxion.util.io;

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
import java.util.*;
import java.util.zip.*;

public class ZipUtil
{
    public static final String ENCODING = "GB2312";

    public static List getZipFileList(String zipFilePath)
        throws IOException
    {
        BufferedReader bufferedReader = getZipReader(zipFilePath, ENCODING);
        if (bufferedReader == null)
        {
            return null;
        }

        List list = new ArrayList();
        while (true)
        {
            String line = bufferedReader.readLine();
            if (line == null || line.length() == 0)
            {
                break;
            }
            list.add(line);
        }
        return list;
    }

    public static BufferedReader getZipReader(String zipFilePath, String charsetName)
        throws IOException
    {
        InputStream inputStream = ZipUtil.class.getClassLoader().getResourceAsStream(zipFilePath);
        if (inputStream == null)
        {
            return null;
        }

        if (charsetName == null)
        {
            charsetName = ENCODING;
        }

        InputStream zipInputStream = new GZIPInputStream(inputStream);
        return new BufferedReader(new InputStreamReader(zipInputStream, charsetName));
    }
}