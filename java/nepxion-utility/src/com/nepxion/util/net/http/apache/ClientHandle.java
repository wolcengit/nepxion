package com.nepxion.util.net.http.apache;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.Iterator;

public class ClientHandle
	extends ArrayList
{
	public ClientHandle()
	{
	}
	
	public void put(String key, String value)
	{
		add(new ClientParameter(key, value));
	}
	
	public String get(String key)
	{
		for (Iterator iterator = iterator(); iterator.hasNext();)
		{
			ClientParameter clientParameter = (ClientParameter) iterator.next();
			if (clientParameter.getName().equals(key))
			{
				return clientParameter.getValue();
			}
		}
		return null;
	}
}