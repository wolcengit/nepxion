package com.nepxion.swing.topic;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.Component;

public class TopicContext
{
	private static Component topicComponent;
	
	public static void registerTopicComponent(Component customTopicComponent)
	{
		topicComponent = customTopicComponent;
	}
	
	public static void registerTopicComponent(String customTopicComponentClass)
	{
		if (customTopicComponentClass != null)
		{
			try
			{
				topicComponent = (Component) Class.forName(customTopicComponentClass).newInstance();
			}
			catch (InstantiationException e)
			{
				e.printStackTrace();
			}
			catch (IllegalAccessException e)
			{
				e.printStackTrace();
			}
			catch (ClassNotFoundException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public static Component getTopicComponent()
	{
		return topicComponent;
	}
}