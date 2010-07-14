package com.nepxion.util.searcher.ip.local;

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
		return country.trim().equals("CZ88.NET") ?  "" : country.trim();
	}
	
	public void setCountry(String country)
	{
		this.country = country;
	}
	
	public String getRegion()
	{
		return region.trim().equals("CZ88.NET") ?  "" : region.trim();
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