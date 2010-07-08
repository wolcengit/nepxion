package com.nepxion.util.scheduler.quartz;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import org.quartz.JobDetail;

public class QuartzJobDetail
	extends JobDetail
{
	public QuartzJobDetail()
	{
		super();
	}
	
	public QuartzJobDetail(String name, Class jobClass)
	{
		super(name, jobClass);
	}
	
	public QuartzJobDetail(String name, String group, Class jobClass)
	{
		super(name, group, jobClass);
	}
	
	public QuartzJobDetail(String name, String group, Class jobClass, boolean volatility, boolean durability, boolean recover)
	{
		super(name, group, jobClass, volatility, durability, recover);
	}
}