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

public class GeoCoordinateSeeker
	extends BasicGeoParser
{
	public static final int DEFAULT_MCC = 460;
	public static final int DEFAULT_MNC = 0;
	
	protected boolean requestAddress = true;
	protected String addressLanguage = ADDRESS_LANGUAGE_ZH_CN;
	
	public GeoCoordinateSeeker()
	{
		this(true);
	}
	
	public GeoCoordinateSeeker(String charset)
	{
		this(true, ADDRESS_LANGUAGE_ZH_CN, charset);
	}
	
	public GeoCoordinateSeeker(boolean requestAddress)
	{
		this(requestAddress, ADDRESS_LANGUAGE_ZH_CN);
	}	
	
	public GeoCoordinateSeeker(boolean requestAddress, String addressLanguage)
	{
		this(requestAddress, addressLanguage, "UTF-8");
	}	
	
	public GeoCoordinateSeeker(boolean requestAddress, String addressLanguage, String charset)
	{
		super(charset);
		
		this.requestAddress = requestAddress;
		this.addressLanguage = addressLanguage;
	}
		
	public Geo getGeo(int cellID, int lac)
	{
		String geoText = getGeoText(cellID, lac);
		return parseGeo(geoText);
	}
	
	public Geo getGeo(int cellID, int lac, int mcc, int mnc)
	{
		String geoText = getGeoText(cellID, lac, mcc, mnc);
		return parseGeo(geoText);
	}
	
	public String getGeoText(int cellID, int lac)
	{
		return getGeoText(cellID, lac, DEFAULT_MCC, DEFAULT_MNC);
	}

	/**
	 * @param cellID  全球唯一的小区ID
	 * @param lac     全球唯一的位置码
	 * @param mcc     移动国家号码，中国为460
	 * @param mnc     移动网号，中国移动为00，中国中国联通为01
	 */
	public String getGeoText(int cellID, int lac, int mcc, int mnc)
	{
		String jsonText = parseJSONText(cellID, lac, mcc, mnc);
		return getResponseText(jsonText);
	}
	
	private String parseJSONText(int cellID, int lac, int mcc, int mnc)
	{
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("{\n");
		stringBuffer.append("  \"version\": \"1.1.0\",\n");
		stringBuffer.append("  \"host\": \"maps.google.com\",\n");
		
		stringBuffer.append("  \"request_address\": " + requestAddress + ",\n");
		stringBuffer.append("  \"address_language\": \"" + addressLanguage + "\",\n");
		
		stringBuffer.append("  \"cell_towers\": \n");
		stringBuffer.append("  [\n");		
		stringBuffer.append("    {\n");
		stringBuffer.append("      \"cell_id\": " + cellID + ",\n");
		stringBuffer.append("      \"location_area_code\": " + lac + ",\n");
		stringBuffer.append("      \"mobile_country_code\": " + mcc + ",\n");
		stringBuffer.append("      \"mobile_network_code\": " + mnc + "\n");
		stringBuffer.append("    }\n");
		stringBuffer.append("  ]\n");
		stringBuffer.append("}");
		return stringBuffer.toString();
	}
	
	public static void main(String[] args)
	{
		GeoCoordinateSeeker geoCoordinateSeeker = new GeoCoordinateSeeker();
		
		Geo geo = geoCoordinateSeeker.getGeo(19625, 22770);
		System.out.println("latitude : " + geo.getLatitude());
		System.out.println("longitude : " + geo.getLongitude());
		System.out.println("address : " + geo);
	}
}