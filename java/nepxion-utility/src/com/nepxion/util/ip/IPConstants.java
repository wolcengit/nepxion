package com.nepxion.util.ip;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import com.nepxion.util.io.FileUtil;

public interface IPConstants
{
	public static final String DATA_FILE_PATH = "data/ip.dat";
	public static final String DATA_FILE_TEMP_PATH = FileUtil.getTempDirectory() + "ip.dat";
	
	public static final String VERSION_DATE = "2010-07-10 19:12:10";
	public static final int TOTAL_COUNT = 379809;
}