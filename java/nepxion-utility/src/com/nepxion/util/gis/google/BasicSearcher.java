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

import java.net.URI;

import org.json.JSONException;
import org.json.JSONObject;

import com.nepxion.util.net.http.apache.ClientInvoker;
import com.nepxion.util.net.http.apache.ClientRequestPost;

public class BasicSearcher
{
	public static final String URL = "http://www.google.com/loc/json";
	
	public static final String ADDRESS_LANGUAGE_ZH_CN = "zh_CN";
	public static final String ADDRESS_LANGUAGE_EN_GB = "en_GB";
	
	protected String charset;
	protected ClientInvoker clientInvoker;
	
	public BasicSearcher(String charset)
	{
		this.charset = charset;
		this.clientInvoker = new ClientInvoker();
	}
	
	public String getResponseText(String jsonText)
	{
		ClientRequestPost clientRequestPost = new ClientRequestPost();
		clientRequestPost.setURI(URI.create(URL));
		clientRequestPost.setStringEntity(jsonText);
		
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
	
	public GisEntity parseGisEntity(String jsonText)
	{
		if (jsonText.equals("") || jsonText.equals("{}"))
		{
			return null;
		}
		
		GisEntity gisEntity = new GisEntity();
		try
		{
			JSONObject jsonObject = new JSONObject(jsonText);
			
			String accessToken = jsonObject.getString("access_token");
			gisEntity.setAccessToken(accessToken);
			
			JSONObject locationJSONObject = (JSONObject) jsonObject.get("location");
			
			double latitude = locationJSONObject.getDouble("latitude");
			gisEntity.setLatitude(latitude);
			
			double longitude = locationJSONObject.getDouble("longitude");
			gisEntity.setLongitude(longitude);			
			
			Object addressObject = locationJSONObject.get("address");
			if (addressObject != null)
			{
				JSONObject addressJSONObject = (JSONObject) addressObject;
				
				String country = addressJSONObject.getString("country");
				gisEntity.setCountry(country);
				
				String countryCode = addressJSONObject.getString("country_code");
				gisEntity.setCountryCode(countryCode);
				
				String region = addressJSONObject.getString("region");
				gisEntity.setRegion(region);
				
				String city = addressJSONObject.getString("city");
				gisEntity.setCity(city);
				
				String street = addressJSONObject.getString("street");
				gisEntity.setStreet(street);
				
				String streetNumber = addressJSONObject.getString("street_number");
				gisEntity.setStreetNumber(streetNumber);
				
				String postalCode = addressJSONObject.getString("postal_code");
				gisEntity.setPostalCode(postalCode);				
				
				double accuracy = addressJSONObject.getDouble("accuracy");
				gisEntity.setAccuracy(accuracy);
			}
		}
		catch (JSONException e)
		{

		}
		return gisEntity;
	}
}