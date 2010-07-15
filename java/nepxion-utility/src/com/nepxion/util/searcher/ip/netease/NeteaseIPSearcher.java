package com.nepxion.util.searcher.ip.netease;

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
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;

import com.nepxion.util.net.http.apache.ClientInvoker;
import com.nepxion.util.net.http.apache.ClientParameter;
import com.nepxion.util.net.http.apache.ClientRequestGet;
import com.nepxion.util.xml.dom4j.Dom4JReader;

public class NeteaseIPSearcher
	implements NeteaseIPConstants
{
	private String charset = "GBK";
	private ClientInvoker clientInvoker;
	
	public NeteaseIPSearcher()
	{
		this("GBK");
	}
	
	public NeteaseIPSearcher(String charset)
	{
		this.charset = charset;
		
		this.clientInvoker = new ClientInvoker();
	}
	
	public NeteaseIPEntity search(String ip)
		throws Exception
	{
		String responseText = getResponseText(ip);
		return createIPEntity(responseText);
	}
	
	private NeteaseIPEntity createIPEntity(String xml)
	{
		if (xml == null || xml.equals(""))
		{
			return null;
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
		Element productElement = rootElement.element("product");
		
		NeteaseIPEntity ipEntity = new NeteaseIPEntity();
		
		Element ipElement = productElement.element("ip");
		ipEntity.setIP(ipElement.getText());
		
		Element locationElement = productElement.element("location");
		String location = locationElement.getText();
		String country = "";
		String region = "";
		int index = location.indexOf(" ");
		if (index > -1)
		{
			country = location.substring(0, index);
			region = location.substring(index + 1).equals("") ? location : location.substring(index + 1);
		}
		else
		{
			country = "";
			region = location;
		}
		ipEntity.setCountry(country);
		ipEntity.setRegion(region);
		
		return ipEntity;
	}
	
	private String getResponseText(String ip)
		throws Exception
	{
		ClientRequestGet clientRequestGet = new ClientRequestGet();
		clientRequestGet.setURI(URI.create(URL));
		
		List clientParameters = new ArrayList();
		clientParameters.add(new ClientParameter("q", ip));
		clientParameters.add(new ClientParameter("type", TYPE));
		clientRequestGet.setParameterEntity(clientParameters, charset);
		
		String responseText = clientInvoker.getResponseText(clientRequestGet, charset);
		return responseText;
	}
}