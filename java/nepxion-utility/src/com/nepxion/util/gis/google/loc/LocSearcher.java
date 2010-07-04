package com.nepxion.util.gis.google.loc;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.net.URI;

import org.json.JSONException;
import org.json.JSONObject;

import com.nepxion.util.net.http.apache.ClientInvoker;
import com.nepxion.util.net.http.apache.ClientRequestPost;

public class LocSearcher
{
	public static final String URL = "http://www.google.com/loc/json";
	public static final String LANGUAGE_ZH_CN = "zh_CN";
	public static final String LANGUAGE_EN_GB = "en_GB";
	public static final int DEFAULT_MCC = 460;
	public static final int DEFAULT_MNC = 0;
	
	protected String language = LANGUAGE_ZH_CN;
	protected String charset = "UTF-8";
	protected boolean requestAddress = true;
	
	protected ClientInvoker clientInvoker;
	
	public LocSearcher()
	{
		this(true);
	}
	
	public LocSearcher(boolean requestAddress)
	{
		this(LANGUAGE_ZH_CN, requestAddress);
	}
	
	public LocSearcher(String charset)
	{
		this(LANGUAGE_ZH_CN, charset);
	}
	
	public LocSearcher(String language, boolean requestAddress)
	{
		this(language, "UTF-8", requestAddress);
	}
	
	public LocSearcher(String language, String charset)
	{
		this(language, charset, true);
	}
	
	public LocSearcher(String language, String charset, boolean requestAddress)
	{
		this.language = language;
		this.charset = charset;
		this.requestAddress = requestAddress;
		
		clientInvoker = new ClientInvoker();
	}
	
	public LocEntity getLocEntity(int cellID, int lac)
	{
		return getLocEntity(cellID, lac, DEFAULT_MCC, DEFAULT_MNC);
	}
	
	public LocEntity getLocEntity(int cellID, int lac, int mcc, int mnc)
	{
		String requestText = createCellText(cellID, lac, mcc, mnc);
		String responseText = getResponseText(requestText);
		return createLocEntity(responseText);
	}
	
	public LocEntity getCoordinateEntity(double latitude, double longitude)
	{
		String requestText = createCoordinateText(latitude, longitude);
		String responseText = getResponseText(requestText);
		return createLocEntity(responseText);
	}
	
	/**
	 * @param latitude 纬度
	 * @param longitude 经度
	 */
	private String createCoordinateText(double latitude, double longitude)
	{
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("{\n");
		stringBuffer.append("  \"version\": \"1.1.0\",\n");
		stringBuffer.append("  \"host\": \"maps.google.com\",\n");
		
		stringBuffer.append("  \"request_address\": " + requestAddress + ",\n");
		stringBuffer.append("  \"address_language\": \"" + language + "\",\n");
		
		stringBuffer.append("  \"location\": \n");
		stringBuffer.append("  {\n");
		stringBuffer.append("    \"latitude\": " + latitude + ",\n");
		stringBuffer.append("    \"longitude\": " + longitude + "\n");
		stringBuffer.append("  }\n");
		stringBuffer.append("}");
		return stringBuffer.toString();
	}
	
	/**
	 * @param cellID 全球唯一的小区ID
	 * @param lac 全球唯一的位置码
	 * @param mcc 移动国家号码，中国为460
	 * @param mnc 移动网号，中国移动为00，中国中国联通为01
	 */
	private String createCellText(int cellID, int lac, int mcc, int mnc)
	{
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("{\n");
		stringBuffer.append("  \"version\": \"1.1.0\",\n");
		stringBuffer.append("  \"host\": \"maps.google.com\",\n");
		
		stringBuffer.append("  \"request_address\": " + requestAddress + ",\n");
		stringBuffer.append("  \"address_language\": \"" + language + "\",\n");
		
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
	
	private LocEntity createLocEntity(String jsonText)
	{
		if (jsonText.equals("") || jsonText.equals("{}"))
		{
			return null;
		}
		
		LocEntity locEntity = new LocEntity();
		try
		{
			JSONObject jsonObject = new JSONObject(jsonText);
			
			String accessToken = jsonObject.getString("access_token");
			locEntity.setAccessToken(accessToken);
			
			JSONObject locationJSONObject = (JSONObject) jsonObject.get("location");
			
			double latitude = locationJSONObject.getDouble("latitude");
			locEntity.setLatitude(latitude);
			
			double longitude = locationJSONObject.getDouble("longitude");
			locEntity.setLongitude(longitude);
			
			Object addressObject = locationJSONObject.get("address");
			if (addressObject != null)
			{
				JSONObject addressJSONObject = (JSONObject) addressObject;
				
				String country = addressJSONObject.getString("country");
				locEntity.setCountry(country);
				
				String countryCode = addressJSONObject.getString("country_code");
				locEntity.setCountryCode(countryCode);
				
				String region = addressJSONObject.getString("region");
				locEntity.setRegion(region);
				
				String city = addressJSONObject.getString("city");
				locEntity.setCity(city);
				
				String street = addressJSONObject.getString("street");
				locEntity.setStreet(street);
				
				String streetNumber = addressJSONObject.getString("street_number");
				locEntity.setStreetNumber(streetNumber);
				
				String postalCode = addressJSONObject.getString("postal_code");
				locEntity.setPostalCode(postalCode);
				
				double accuracy = addressJSONObject.getDouble("accuracy");
				locEntity.setAccuracy(accuracy);
			}
		}
		catch (JSONException e)
		{
			
		}
		return locEntity;
	}
	
	private String getResponseText(String requestText)
	{
		ClientRequestPost clientRequestPost = new ClientRequestPost();
		clientRequestPost.setURI(URI.create(URL));
		clientRequestPost.setStringEntity(requestText);
		
		String responseText = null;
		try
		{
			responseText = clientInvoker.getResponseText(clientRequestPost, charset);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return responseText;
	}
	
	public static void main(String[] args)
	{
		LocSearcher locSearcher = new LocSearcher();
		
		LocEntity coordinateEntity = locSearcher.getCoordinateEntity(31.231849, 121.475701);
		System.out.println("latitude : " + coordinateEntity.getLatitude());
		System.out.println("longitude : " + coordinateEntity.getLongitude());
		System.out.println("address : " + coordinateEntity);
		
		LocEntity locEntity = locSearcher.getLocEntity(19625, 22770);
		System.out.println("latitude : " + locEntity.getLatitude());
		System.out.println("longitude : " + locEntity.getLongitude());
		System.out.println("address : " + locEntity);		
	}
}