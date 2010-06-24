package com.nepxion.util.geo.google;

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

public class Geo
	implements Serializable
{
	private double latitude;
	private double longitude;
	private String country = "";
	private String countryCode = "";
	private String region = "";
	private String city = "";
	private String street = "";
	private String streetNumber = "";
	private String postalCode = "";
	private double accuracy;
	private String accessToken;
	
	public Geo()
	{
		
	}
	
	public double getLatitude()
	{
		return latitude;
	}
	
	public void setLatitude(double latitude)
	{
		this.latitude = latitude;
	}
	
	public double getLongitude()
	{
		return longitude;
	}
	
	public void setLongitude(double longitude)
	{
		this.longitude = longitude;
	}
	
	public String getCountry()
	{
		return country;
	}
	
	public void setCountry(String country)
	{
		this.country = country;
	}
	
	public String getCountryCode()
	{
		return countryCode;
	}
	
	public void setCountryCode(String countryCode)
	{
		this.countryCode = countryCode;
	}
	
	public String getRegion()
	{
		return region;
	}
	
	public void setRegion(String region)
	{
		this.region = region;
	}
	
	public String getCity()
	{
		return city;
	}
	
	public void setCity(String city)
	{
		this.city = city;
	}
	
	public String getStreet()
	{
		return street;
	}
	
	public void setStreet(String street)
	{
		this.street = street;
	}
	
	public String getStreetNumber()
	{
		return streetNumber;
	}
	
	public void setStreetNumber(String streetNumber)
	{
		this.streetNumber = streetNumber;
	}
	
	public String getPostalCode()
	{
		return postalCode;
	}
	
	public void setPostalCode(String postalCode)
	{
		this.postalCode = postalCode;
	}
	
	public double getAccuracy()
	{
		return accuracy;
	}
	
	public void setAccuracy(double accuracy)
	{
		this.accuracy = accuracy;
	}
	
	public String getAccessToken()
	{
		return accessToken;
	}
	
	public void setAccessToken(String accessToken)
	{
		this.accessToken = accessToken;
	}
	
	public String toString()
	{
		return country + region + city + street + streetNumber;
	}
}