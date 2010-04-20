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

import java.util.*;

public class InvokerHandle
    extends HashMap
{
    public static final String ACTION_KEY = "ActionKey";
    public static final String ACTION_CLASS = "ActionClass";

    public InvokerHandle()
    {
    }

    public String getActionKey()
    {
        return (String) get(ACTION_KEY);
    }

    public void setActionKey(String actionValue)
    {
        put(ACTION_KEY, actionValue);
    }

    public Class getActionClass()
    {
        return (Class) get(ACTION_CLASS);
    }

    public void setActionClass(Class actionClass)
    {
        put(ACTION_CLASS, actionClass);
    }
}