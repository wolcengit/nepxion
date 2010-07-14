package com.nepxion.util.searcher.mobile.locating;

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

public class LocatingMobileEntity
	implements Serializable
{
	private static final long serialVersionUID = 7370379740504826892L;
	
	private String mobile;
	private String province;
	private String city;
	private String areaCode;
	private String postCode;
	private String corp;
	private String card;
		
	public LocatingMobileEntity()
	{
		
	}
	
	public String getMobile()
	{
		return mobile;
	}
	
	public void setMobile(String mobile)
	{
		this.mobile = mobile;
	}
	
	public String getProvince()
	{
		return province;
	}
	
	public void setProvince(String province)
	{
		this.province = province;
	}
	
	public String getCity()
	{
		return city;
	}
	
	public void setCity(String city)
	{
		this.city = city;
	}
	
	public String getAreaCode()
	{
		return areaCode;
	}
	
	public void setAreaCode(String areaCode)
	{
		this.areaCode = areaCode;
	}
	
	public String getPostCode()
	{
		return postCode;
	}
	
	public void setPostCode(String postCode)
	{
		this.postCode = postCode;
	}
	
	public String getCorp()
	{
		return corp;
	}
	
	public void setCorp(String corp)
	{
		this.corp = corp;
	}
	
	public String getCard()
	{
		return card;
	}
	
	public void setCard(String card)
	{
		this.card = card;
	}
}