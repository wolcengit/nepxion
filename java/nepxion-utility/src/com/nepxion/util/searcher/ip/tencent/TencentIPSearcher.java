package com.nepxion.util.searcher.ip.tencent;

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
import java.util.StringTokenizer;

import com.nepxion.util.net.http.apache.ClientInvoker;
import com.nepxion.util.net.http.apache.ClientRequestGet;

public class TencentIPSearcher
	implements TencentIPConstants
{
	private String charset = "GBK";
	private ClientInvoker clientInvoker;
	
	public TencentIPSearcher()
	{
		this("GBK");
	}
	
	public TencentIPSearcher(String charset)
	{
		this.charset = charset;
		
		this.clientInvoker = new ClientInvoker();
	}
	
	public TencentIPEntity search()
		throws Exception
	{
		String text = getText();
		return createEntity(text);
	}
	
	private TencentIPEntity createEntity(String text)
	{
		if (text == null || text.equals(""))
		{
			return null;
		}
		
		TencentIPEntity ipEntity = new TencentIPEntity();
		
		StringTokenizer stringTokenizer = new StringTokenizer(text, ",");
		
		String ip = stringTokenizer.nextToken();
		ip = ip.substring(ip.indexOf("\"") + 1, ip.lastIndexOf("\""));
		ipEntity.setIP(ip);
		
		String country = stringTokenizer.nextToken();
		country = country.substring(country.indexOf("\"") + 1, country.lastIndexOf("\""));
		ipEntity.setCountry(country);
		
		String province = stringTokenizer.nextToken();
		province = province.substring(province.indexOf("\"") + 1, province.lastIndexOf("\""));
		ipEntity.setProvince(province);
		
		String city = stringTokenizer.nextToken();
		city = city.substring(city.indexOf("\"") + 1, city.lastIndexOf("\""));
		ipEntity.setCity(city);
		
		return ipEntity;
	}
	
	public String getText()
		throws Exception
	{
		ClientRequestGet clientRequestGet = new ClientRequestGet();
		clientRequestGet.setURI(URI.create(URL));
		
		List clientParameters = new ArrayList();
		clientRequestGet.setParameterEntity(clientParameters, charset);
		
		String responseText = clientInvoker.getResponseText(clientRequestGet, charset);
		return responseText;
	}
}