package com.nepxion.util.searcher.ip.netease;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.io.Serializable;

public class NeteaseIPEntity
	implements Serializable
{
	private static final long serialVersionUID = 7048603907416561396L;
	
	private String ip;
	private String country;
	private String region;
	
	public NeteaseIPEntity()
	{
		
	}
	
	public String getIP()
	{
		return ip;
	}
	
	public void setIP(String ip)
	{
		this.ip = ip;
	}
	
	public String getCountry()
	{
		return country;
	}
	
	public void setCountry(String country)
	{
		this.country = country;
	}
	
	public String getRegion()
	{
		return region;
	}
	
	public void setRegion(String region)
	{
		this.region = region;
	}
	
	public String getLocation()
	{
		return getCountry() + getRegion();
	}
}