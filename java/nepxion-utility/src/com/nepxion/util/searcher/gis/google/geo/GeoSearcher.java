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

import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;

import com.nepxion.util.locale.LocaleConstants;
import com.nepxion.util.net.http.apache.ClientInvoker;
import com.nepxion.util.net.http.apache.ClientParameterList;
import com.nepxion.util.net.http.apache.ClientRequestGet;
import com.nepxion.util.xml.dom4j.Dom4JReader;

public class GeoSearcher
	implements GeoConstants, LocaleConstants
{
	private String language = ZH_CN;
	private String charset = "UTF-8";
	
	private ClientInvoker clientInvoker;
	
	public GeoSearcher()
	{
		this(ZH_CN);
	}
	
	public GeoSearcher(String language)
	{
		this(language, "UTF-8");
	}
	
	public GeoSearcher(String language, String charset)
	{
		this.language = language;
		this.charset = charset;
		
		this.clientInvoker = new ClientInvoker();
	}
	
	public List search(String address)
		throws Exception
	{
		String xml = getXML(address);
		return createEntityList(xml);
	}
	
	private List createEntityList(String xml)
	{
		List list = new ArrayList();
		if (xml == null || xml.equals(""))
		{
			return list;
		}
		Document document = null;
		try
		{
			document = Dom4JReader.getDocument(xml);
		}
		catch (DocumentException e)
		{
			e.printStackTrace();
		}
		Element rootElement = document.getRootElement();
		Element responseElement = rootElement.element("Response");
		for (Iterator elementIterator = responseElement.elementIterator(); elementIterator.hasNext();)
		{
			Object childElementObject = elementIterator.next();
			if (childElementObject instanceof Element)
			{
				Element childElement = (Element) childElementObject;
				String name = childElement.getName();
				if (name.equals("Placemark"))
				{
					GeoEntity geoEntity = new GeoEntity();
					
					Element addressElement = childElement.element("address");
					geoEntity.setAddress(addressElement.getText());
					
					Element extendedDataElement = childElement.element("ExtendedData");
					Element latLonBoxElement = extendedDataElement.element("LatLonBox");
					Attribute northAttribute = latLonBoxElement.attribute("north");
					geoEntity.setNorthLatitude(Double.parseDouble(northAttribute.getText()));
					
					Attribute southAttribute = latLonBoxElement.attribute("south");
					geoEntity.setSouthLatitude(Double.parseDouble(southAttribute.getText()));
					
					Attribute eastAttribute = latLonBoxElement.attribute("east");
					geoEntity.setEastLongitude(Double.parseDouble(eastAttribute.getText()));					
					
					Attribute westAttribute = latLonBoxElement.attribute("west");
					geoEntity.setWestLongitude(Double.parseDouble(westAttribute.getText()));
					
					Element pointElement = childElement.element("Point");
					Element coordinatesElement = pointElement.element("coordinates");
					String coordinatesText = coordinatesElement.getText();
					
					StringTokenizer stringTokenizer = new StringTokenizer(coordinatesText, ",");
					
					String centerLongitude = stringTokenizer.nextToken();
					geoEntity.setCenterLongitude(Double.parseDouble(centerLongitude));
					
					String centerLatitude = stringTokenizer.nextToken();
					geoEntity.setCenterLatitude(Double.parseDouble(centerLatitude));
					
					list.add(geoEntity);
				}
			}
		}
		return list;
	}
	
	public String getXML(String address)
		throws Exception
	{
		ClientRequestGet clientRequestGet = new ClientRequestGet();
		clientRequestGet.setURI(URI.create(URL));
		
		ClientParameterList clientParameterList = new ClientParameterList();
		clientParameterList.put("q", address);
		clientParameterList.put("output", "xml");
		clientParameterList.put("oe", "utf8");
		clientParameterList.put("sensor", "true");
		clientParameterList.put("hl", language);
		clientParameterList.put("key", KEY);
		clientRequestGet.setParameterEntity(clientParameterList, charset);
		
		String responseText = clientInvoker.getResponseText(clientRequestGet, charset);
		return responseText;
	}
}