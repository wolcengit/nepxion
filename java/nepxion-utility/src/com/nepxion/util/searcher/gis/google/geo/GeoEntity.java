package com.nepxion.util.searcher.gis.google.geo;

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

public class GeoEntity
	implements Serializable
{
	private static final long serialVersionUID = 6363021430950951419L;
	
	private String address;
	private double centerLatitude;
	private double centerLongitude;
	private double northLatitude;
	private double eastLongitude;
	private double southLatitude;
	private double westLongitude;
	
	public String getAddress()
	{
		return address;
	}
	
	public void setAddress(String address)
	{
		this.address = address;
	}
	
	public double getCenterLatitude()
	{
		return centerLatitude;
	}
	
	public void setCenterLatitude(double centerLatitude)
	{
		this.centerLatitude = centerLatitude;
	}
	
	public double getCenterLongitude()
	{
		return centerLongitude;
	}
	
	public void setCenterLongitude(double centerLongitude)
	{
		this.centerLongitude = centerLongitude;
	}
	
	public double getNorthLatitude()
	{
		return northLatitude;
	}
	
	public void setNorthLatitude(double northLatitude)
	{
		this.northLatitude = northLatitude;
	}
	
	public double getEastLongitude()
	{
		return eastLongitude;
	}
	
	public void setEastLongitude(double eastLongitude)
	{
		this.eastLongitude = eastLongitude;
	}
	
	public double getSouthLatitude()
	{
		return southLatitude;
	}
	
	public void setSouthLatitude(double southLatitude)
	{
		this.southLatitude = southLatitude;
	}
	
	public double getWestLongitude()
	{
		return westLongitude;
	}
	
	public void setWestLongitude(double westLongitude)
	{
		this.westLongitude = westLongitude;
	}
}