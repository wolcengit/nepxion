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
	
	public static void registerTopicComponent(Component topicComponent)
	{
		TopicContext.topicComponent = topicComponent;
	}
	
	public static void registerTopicComponent(String topicComponentClass)
	{
		if (topicComponentClass != null)
		{
			try
			{
				topicComponent = (Component) Class.forName(topicComponentClass).newInstance();
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