package com.nepxion.util.searcher.ip.sina;

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
import java.util.StringTokenizer;

import com.nepxion.util.net.http.apache.ClientInvoker;
import com.nepxion.util.net.http.apache.ClientParameterList;
import com.nepxion.util.net.http.apache.ClientRequestGet;

public class SinaIPSearcher
	implements SinaIPConstants
{
	private String charset = "GBK";
	private ClientInvoker clientInvoker;
	
	public SinaIPSearcher()
	{
		this("GBK");
	}
	
	public SinaIPSearcher(String charset)
	{
		this.charset = charset;
		
		this.clientInvoker = new ClientInvoker();
	}
	
	public SinaIPEntity search(String ip)
		throws Exception
	{
		String text = getText(ip);
		return createEntity(text);
	}
	
	public SinaIPEntity search()
		throws Exception
	{
		String text = getText(null);
		return createEntity(text);
	}
	
	private SinaIPEntity createEntity(String text)
	{
		if (text == null || text.equals(""))
		{
			return null;
		}
		
		SinaIPEntity ipEntity = new SinaIPEntity();
		
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
		
		String corp = stringTokenizer.nextToken();
		corp = corp.substring(corp.indexOf("\"") + 1);
		corp = corp.substring(0, corp.indexOf("\""));
		ipEntity.setCorp(corp);
		
		return ipEntity;
	}
	
	public String getText(String ip)
		throws Exception
	{
		ClientRequestGet clientRequestGet = new ClientRequestGet();
		clientRequestGet.setURI(URI.create(URL));
		
		if (ip != null)
		{
			ClientParameterList clientParameterList = new ClientParameterList();
			clientParameterList.put("ip", ip);
			clientRequestGet.setParameterEntity(clientParameterList, charset);
		}
		
		String responseText = clientInvoker.getResponseText(clientRequestGet, charset);
		return responseText;
	}
}