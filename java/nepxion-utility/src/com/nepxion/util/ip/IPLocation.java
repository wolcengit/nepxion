package com.nepxion.util.ip;

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

public class IPLocation
	implements Serializable
{
	private static final long serialVersionUID = 5429316904963543813L;

	private String country;
	private String region;
	
	public IPLocation()
	{
		country = "";
		region = "";
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
	
	public IPLocation clone()
	{
		IPLocation ipLocation = new IPLocation();
		ipLocation.country = country;
		ipLocation.region = region;
		return ipLocation;
	}
}