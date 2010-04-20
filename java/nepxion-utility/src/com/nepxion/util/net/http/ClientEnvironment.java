package com.nepxion.util.net.http;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune хн╨ф╬Э
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.net.*;
import java.io.*;
import java.util.*;

public class ClientEnvironment
{
    public static final String CONFIG_PATH = "conf/config.properties";

    private static Map parameters;

    public static void initEnvironment(File configFile)
    {
        Properties properties = new Properties();
        URL codeBase = null;
        String module = null;
        try
        {
            properties.load(new FileInputStream(configFile));
            codeBase = new URL(properties.getProperty("URL"));
            module = properties.getProperty("Module");
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }

        initEnvironment(codeBase, module);
    }

    public static void initEnvironment(URL codeBase)
    {
        Properties properties = new Properties();
        String module = null;
        try
        {
            properties.load(new URL(codeBase + CONFIG_PATH).openStream());
            module = properties.getProperty("Module");
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }

        initEnvironment(codeBase, module);
    }

    public static void initEnvironment(URL codeBase, String module)
    {
        ClientInvoker.registerServletPath(codeBase, module);
    }


    public static void initParameters(Map map)
    {
        parameters = map;
    }

    public static Map getParameters()
    {
        return parameters;
    }
}