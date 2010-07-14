package com.nepxion.util.searcher.google.geo;

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

import com.nepxion.util.net.http.apache.ClientInvoker;
import com.nepxion.util.net.http.apache.ClientParameter;
import com.nepxion.util.net.http.apache.ClientRequestGet;
import com.nepxion.util.searcher.google.loc.LocConstants;

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
		
		List clientParameters = new ArrayList();
		clientParameters.add(new ClientParameter("q", "花木"));
		clientParameters.add(new ClientParameter("output", "json"));
		clientParameters.add(new ClientParameter("oe", "utf8"));
		clientParameters.add(new ClientParameter("sensor", "true"));
		clientParameters.add(new ClientParameter("hl", language));
		clientParameters.add(new ClientParameter("key", "ABQIAAAAdFLRljp2TovFzTpwXuVkFhQIFToVApsHYtA6KVCnU06oztO8qxSsJArkYIMxAP20jJu9M7nmmAjLQg"));
		clientRequestGet.setParameterEntity(clientParameters, charset);
		
		String responseText = clientInvoker.getResponseText(clientRequestGet, charset);
		return responseText;
	}
}