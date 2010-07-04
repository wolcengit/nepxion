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

public class IPEntry
	extends IPLocation
{
	private String beginIP;
	private String endIP;
	
	public IPEntry()
	{
		beginIP = "";
		endIP = "";
	}
	
	public String getBeginIP()
	{
		return beginIP;
	}
	
	public void setBeginIP(String beginIP)
	{
		this.beginIP = beginIP;
	}
	
	public String getEndIP()
	{
		return endIP;
	}
	
	public void setEndIP(String endIP)
	{
		this.endIP = endIP;
	}
}