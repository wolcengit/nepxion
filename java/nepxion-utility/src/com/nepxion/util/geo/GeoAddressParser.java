package com.nepxion.util.geo;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

public class GeoAddressParser
	extends BasicGeoParser
{
	protected String addressLanguage = ADDRESS_LANGUAGE_ZH_CN;
	
	public GeoAddressParser()
	{
		this("UTF-8");
	}	
	
	public GeoAddressParser(String charset)
	{
		this(ADDRESS_LANGUAGE_ZH_CN, charset);
	}	
	
	public GeoAddressParser(String addressLanguage, String charset)
	{
		super(charset);
		
		this.addressLanguage = addressLanguage;
	}	
	
	public Geo getGeo(double latitude, double longitude)
	{
		String geoText = getGeoText(latitude, longitude);
		return parseGeo(geoText);
	}
	
	public String getGeoText(double latitude, double longitude)
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
		GeoAddressParser geoAddressParser = new GeoAddressParser();
		
		Geo geo = geoAddressParser.getGeo(30.16932, 120.160527);
		System.out.println("latitude : " + geo.getLatitude());
		System.out.println("longitude : " + geo.getLongitude());
		System.out.println("address : " + geo);	
	}
}