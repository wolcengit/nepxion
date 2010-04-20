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

public class FileUtil
{
    private static ClassLoader load = FileUtil.class.getClassLoader();

    public static String read(String filePath)
    {
        String content = "";
        try
        {
            InputStream fileIn = new FileInputStream(filePath);
            int size = fileIn.available();
            byte[] b = new byte[size];
            fileIn.read(b);
            content = new String(b);
            fileIn.close();
        }
        catch (FileNotFoundException ex)
        {
            return ex.toString();
        }
        catch (IOException ex)
        {
            return ex.toString();
        }
        return content;
    }

    public static String readAsStream(String filePath)
    {
        String content = "";
        try
        {
            InputStream fileIn = load.getResourceAsStream(filePath);
            int size = fileIn.available();
            byte[] b = new byte[size];
            fileIn.read(b);
            content = new String(b);
            fileIn.close();
        }
        catch (FileNotFoundException ex)
        {
            return ex.toString();
        }
        catch (IOException ex)
        {
            return ex.toString();
        }
        return content;
    }

    public static String write(String content, String filePath)
    {
        try
        {
            OutputStream fileOut = new FileOutputStream(filePath);
            byte[] b = content.trim().getBytes();
            fileOut.write(b);
            fileOut.close();
        }
        catch (FileNotFoundException ex)
        {
            return ex.toString();
        }
        catch (IOException ex)
        {
            return ex.toString();
        }
        return "";
    }
    
    public static String getCodePath(Class c, String projectFolderName)
    {    	
    	return getCodePath(c, projectFolderName, "src");
    }    
    
    public static String getCodePath(Class c, String projectFolderName, String resourceFolderName)
    {
		String classPath = c.getName();				
		classPath = classPath.replace('.', '/') + ".java";
		
		String resourcePath = c.getClassLoader().getResource("").getPath();
		resourcePath = resourcePath.substring(1);
		resourcePath = resourcePath.substring(0, resourcePath.indexOf(projectFolderName) + projectFolderName.length());
		resourcePath = resourcePath + "/" + resourceFolderName + "/";
		
		String codePath = resourcePath + classPath;    	
    	return codePath;
    }
}