package com.nepxion.util.searcher.mobile.netease;

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

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;

import com.nepxion.util.net.http.apache.ClientInvoker;
import com.nepxion.util.net.http.apache.ClientParameterList;
import com.nepxion.util.net.http.apache.ClientRequestGet;
import com.nepxion.util.xml.dom4j.Dom4JReader;

public class NeteaseMobileSearcher
	implements NeteaseMobileConstants
{
	private String charset = "GBK";
	private ClientInvoker clientInvoker;
	
	public NeteaseMobileSearcher()
	{
		this("GBK");
	}
	
	public NeteaseMobileSearcher(String charset)
	{
		this.charset = charset;
		
		this.clientInvoker = new ClientInvoker();
	}
	
	public NeteaseMobileEntity search(String mobile)
		throws Exception
	{
		String xml = getXML(mobile);
		return createEntity(xml);
	}
	
	private NeteaseMobileEntity createEntity(String xml)
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
		
		NeteaseMobileEntity mobileEntity = new NeteaseMobileEntity();
		
		Element codeElement = productElement.element("phonenum");
		mobileEntity.setMobile(codeElement.getText());
		
		Element locationElement = productElement.element("location");
		String location = locationElement.getText();
		String province = "";
		String city = "";
		int index = location.indexOf(" ");
		if (index > -1)
		{	
			province = location.substring(0, index);
			city = location.substring(index + 1).equals("") ? location : location.substring(index + 1);
		}
		else
		{
			province = location;
			city = location;
		}
		mobileEntity.setProvince(province);
		mobileEntity.setCity(city);
		
		return mobileEntity;
	}
	
	public String getXML(String mobile)
		throws Exception
	{
		ClientRequestGet clientRequestGet = new ClientRequestGet();
		clientRequestGet.setURI(URI.create(URL));
		
		ClientParameterList clientParameterList = new ClientParameterList();
		clientParameterList.put("q", mobile);
		clientParameterList.put("type", TYPE);
		clientRequestGet.setParameterEntity(clientParameterList, charset);
		
		String responseText = clientInvoker.getResponseText(clientRequestGet, charset);
		return responseText;
	}
}