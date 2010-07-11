package com.nepxion.util.net.http;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.io.Serializable;

public interface HttpConstants
	extends Serializable
{
	public static final String CONFIG_FILE_PATH = "conf/http.properties";
	
	public static final String PREFIX = "http";
	public static final String DOT = ".";
	
	public static final String DEFAULT_ALIAS = "DefaultHttp";
	public static final int DEFAULT_CONNECTION_TIMEOUT = 0;
	public static final int DEFAULT_RESPONSE_TIMEOUT = 0;
	public static final int DEFAULT_BUFFER_SIZE = 8192;
	
	public static final String ALIAS = "alias";
	public static final String HOST = "host";
	public static final String PORT = "port";
	public static final String PATH = "path";
	public static final String CONNECTION_TIMEOUT = "connection-timeout";
	public static final String RESPONSE_TIMEOUT = "response-timeout";
	public static final String BUFFER_SIZE = "buffer-size";
}