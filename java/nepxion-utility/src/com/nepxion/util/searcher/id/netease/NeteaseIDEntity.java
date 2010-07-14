package com.nepxion.util.searcher.id.netease;

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

public class NeteaseIDEntity
	implements Serializable
{
	private static final long serialVersionUID = -7973227106071684695L;
	
	private String code;
	private String location;
	private String birthday;
	private String gender;
	
	public NeteaseIDEntity()
	{
		
	}
	
	public String getCode()
	{
		return code;
	}
	
	public void setCode(String code)
	{
		this.code = code;
	}
	
	public String getLocation()
	{
		return location;
	}
	
	public void setLocation(String location)
	{
		this.location = location;
	}
	
	public String getBirthday()
	{
		return birthday;
	}
	
	public void setBirthday(String birthday)
	{
		this.birthday = birthday;
	}
	
	public String getGender()
	{
		return gender;
	}
	
	public void setGender(String gender)
	{
		this.gender = gender;
	}
}