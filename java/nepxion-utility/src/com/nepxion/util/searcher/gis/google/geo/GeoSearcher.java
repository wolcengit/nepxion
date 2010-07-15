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

import com.nepxion.util.net.http.apache.ClientInvoker;
import com.nepxion.util.net.http.apache.ClientParameterList;
import com.nepxion.util.net.http.apache.ClientRequestGet;
import com.nepxion.util.searcher.gis.google.loc.LocConstants;

public class GeoSearcher
	implements LocConstants
{	
	private String language = LANGUAGE_ZH_CN;
	private String charset = "UTF-8";
	
	private ClientInvoker clientInvoker;
	
	public GeoSearcher(String charset)
	{
		this.charset = charset;
		
		this.clientInvoker = new ClientInvoker();
	}
	
	public String getResponseText()
		throws Exception
	{
		ClientRequestGet clientRequestGet = new ClientRequestGet();
		clientRequestGet.setURI(URI.create(URL));
		
		ClientParameterList clientParameterList = new ClientParameterList();
		clientParameterList.put("q", "花木");
		clientParameterList.put("output", "json");
		clientParameterList.put("oe", "utf8");
		clientParameterList.put("sensor", "true");
		clientParameterList.put("hl", language);
		clientParameterList.put("key", "ABQIAAAAdFLRljp2TovFzTpwXuVkFhQIFToVApsHYtA6KVCnU06oztO8qxSsJArkYIMxAP20jJu9M7nmmAjLQg");
		clientRequestGet.setParameterEntity(clientParameterList, charset);
		
		String responseText = clientInvoker.getResponseText(clientRequestGet, charset);
		return responseText;
	}
}