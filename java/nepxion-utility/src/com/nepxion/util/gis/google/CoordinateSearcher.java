package com.nepxion.util.gis.google;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

public class CoordinateSearcher
	extends BasicSearcher
{
	protected String addressLanguage = ADDRESS_LANGUAGE_ZH_CN;
	
	public CoordinateSearcher()
	{
		this("UTF-8");
	}	
	
	public CoordinateSearcher(String charset)
	{
		this(ADDRESS_LANGUAGE_ZH_CN, charset);
	}	
	
	public CoordinateSearcher(String addressLanguage, String charset)
	{
		super(charset);
		
		this.addressLanguage = addressLanguage;
	}	
	
	public GisEntity getGisEntity(double latitude, double longitude)
	{
		String gisText = getGisText(latitude, longitude);
		return parseGisEntity(gisText);
	}
	
	public String getGisText(double latitude, double longitude)
	{
		String jsonText = parseJSONText(latitude, longitude);
		return getResponseText(jsonText);
	}
		
	private String parseJSONText(double latitude, double longitude)
	{
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("{\n");
		stringBuffer.append("  \"version\": \"1.1.0\",\n");
		stringBuffer.append("  \"host\": \"maps.google.com\",\n");
		
		stringBuffer.append("  \"request_address\": true,\n");
		stringBuffer.append("  \"address_language\": \"" + addressLanguage + "\",\n");
		
		stringBuffer.append("  \"location\": \n");
		stringBuffer.append("  {\n");
		stringBuffer.append("    \"latitude\": " + latitude + ",\n");
		stringBuffer.append("    \"longitude\": " + longitude + "\n");
		stringBuffer.append("  }\n");
		stringBuffer.append("}");
		return stringBuffer.toString();
	}
	
	public static void main(String[] args)
	{
		CoordinateSearcher addressSearcher = new CoordinateSearcher();
		
		GisEntity gisEntity = addressSearcher.getGisEntity(30.16932, 120.160527);
		System.out.println("latitude : " + gisEntity.getLatitude());
		System.out.println("longitude : " + gisEntity.getLongitude());
		System.out.println("address : " + gisEntity);	
	}
}