package com.nepxion.util.gis.google.geo;

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

import com.nepxion.util.gis.google.loc.LocConstants;
import com.nepxion.util.net.http.apache.ClientInvoker;
import com.nepxion.util.net.http.apache.ClientParameter;
import com.nepxion.util.net.http.apache.ClientRequestGet;

public class GeoSearcher
	implements LocConstants
{	
	protected String charset;
	protected ClientInvoker clientInvoker;
	
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
		clientParameters.add(new ClientParameter("hl", "en_GB"));
		clientParameters.add(new ClientParameter("key", "ABQIAAAAdFLRljp2TovFzTpwXuVkFhQIFToVApsHYtA6KVCnU06oztO8qxSsJArkYIMxAP20jJu9M7nmmAjLQg"));
		clientRequestGet.setParameterEntity(clientParameters, "UTF-8");
		
		String responseText = clientInvoker.getResponseText(clientRequestGet, "UTF-8");
		return responseText;
	}
}