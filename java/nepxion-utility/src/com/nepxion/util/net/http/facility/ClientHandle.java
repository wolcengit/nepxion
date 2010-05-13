package com.nepxion.util.net.http.facility;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.util.HashMap;

import com.nepxion.util.net.http.IClientHandle;

public class ClientHandle
    extends HashMap implements IClientHandle
{
    public static final String ACTION_KEY = "ActionKey";
    public static final String ACTION_CLASS = "ActionClass";

    public ClientHandle()
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