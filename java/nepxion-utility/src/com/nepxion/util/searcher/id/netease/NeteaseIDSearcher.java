package com.nepxion.util.searcher.id.netease;

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

public class NeteaseIDSearcher
	implements NeteaseIDConstants
{
	private String charset = "GBK";
	private ClientInvoker clientInvoker;
	
	public NeteaseIDSearcher()
	{
		this("GBK");
	}
	
	public NeteaseIDSearcher(String charset)
	{
		this.charset = charset;
		
		this.clientInvoker = new ClientInvoker();
	}
	
	public NeteaseIDEntity search(String id)
		throws Exception
	{
		String responseText = getResponseText(id);
		return createIDEntity(responseText);
	}
	
	private NeteaseIDEntity createIDEntity(String xml)
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
		
		NeteaseIDEntity idEntity = new NeteaseIDEntity();
		
		Element codeElement = productElement.element("code");
		idEntity.setCode(codeElement.getText());
		
		Element locationElement = productElement.element("location");
		idEntity.setLocation(locationElement.getText());
		
		Element birthdayElement = productElement.element("birthday");
		String birthday = birthdayElement.getText();
		birthday = birthday.substring(0, 4) + "年" + birthday.substring(4, 6) + "月" + birthday.substring(6) + "日";
		idEntity.setBirthday(birthday);
		
		Element genderElement = productElement.element("gender");
		String gender = genderElement.getText();
		if (gender.equals("m"))
		{
			gender = "男";
		}
		else if (gender.equals("f"))
		{
			gender = "女";
		}
		else
		{
			gender = "未知";
		}
		idEntity.setGender(gender);
		
		return idEntity;
	}
	
	private String getResponseText(String id)
		throws Exception
	{
		ClientRequestGet clientRequestGet = new ClientRequestGet();
		clientRequestGet.setURI(URI.create(URL));
		
		List clientParameters = new ArrayList();
		clientParameters.add(new ClientParameter("q", id));
		clientParameters.add(new ClientParameter("type", TYPE));
		clientRequestGet.setParameterEntity(clientParameters, charset);
		
		String responseText = clientInvoker.getResponseText(clientRequestGet, charset);
		return responseText;
	}
}